package com.boksevice.crud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Genres")

public class Genre {

    @Id
    private long id;
    private String genreName;

    public Genre() {
    }

    public Genre(long id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }

    public long getId() {
        return id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
