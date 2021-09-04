package pl.coderslab.Spring01Hibernate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01Hibernate.Dao.AuthorDao;
import pl.coderslab.Spring01Hibernate.Entity.Author;
import pl.coderslab.Spring01Hibernate.Entity.Book;

@Controller
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {this.authorDao = authorDao;}

    @RequestMapping("/author/add")
    @ResponseBody
    public String addAuthor(){
        Author author = new Author();
        author.setFirstName("Heniek");
        author.setFirstName("Wesoły");
        authorDao.saveAuthor(author);
        return "Id dodanego autora: " + author.getId();
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}/{lastName}")
    @ResponseBody
    public String updateAuthor (@PathVariable Long id, @PathVariable String name){
        Author author = authorDao.findById(id);
        author.setLastName(name);
        authorDao.update(author);
        return author.toString();
    }
    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor (@PathVariable Long id){
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "Autor został usunięty";
    }
}
