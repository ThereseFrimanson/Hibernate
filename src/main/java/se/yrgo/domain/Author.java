package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private int age;

    @OneToMany
    @JoinColumn(name="AUTHOR_FK")
    //private Set<Book> bookCollection;
    
    private List<Book> bookCollection;

    public Author() {}

    public Author(String name) {
        this.name= name;
        this.bookCollection = new ArrayList<Book>();
    }

    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public void addBookToBookCollection(Book newBook) {
        this.bookCollection.add(newBook);
    }

    public List<Book> getBookCollection() {
        return Collections.unmodifiableList(this.bookCollection);
        
    }

}
