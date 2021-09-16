package pl.coderslab.Spring01Hibernate.Controller.FormController;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.Spring01Hibernate.Dao.AuthorDao;
import pl.coderslab.Spring01Hibernate.Entity.Author;

@Controller
@AllArgsConstructor
public class AuthorFromController {

    private final AuthorDao authorDao;

    @GetMapping("/authorForm/list")
    public String showAll(Model model) {
        model.addAttribute("allAuthors", authorDao.findAll());
        return "author/all";
    }

    @GetMapping("/authorForm/add")
    public String initAddForm(Model model){
        model.addAttribute("author", new Author());
        return "author/form";
    }

    @PostMapping ("authorForm/add")
    public String persistAuthor(Author author){
        authorDao.saveAuthor(author);
        return "redirect:/authorForm/list";
    }

    @GetMapping("/authorForm/edit")
    public String prepareEdit(@RequestParam Long idToEdit, Model model) {
        model.addAttribute("author", authorDao.findById(idToEdit));
        return "author/form";
    }

    @PostMapping("/authorForm/edit")
    public String merge(Author author) {
        authorDao.update(author);
        return "redirect:/authorForm/list";
    }

    @GetMapping("/authorForm/remove")
    public String prepareRemove(@RequestParam Long toRemoveId, Model model) {
        model.addAttribute("author", authorDao.findById(toRemoveId));
        return "author/remove";
    }

    @PostMapping("/authorForm/remove")
    public String remove(@RequestParam String confirmed, @RequestParam Long toRemoveId) {
        if ("yes".equals(confirmed)) {
            Author author = authorDao.findById(toRemoveId);
            authorDao.delete(author);
        }
        return "redirect:/authorForm/list";
    }
}
