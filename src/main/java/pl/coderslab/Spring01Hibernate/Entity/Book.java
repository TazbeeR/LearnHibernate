package pl.coderslab.Spring01Hibernate.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int rating;
    private String description;
    @ManyToOne
    private Author author;

    @ManyToMany
    public List<Author> list = new ArrayList<>();

    @ManyToOne
    private Publisher publisher;

        public Book() {
    }

    public Book(Long id, String title, int rating, String description) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.description = description;

    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Author> getList() {
        return list;
    }

    public void setList(List<Author> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", list=" + list +
                ", publisher=" + publisher +
                '}';
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
