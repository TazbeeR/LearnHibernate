package pl.coderslab.Spring01Hibernate.Dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.Spring01Hibernate.Entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Person person) {
        entityManager.persist(person);
    }

    public Person merge(Person person) {
        return entityManager.merge(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void remove(Person person) {
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }

}