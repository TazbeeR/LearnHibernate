package pl.coderslab.Spring01Hibernate.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.Spring01Hibernate.Dao.AuthorDao;
import pl.coderslab.Spring01Hibernate.Entity.Author;

@Component
public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao authorDao;
    
    
    @Override
    public Author convert(String s) {
                
        return authorDao.findById(Long.parseLong(s));
    }
}
