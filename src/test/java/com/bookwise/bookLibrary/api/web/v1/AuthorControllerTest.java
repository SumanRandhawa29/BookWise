package com.bookwise.booklibrary.api.web.v1;


import com.bookwise.booklibrary.api.models.AuthorRequestV1;
import com.bookwise.booklibrary.api.models.AuthorResponse;
import com.bookwise.booklibrary.api.models.AuthorV1;
import com.bookwise.booklibrary.config.BaseIntegrationTest;
import com.bookwise.booklibrary.core.service.models.Author;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.CREATED;


class AuthorControllerTest extends BaseIntegrationTest {

    @Test
    void saveAuthor() {
        AuthorRequestV1 authorRequestV1 = new AuthorRequestV1("Bla bla", "BlaBla@gmail.com");

        var authorResponse = RestAssured.given().spec(specBuilder.build())
                .body(authorRequestV1)
                .when()
                .post("authors")
                .then()
                .statusCode(CREATED.value())
                .extract().body().as(AuthorV1.class);


        assertThat(authorResponse.name()).isEqualTo(authorRequestV1.name());
        assertThat(authorResponse.email()).isEqualTo(authorRequestV1.email());

    }


    @Test
    void getAuthors() {
        var authResponse = RestAssured.given().spec(specBuilder.build())
                .when()
                .get("authors")
                .then()
                .statusCode(200)
                .extract().body().as(AuthorResponse.class);

        assertThat(authResponse.authors()).isNotEmpty().hasSize(1);
        assertThat(authResponse.authors()).containsExactlyInAnyOrder(
                new AuthorV1(0, "John Doe", "jd@gmail.com")
        );
    }

    @Test
    void updateAuthors(){

        var authorRequestV1 = new AuthorRequestV1("Johny", "test@gmail.com");

        var authorResponse = RestAssured.given().spec(specBuilder.build())
                .body(authorRequestV1)
                .when()
                .put("authors/0")
                .then()
                .statusCode(200)
                .extract().body().as(Author.class);

        assertThat(authorResponse.name()).isEqualTo(authorRequestV1.name());
        assertThat(authorResponse.email()).isEqualTo(authorRequestV1.email());

    }
}