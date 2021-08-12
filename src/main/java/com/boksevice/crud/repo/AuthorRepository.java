package com.boksevice.crud.repo;

import com.boksevice.crud.entities.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, Long> {
}
