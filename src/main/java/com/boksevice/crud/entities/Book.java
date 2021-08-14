package com.boksevice.crud.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;


@Document(collection = "Books")
@Data
public class Book {
    @Id
    private String id;
    @NotBlank(message = "не должно быть пустым")
    @Size(min = 1, max = 50, message = "в пределах 1-50")
    private String name;

    @Positive(message = "Только положительные значения")
    private int yearOfPublishing;
    @DBRef
    @NotNull(message = "выберите значение из списка")
    private Author author;
    @DBRef
    @NotNull(message = "выберите значение из списка")
    private Genre genre;
}
