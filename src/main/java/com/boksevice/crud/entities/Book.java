package com.boksevice.crud.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Books")
@Data
public class Book {
    @Id
    private String id;
    private String name;
    private int yearOfPublishing;
    @DBRef
    private Author author;
    @DBRef
    private Genre genre;
}
