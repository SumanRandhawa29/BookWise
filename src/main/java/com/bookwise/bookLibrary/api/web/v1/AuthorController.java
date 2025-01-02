package com.bookwise.booklibrary.api.web.v1;

import com.bookwise.booklibrary.api.models.AuthorRequestV1;
import com.bookwise.booklibrary.api.models.AuthorResponse;
import com.bookwise.booklibrary.api.models.AuthorV1;
import com.bookwise.booklibrary.api.web.exceptions.AuthorNotFoundException;
import com.bookwise.booklibrary.core.service.AuthorService;
import com.bookwise.booklibrary.core.service.models.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorV1> addAuthor(@RequestBody @Validated AuthorRequestV1 authorRequestV1) {
        var res = authorService.saveAuthor(authorRequestV1.toAuthor());
        return ResponseEntity.status(CREATED)
                .body(res.toAuthorV1());
    }

    @GetMapping
    public ResponseEntity<AuthorResponse> getAuthors(){
        var authors = authorService.getAuthors();
        return ResponseEntity.ok().body(new AuthorResponse(authors.stream().map(Author::toAuthorV1).toList(), authors.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorV1> getAuthorById(@PathVariable("id") int id){
        var author = authorService.getAuthorById(id);
        return ResponseEntity.ok().body(author.toAuthorV1());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorV1> updateAuthor(@PathVariable("id") int id, @RequestBody @Validated AuthorRequestV1 authorRequestV1) {

       if(authorService.existsByAuthorId(id)) {
           var updatedAuthor = authorService.updateAuthor(authorRequestV1.toAuthor(id));
           return ResponseEntity.ok().body(updatedAuthor.toAuthorV1());
       }
       else {
           throw new AuthorNotFoundException("Author updated request failed because Author with id: "+id+" does not exist");
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") int id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.accepted().build();
    }



}
