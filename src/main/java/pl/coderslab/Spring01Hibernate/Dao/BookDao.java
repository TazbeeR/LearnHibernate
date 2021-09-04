package pl.coderslab.Spring01Hibernate.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Spring01Hibernate.Entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveBook(Book book){
        entityManager.persist(book);
    }
}