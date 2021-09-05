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

@Controller
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao)
    {
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
    public String zad2 (){
        Author author1 = authorDao.findById(1L);
        Author author2 = authorDao.findById(2l);
        Book book1 = bookDao.findById(1l);
        book1.setAuthor(author1);
        bookDao.saveBook(book1);
        book1.setAuthor(author2);
        bookDao.saveBook(book1);

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
