package com.boksevice.crud.repo;

import com.boksevice.crud.entities.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
