package com.boksevice.crud.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Document(collection = "Authors")
@Data
public class Author {
    @Id
    private String id;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, max = 30, message = "В пределах 1-30 знаков")
    @Pattern(regexp = "\\D*", message = "Не цифры")
    private String name;

}
