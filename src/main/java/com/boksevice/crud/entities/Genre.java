package com.boksevice.crud.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Genres")
@Data
public class Genre {
    @Id
    private String id;
    private String genreName;
}
