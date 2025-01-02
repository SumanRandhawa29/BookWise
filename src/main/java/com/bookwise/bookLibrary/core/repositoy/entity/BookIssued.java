package com.bookwise.booklibrary.core.repositoy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BookIssued {
    @Id
    private int bookIssuedId;
    private int bookId;
    private int memberId;
    private LocalDateTime issueDate;
    private LocalDateTime returnDate;
    private int issuedBy;
    private int status;
    private float fine;
    private String remarks;
}
