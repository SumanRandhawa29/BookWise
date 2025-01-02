package com.bookwise.booklibrary.api.web.exceptions;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailPatternMatchException.class)
    public ResponseEntity<ProblemDetail> handleEmailPatternMatchException(EmailPatternMatchException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(400);
        problemDetail.setTitle("Invalid email address");
        problemDetail.setDetail(ex.getMessage());
        return ResponseEntity.badRequest().body(problemDetail);
    }

}
