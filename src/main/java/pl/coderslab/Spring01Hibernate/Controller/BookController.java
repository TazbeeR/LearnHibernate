package pl.coderslab.Spring01Hibernate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01Hibernate.Dao.BookDao;
import pl.coderslab.Spring01Hibernate.Entity.Book;

@Controller
public class BookController {
    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "to żyje";
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String addBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setRating(10);
        book.setDescription("Krótki opis książki");
        bookDao.saveBook(book);
        return "Id dodanej książki to:"
                + book.getId();
    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable Long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook (@PathVariable Long id, @PathVariable String title){
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }
    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook (@PathVariable Long id){
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "Książka została usunięta";
    }

}
