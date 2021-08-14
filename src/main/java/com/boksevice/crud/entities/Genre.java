package com.boksevice.crud.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;


@Document(collection = "Genres")
@Data
public class Genre {
    @Id
    private String id;
    @NotBlank(message = "Поле не должно быть пустым")
    private String genreName;
}
