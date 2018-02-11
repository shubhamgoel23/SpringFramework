package com.springframework.spring5.bootstrap;

import com.springframework.spring5.model.Author;
import com.springframework.spring5.model.Book;
import com.springframework.spring5.repository.AuthorRepository;
import com.springframework.spring5.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData(){
        Author eric = new Author("eric","evans");
        Book dd = new Book("domain driven design", "1234", "harper collins");
        eric.getBooks().add(dd);
        dd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(dd);



        Author rod = new Author("rod","evans");
        Book qaz = new Book("ejb", "6474", "collins");
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
