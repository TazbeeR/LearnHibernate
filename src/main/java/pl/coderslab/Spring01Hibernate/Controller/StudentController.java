package pl.coderslab.Spring01Hibernate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01Hibernate.Entity.Skill;
import pl.coderslab.Spring01Hibernate.Entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String landingPage (Model model){
        model.addAttribute("student", new Student());
        return "student";
    }
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }
    @ModelAttribute("skills")
    public List<Skill> skills() {
        List<Skill> skills = new ArrayList<Skill>();
        skills.add(new Skill(1, "Java"));
        skills.add(new Skill(2, "PHP"));
        skills.add(new Skill(3, "Ruby"));
        return skills;
    }
        @ModelAttribute("hobbies")
        public List<String> hobbys(){
        return Arrays.asList("koszykówka", "ping pong", "bierki");
        }
    @PostMapping("/student")
    @ResponseBody
    public String saveStudent (@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String gender,
                               @RequestParam String country,
                               @RequestParam String notes,
                               @RequestParam boolean mailingList,
                               @RequestParam List<Skill> programmingSkills,
                               @RequestParam List<String> hobbies

    ){


        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGender(gender);
        student.setCountry(country);
        student.setNotes(notes);
        student.setMailingList(mailingList);
        student.setProgrammingSkills(programmingSkills);
//        student.setHobbies(hobbies);
        return student.toString();
    }

}
