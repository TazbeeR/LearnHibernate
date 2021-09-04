package pl.coderslab.Spring01Hibernate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01Hibernate.Dao.PublisherDao;
import pl.coderslab.Spring01Hibernate.Entity.Publisher;

@Controller
public class PublisherController {
    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/publisher/add")
    @ResponseBody
    public String addPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisherDao.savePublisher(publisher);
        return "Id dodanego wydawcy: " + publisher.getId();
    }

    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher (@PathVariable Long id, @PathVariable String name){
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }
    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher (@PathVariable Long id){
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "Wydawca został usunięty";
    }
}
