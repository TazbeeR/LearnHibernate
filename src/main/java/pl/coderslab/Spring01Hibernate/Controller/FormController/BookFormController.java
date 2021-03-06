package pl.coderslab.Spring01Hibernate.Controller.FormController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01Hibernate.Dao.AuthorDao;
import pl.coderslab.Spring01Hibernate.Dao.BookDao;
import pl.coderslab.Spring01Hibernate.Dao.PublisherDao;
import pl.coderslab.Spring01Hibernate.Entity.Author;
import pl.coderslab.Spring01Hibernate.Entity.Book;
import pl.coderslab.Spring01Hibernate.Entity.Publisher;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Controller
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;


    @ModelAttribute("publishers")
    public List<Publisher> allPublishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> allAuthors() {
        return authorDao.findAll();
    }

    @GetMapping("/bookForm/list")
    public String showAll(Model model) {
        model.addAttribute("allBooks", bookDao.findAll());
        return "book/all";
    }

    @GetMapping("/bookForm/add")
    public String initAddFom(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/bookForm/add")
    public String persistBook(Book book) {
        bookDao.saveBook(book);
        return "redirect:/bookForm/list";
    }

    @GetMapping("/bookForm/edit")
    public String prepareEdit(@RequestParam Long idToEdit, Model model) {
        model.addAttribute("book", bookDao.findById(idToEdit));
        return "book/form";
    }

    @PostMapping("/bookForm/edit")
    public String merge(Book book) {
        bookDao.update(book);
        return "redirect:/bookForm/list";
    }

    @GetMapping("/bookForm/remove")
    public String prepareRemove(@RequestParam Long toRemoveId, Model model) {
        model.addAttribute("book", bookDao.findById(toRemoveId));
        return "book/remove";
    }

    @PostMapping("/bookForm/remove")
    public String remove(@RequestParam String confirmed, @RequestParam Long toRemoveId) {
        if ("yes".equals(confirmed)) {
            Book book = bookDao.findById(toRemoveId);
            bookDao.delete(book);
        }
        return "redirect:/bookForm/list";
    }
}