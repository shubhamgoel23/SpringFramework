package com.springframework.spring5.bootstrap;

import com.springframework.spring5.model.Author;
import com.springframework.spring5.model.Book;
import com.springframework.spring5.model.Publisher;
import com.springframework.spring5.repository.AuthorRepository;
import com.springframework.spring5.repository.BookRepository;
import com.springframework.spring5.repository.PublisheRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisheRepository publisheRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisheRepository publisheRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisheRepository= publisheRepository;
    }

    private void initData(){
        Publisher publisher = new Publisher();
        publisher.setName("shubham");
        publisheRepository.save(publisher);
        Author eric = new Author("eric","evans");
        Book dd = new Book("domain driven design", "1234", publisher);
        eric.getBooks().add(dd);
        dd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(dd);



        Author rod = new Author("rod","evans");
        Book qaz = new Book("ejb", "6474",publisher);
        rod.getBooks().add(qaz);
        qaz.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(qaz);

        Author eric1 = new Author("eric","evans");
        eric1.getBooks().add(dd);
        dd.getAuthors().add(eric1);
        authorRepository.save(eric1);
        bookRepository.save(dd);


    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
