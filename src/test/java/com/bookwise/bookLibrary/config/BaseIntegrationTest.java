package com.bookwise.booklibrary.config;

import com.bookwise.booklibrary.BookLibraryApplication;
import groovy.util.logging.Slf4j;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.http.ContentType.JSON;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test") @SpringBootTest(classes = {BookLibraryApplication.class}, webEnvironment = RANDOM_PORT)
@Slf4j
@Transactional
public class BaseIntegrationTest {
    @LocalServerPort
    protected int port;

    public RequestSpecBuilder specBuilder;

    @BeforeEach
    void setup() {
        specBuilder = new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri("http://localhost:"+port+"/bookLibrary/")
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter());
    }
}
