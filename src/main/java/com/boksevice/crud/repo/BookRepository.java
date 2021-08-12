package com.boksevice.crud.repo;

import com.boksevice.crud.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Long> {
}
