package pl.coderslab.Spring01Hibernate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01Hibernate.Dao.AuthorDao;
import pl.coderslab.Spring01Hibernate.Dao.BookDao;
import pl.coderslab.Spring01Hibernate.Dao.PublisherDao;
import pl.coderslab.Spring01Hibernate.Entity.Author;
import pl.coderslab.Spring01Hibernate.Entity.Book;
import pl.coderslab.Spring01Hibernate.Entity.Publisher;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "to żyje";
    }

    @RequestMapping("/book/zad2")
    @ResponseBody

//    Poprawic
    public String zad2() {
        Publisher publisher = new Publisher();
        publisher.setName("Wydawnictwo HELION");
        publisherDao.savePublisher(publisher);

        Author firstAuthor = authorDao.findById(1l);
        Author secondAuthor = authorDao.findById(2l);

        Book book = new Book();
        book.setTitle("Władca pierścieni");
        book.setRating(4);
        book.setDescription("Książka o handlarzu pierścieniami");
        book.setPublisher(publisher);
        book.getAuthorList().add(firstAuthor);
        book.getAuthorList().add(secondAuthor);

        return "it's done";
    }


    @RequestMapping("/book/add")
    @ResponseBody
    public String addBook() {

        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisherDao.savePublisher(publisher);

        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setRating(10);
        book.setDescription("Krótki opis książki");
        book.setPublisher(publisher);
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
    public String updateBook(@PathVariable Long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "Książka została usunięta";
    }

    @RequestMapping("/book/all")
    @ResponseBody
    public String findAll() {
        List<Book> allBooks = bookDao.findAll();
        return allBooks.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }

    @RequestMapping("/book/rating/{rating}")
    @ResponseBody
    public String findAllByRating(@PathVariable int rating) {
        List<Book> allBooksByRating = bookDao.findAllByRating(rating);
        return allBooksByRating.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }

    @RequestMapping("/book/publisher")
    @ResponseBody
    public String findAllExist() {
        List<Book> allBooks = bookDao.findAllByExistingPublisher();
        return allBooks.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }

    @RequestMapping("/publisher/{id}")
    @ResponseBody
    public String tessst(@PathVariable Publisher id) {
        List<Book> allBooks = bookDao.findAllByPublisher(id);
        return allBooks.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }


}
