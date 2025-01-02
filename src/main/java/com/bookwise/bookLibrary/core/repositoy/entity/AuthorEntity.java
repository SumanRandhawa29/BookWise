package com.bookwise.booklibrary.core.repositoy.entity;

import com.bookwise.booklibrary.core.service.models.Author;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "AUTHOR")
public class AuthorEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String name;
    private String email;


    public Author toAuthor() {
        return new Author(this.authorId, this.name, this.email);
    }
}
