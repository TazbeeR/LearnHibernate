package pl.coderslab.Spring01Hibernate.Dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.Spring01Hibernate.Entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveAuthor (Author author){
        entityManager.persist(author);
    }

    public Author findById (Long id) {
        return entityManager.find(Author.class, id);
    }

    public void update (Author author){
        entityManager.merge(author);
    }

    public void delete (Author author){
        entityManager.remove(entityManager.contains(author) ?
                author:entityManager.merge(author));
    }
}
