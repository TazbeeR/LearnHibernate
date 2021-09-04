package pl.coderslab.Spring01Hibernate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01Hibernate.Dao.PersonDao;
import pl.coderslab.Spring01Hibernate.Entity.Person;
import pl.coderslab.Spring01Hibernate.Entity.PersonDetails;

@Controller
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
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