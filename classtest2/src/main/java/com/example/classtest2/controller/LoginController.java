package com.example.classtest2.controller;

import com.example.classtest2.entity.Role;
import com.example.classtest2.entity.User;
import com.example.classtest2.repo.RoleRepo;
import com.example.classtest2.repo.UserRepo;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private static String USER_NAME = "mortoza.cse";
    private static String PASSWORD = "mortozacse123";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)){
            /* The User is Logged in :)  */
            return "redirect:/";
        }
        return "public/login";
    }

    @GetMapping(value = "/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

    @PostMapping(value = "/sign-up")
    public String add(@Valid User user, BindingResult result, Model model, HttpServletRequest request) {
        String username = user.getEmail().split("\\@")[0];
        user.setUsername(username);
        user.setStatus(false);
        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(roleRepo.findByRoleName("USER").get().getId()));
        roles.add(new Role(3l));
        user.setRegiDate(new Date());
        user.setRole(roles);
        user.setConformationToken(UUID.randomUUID().toString());

        if (result.hasErrors()) {
            model.addAttribute("rejectMsg", "opps, Something Wrong");
            return "signup";
        }
        if (userRepo.existsByEmail(user.getEmail())) {
            model.addAttribute("rejectMsg", "Already Have This Entry");
            return "signup";
        } else {

            this.userRepo.save(user);
            //email sending
            // 172.16.185.51
            //String appUrl = request.getScheme() + "://" + request.getServerName()+":"+"8008";
            String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + "8081";
            String from = USER_NAME;
            String pass = PASSWORD;
            String[] to = {user.getEmail()}; // list of recipient email addresses
            String subject = "Registration Confirmation";
            String body = "To confirm your e-mail address, please click the link below:\n"
                    + appUrl + "/confirm?token=" + user.getConformationToken();

            sendFromGMail(from, pass, to, subject, body);

            model.addAttribute("successMsg", "A confirmation e-mail has been sent to " + user.getEmail());
        }

        return "signup";
    }

    @GetMapping(value = "/sign-up")
    public String viewSignUp(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("mortoza.cse@gmail.com", "SHOPNO CHAIYA PVT Limited, Bangladesh"));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Email sending Success!!!");
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Process confirmation link
    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam(value = "token", required = false) String token) {
        try {
            if (token.isEmpty()) {
                modelAndView.addObject("invalidToken", "Oops!  No Token Exist.");
                modelAndView.setViewName("confirm");
            } else {
                User user = userRepo.findByConformationToken(token);

                if (user == null) { // No token found in DB
                    modelAndView.addObject("invalidToken", "Oops!  invalid confirmation link. Or Expired");
                } else { // Token found
                    modelAndView.addObject("confirmationToken", user.getConformationToken());
                }
            }
        }catch (NullPointerException ne){
            modelAndView.addObject("invalidToken", "Oops!  No Token Exist.");
            modelAndView.setViewName("confirm");
        }
        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        modelAndView.setViewName("confirm");

        Zxcvbn passwordCheck = new Zxcvbn();

        Strength strength = passwordCheck.measure(requestParams.get("password"));

        if (strength.getScore() < 3) {
            //modelAndView.addObject("errorMessage", "Your password is too weak.  Choose a stronger one.");
            bindingResult.reject("password");

            redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

            modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
            //	System.out.println(requestParams.get("token"));
            return modelAndView;
        }

        // Find the user associated with the reset token
        User user = userRepo.findByConformationToken(requestParams.get("token"));

        // Set new password
        user.setPassword(passwordEncoder.encode(requestParams.get("password")));
        // Set user to enabled
        user.setStatus(true);

        // Save user
        userRepo.save(user);

        modelAndView.addObject("successMessage", "Your password has been set!");
        return modelAndView;
    }
}
