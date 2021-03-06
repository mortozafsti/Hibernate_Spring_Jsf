package com.example.springevidence.Controller;

import com.example.springevidence.Entity.Student;
import com.example.springevidence.Entity.imageOptimizer;
import com.example.springevidence.Repo.Rolerepo;
import com.example.springevidence.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class HomeController {

    private static String UPLOAD_FOLDER = "src/main/resources/static/image/";

    @Autowired
    private imageOptimizer optimizer;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private Rolerepo rolerepo;

    @GetMapping(value = "/add")
    public String add(Student student,Model model){
//        System.out.println(this.rolerepo.findAll().size());
        model.addAttribute("rolelists", this.rolerepo.findAll());
        return "add";
    }

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("lists", this.studentRepo.findAll());
        return "index";
    }
    @PostMapping(value = "/add")
    public String save(@Valid Student student, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file){
        if (bindingResult.hasErrors()){
            return "add";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            student.setFileName("new-" + file.getOriginalFilename());
            student.setFileSize(file.getSize());
            student.setFilePath("image/" +  "new-" + file.getOriginalFilename());
            student.setFileExtention(file.getContentType());

            student.setRegiDate(new Date());
            this.studentRepo.save(student);
            model.addAttribute("student", new Student());

            optimizer.optimizeImage(UPLOAD_FOLDER, file,0.3f,90,90);

            model.addAttribute("rolelists", this.rolerepo.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }

        return "add";
    }


    @PostMapping(value = "/edit/{id}")
    public String edit(@Valid Student student, BindingResult bindingResult, Model model, @PathVariable("id") Long id,MultipartFile file){
        Student student1 = this.studentRepo.getOne(id);

        if (bindingResult.hasErrors()){
            return "edit";
        }

        student.setRegiDate(student1.getRegiDate());
        try {
            if (file.getOriginalFilename().length() > 0) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);

                student.setFileName("new-" + file.getOriginalFilename());
                student.setFileSize(file.getSize());
                student.setFilePath("image/" + "new-" + file.getOriginalFilename());
                student.setFileExtention(file.getContentType());
            }else{
                student.setFileName(student1.getFileName());
                student.setFilePath(student1.getFilePath());
                student.setFileSize(student1.getFileSize());
                student.setFileExtention(student1.getFileExtention());
            }

            this.studentRepo.save(student);
            model.addAttribute("student", new Student());
           if (file.getOriginalFilename().length() > 0){
               optimizer.optimizeImage(UPLOAD_FOLDER, file,0.3f,90,90);
           }

            model.addAttribute("rolelists", this.rolerepo.findAll());

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }
    @GetMapping(value = "/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id){

        model.addAttribute("rolelists", this.rolerepo.findAll());

        model.addAttribute("student",this.studentRepo.getOne(id));

        return "edit";
    }
    @GetMapping(value = "/del/{id}")
    public String delete(Model model, @PathVariable("id") Long id){
        if (id != null){
            this.studentRepo.deleteById(id);
        }
        return "redirect:/";
    }


}
