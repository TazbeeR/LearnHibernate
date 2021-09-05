package pl.coderslab.Spring01Hibernate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01Hibernate.Entity.Student;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String landingPage (Model model){
        model.addAttribute("student", new Student());
        return "student/student";
    }
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skills")
    public List<String> skills() {
        return Arrays.asList("Java", "PHP", "Ruby");
    }
        @ModelAttribute("hobbies")
        public List<String> hobbys(){
        return Arrays.asList("koszykówka", "ping pong", "bierki");
        }
    @PostMapping("/student")
    public String saveStudent (@ModelAttribute Student student, Model model) {
        model.addAttribute("student", student);
        return "student/summary";
    }
}
