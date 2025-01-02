package com.bookwise.booklibrary.external.User.model;


import com.bookwise.booklibrary.core.service.models.User;

public record ExternalUser(
        int id,
        String email,
        String username,
        String password,
        Name name,
        Address address,
        String phone
) {
    public User toUser() {
        return new User(id, name.firstname() + " " + name.lastname(), email, phone);
    }

    public record Name(String firstname, String lastname) {}

    public record Address(String city, String street, int number, String zipcode, Geolocation geolocation) { }

    public record Geolocation(String lat, String lon) {}
}