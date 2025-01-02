package com.bookwise.booklibrary.core.repositoy;

import com.bookwise.booklibrary.core.repositoy.entity.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Integer> {

    AuthorEntity findByAuthorId(int authorId);

    boolean existsByAuthorId(int authorId);

    void deleteByAuthorId(int authorId);

    @Query(value = "SELECT * FROM AUTHOR", nativeQuery = true)
    List<AuthorEntity> findAll();
}
