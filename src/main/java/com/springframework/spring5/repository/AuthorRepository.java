package com.springframework.spring5.repository;

import com.springframework.spring5.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{


}
