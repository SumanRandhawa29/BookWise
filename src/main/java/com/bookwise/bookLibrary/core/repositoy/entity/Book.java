package com.bookwise.booklibrary.core.repositoy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    private int bookId;
    private String title;
    private int categoryType;
    private String authorId;
    private String isbn;
    private LocalDate publishedDate;
    private LocalDate availableFrom;
}



