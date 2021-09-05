package pl.coderslab.Spring01Hibernate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01Hibernate.Dao.PersonDao;
import pl.coderslab.Spring01Hibernate.Entity.Person;
import pl.coderslab.Spring01Hibernate.Entity.PersonDetails;
import pl.coderslab.Spring01Hibernate.Entity.Student;

@Controller
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/person/form")
    public String test1(Model model){
        model.addAttribute("person" , new Person());
        return "personform";
    }

    @PostMapping("/person/form")
    @ResponseBody
    public String save(@RequestParam String login,
                       @RequestParam String email,
                       @RequestParam String password) {
        Person person = new Person();
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);
        personDao.persist(person);

        return "udało sie";
    }

    @GetMapping("/person/test")
    public String test (){
        return "index";
    }

    @RequestMapping("/person/persist")
    @ResponseBody
    public String persist() {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Jan");
        personDetails.setLastName("Kowalski");
        personDetails.setStreetNumber("45A");
        personDetails.setStreet("Głowna");
        personDetails.setCity("Warszawa");

        Person person = new Person();
        person.setLogin("test123");
        person.setEmail("test123@o2.pl");
        person.setPassword("test123");
        person.setPersonDetails(personDetails);

        personDao.persist(person);

        return "Jest sukces!";
    }

}