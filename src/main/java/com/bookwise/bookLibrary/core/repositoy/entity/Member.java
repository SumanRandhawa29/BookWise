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
@Getter @Setter
public class Member {
    @Id
    private int memberId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private String currentAddress;
    private String permanentAddress;
    private LocalDate dateOfBirth;
    private int role;
    private int status;

}
