package com.boksevice.crud.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Authors")
@Data
public class Author {
    @Id
    private String id;
    private String name;

}
