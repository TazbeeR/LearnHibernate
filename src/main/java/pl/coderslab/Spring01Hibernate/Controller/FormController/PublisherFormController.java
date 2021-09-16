package pl.coderslab.Spring01Hibernate.Controller.FormController;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.Spring01Hibernate.Dao.PublisherDao;
import pl.coderslab.Spring01Hibernate.Entity.Publisher;

@Controller
@AllArgsConstructor
public class PublisherFormController {

    private final PublisherDao publisherDao;

    @GetMapping("/publisherForm/list")
    public String showAll(Model model) {
        model.addAttribute("allPublishers", publisherDao.findAll());
        return "publisher/all";
    }

    @GetMapping("/publisherForm/add")
    public String initAddForm(Model model){
        model.addAttribute("publisher", new Publisher());
        return "publisher/form";
    }

    @PostMapping("publisherForm/add")
    public String persistPublisher(Publisher publisher){
        publisherDao.savePublisher(publisher);
        return "redirect:/publisherForm/list";
    }

    @GetMapping("/publisherForm/edit")
    public String prepareEdit(@RequestParam Long idToEdit, Model model) {
        model.addAttribute("publisher", publisherDao.findById(idToEdit));
        return "publisher/form";
    }

    @PostMapping("/publisherForm/edit")
    public String merge(Publisher publisher) {
        publisherDao.update(publisher);
        return "redirect:/publisherForm/list";
    }

    @GetMapping("/publisherForm/remove")
    public String prepareRemove(@RequestParam Long toRemoveId, Model model) {
        model.addAttribute("publisher", publisherDao.findById(toRemoveId));
        return "publisher/remove";
    }

    @PostMapping("/publisherForm/remove")
    public String remove(@RequestParam String confirmed, @RequestParam Long toRemoveId) {
        if ("yes".equals(confirmed)) {
            Publisher publisher = publisherDao.findById(toRemoveId);
            publisherDao.delete(publisher);
        }
        return "redirect:/publisherForm/list";
    }
}
