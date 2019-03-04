package com.example.classtest2.controller;

import com.example.classtest2.entity.Role;
import com.example.classtest2.entity.User;
import com.example.classtest2.repo.RoleRepo;
import com.example.classtest2.repo.UserRepo;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/listuser")
    public String index(Model model){
        model.addAttribute("userlist",this.userRepo.findAll());
        return "user/listuser";
    }

    @GetMapping(value = "/adduser")
    public String addRole(User user, Model model){
        model.addAttribute("addlisthome", this.roleRepo.findAll());
        return "user/adduser";
    }

    @PostMapping(value = "/adduser")
    public String saveRole(@Valid User user,BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("addlisthome", this.roleRepo.findAll());
            return "user/adduser";
        }
//        User user1 = new User();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        passwordEncoder.encode(user.getPassword());
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("addlisthome", this.roleRepo.findAll());

        return "user/adduser";
    }

//    private static String USER_NAME = "mortozagm713";  // GMail user name (just the part before "@gmail.com")
//    private static String PASSWORD = ""; // GMail password
//    //private static String RECIPIENT = "springapidev@gmail.com";
//
//    // Return registration form template
//    @RequestMapping(value="/register", method = RequestMethod.GET)
//    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user){
//        modelAndView.addObject("addlisthome",this.roleRepo.findAll());
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("registration");
//        return modelAndView;
//    }
//
//    // Process form input data
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, HttpServletRequest request) {
//
//        // Lookup user in database by e-mail
//        User userExists = userRepo.findByEmail(user.getEmail());
//
//        System.out.println(userExists);
//
//        if (userExists != null) {
//            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
//            modelAndView.setViewName("register");
//            bindingResult.reject("email");
//        }
//
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("register");
//        } else { // new user so we create user and send confirmation e-mail
//
//            // Disable user until they click on confirmation link in email
//            user.setEnabled(false);
//
//            // Generate random 36-character string token for confirmation link
//            user.setConformationToken(UUID.randomUUID().toString());
//
//            userRepo.save(user);
//
//            String appUrl = request.getScheme() + "://" + request.getServerName()+":"+"8008";
//            //email sending
//
//            String from = USER_NAME;
//            String pass = PASSWORD;
//            String[] to = {user.getEmail()}; // list of recipient email addresses
//            String subject = "Registration Confirmation";
//            String body = "To confirm your e-mail address, please click the link below:\n"
//                    + appUrl + "/confirm?token=" + user.getConformationToken();
//
//            sendFromGMail(from, pass, to, subject, body);
//
//            modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
//            modelAndView.setViewName("register");
//        }
//
//        return modelAndView;
//    }
//
//    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
//        Properties props = System.getProperties();
//        String host = "smtp.gmail.com";
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.user", from);
//        props.put("mail.smtp.password", pass);
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//
//        Session session = Session.getDefaultInstance(props);
//        MimeMessage message = new MimeMessage(session);
//
//        try {
//            message.setFrom(new InternetAddress("rajaul.cse@gmail.com", "SAMI LLC."));
//            InternetAddress[] toAddress = new InternetAddress[to.length];
//
//            // To get the array of addresses
//            for (int i = 0; i < to.length; i++) {
//                toAddress[i] = new InternetAddress(to[i]);
//            }
//
//            for (int i = 0; i < toAddress.length; i++) {
//                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
//            }
//
//            message.setSubject(subject);
//            message.setText(body);
//            Transport transport = session.getTransport("smtp");
//            transport.connect(host, from, pass);
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//            System.out.println("Email sending Success!!!");
//        } catch (AddressException ae) {
//            ae.printStackTrace();
//        } catch (MessagingException me) {
//            me.printStackTrace();
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    // Process confirmation link
//    @RequestMapping(value="/conform", method = RequestMethod.GET)
//    public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam("token") String token) {
//
//        User user = userRepo.findByConformationToken(token);
//
//        if (user == null) { // No token found in DB
//            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
//        } else { // Token found
//            modelAndView.addObject("confirmationToken", user.getConformationToken());
//        }
//
//        modelAndView.setViewName("conform");
//        return modelAndView;
//    }
//
//    // Process confirmation link
//    @RequestMapping(value="/conform", method = RequestMethod.POST)
//    public ModelAndView confirmRegistration(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
//
//        modelAndView.setViewName("conform");
//
//        Zxcvbn passwordCheck = new Zxcvbn();
//
//        Strength strength = passwordCheck.measure(requestParams.get("password"));
//
//        if (strength.getScore() < 3) {
//            //modelAndView.addObject("errorMessage", "Your password is too weak.  Choose a stronger one.");
//            bindingResult.reject("password");
//
//            redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");
//
//            modelAndView.setViewName("redirect:conform?token=" + requestParams.get("token"));
//            //	System.out.println(requestParams.get("token"));
//            return modelAndView;
//        }
//
//        // Find the user associated with the reset token
//        User user = userRepo.findByConformationToken(requestParams.get("token"));
//
//        // Set new password
//        user.setPassword(passwordEncoder.encode(requestParams.get("password")));
//
//        // Set user to enabled
//        user.setEnabled(true);
//
//        // Save user
//        userRepo.save(user);
//
//        modelAndView.addObject("successMessage", "Your password has been set!");
//        return modelAndView;
//    }

//    @GetMapping(value = "/user-save")
//    public String saveUser(){
//
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1l));
//        User user = new User("Mortoza", "sadmin", passwordEncoder.encode("1234"), "mortozafsti@gmail.com", true, roles);
//        userRepo.save(user);
//
//        Set<Role> roles2 = new HashSet<>();
//        roles2.add(new Role(2l));
//        User user2 = new User("Milton", "admin",passwordEncoder.encode("12345"), "milton@gmail.com", true, roles2);
//        userRepo.save(user2);
//
//        Set<Role> roles3 = new HashSet<>();
//        roles3.add(new Role(3l));
//        User user3 = new User("Rakib", "user",passwordEncoder.encode("123456"), "rakib@gmail.com", true, roles3);
//        userRepo.save(user3);
//
//       return "success";
//
//    }
}
