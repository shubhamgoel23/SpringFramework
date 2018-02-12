package com.springframework.spring5.repository;

import com.springframework.spring5.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisheRepository extends CrudRepository<Publisher, Long>
{
}
