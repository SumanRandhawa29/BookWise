package com.bookwise.booklibrary.core.service;

import com.bookwise.booklibrary.core.repositoy.AuthorRepository;
import com.bookwise.booklibrary.core.repositoy.entity.AuthorEntity;
import com.bookwise.booklibrary.core.service.models.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author.toAuthorEntity()).toAuthor();
    }

    public List<Author> getAuthors() {
        List<Author> authorList = new ArrayList<>();
        for (AuthorEntity authorEntity : authorRepository.findAll()) {
            authorList.add(authorEntity.toAuthor());
        }
        return authorList;
    }

    public Author getAuthorById(int id) {
        var authorEntity = authorRepository.findByAuthorId(id);
        return authorEntity.toAuthor();
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteByAuthorId(id);
    }

    public boolean existsByAuthorId(int id) {
        return authorRepository.existsByAuthorId(id);
    }

    public Author updateAuthor(Author author) {
        return authorRepository.save(author.toAuthorEntity()).toAuthor();
    }
}
