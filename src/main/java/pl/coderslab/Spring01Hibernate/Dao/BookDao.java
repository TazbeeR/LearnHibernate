package pl.coderslab.Spring01Hibernate.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Spring01Hibernate.Entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveBook(Book book){
        entityManager.persist(book);
    }

    public Book findById (Long id){
        return entityManager.find(Book.class , id);
    }

    public void update (Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book:entityManager.merge(book));
    }

    public List<Book> findAll () {
        Query query =entityManager.createQuery("select b from Book b");
        return query.getResultList();
    }
    public List<Book> findAllByRating (int rating) {
        Query query = entityManager.createQuery("select b from Book b where b.rating = :givenRating");
        query.setParameter("givenRating", rating);
        return query.getResultList();
    }
    public List<Book> findAllByExistingPublisher (){
        Query query = entityManager.createQuery("select b from Book b where b.publisher is not null");
        return query.getResultList();
    }
    }
