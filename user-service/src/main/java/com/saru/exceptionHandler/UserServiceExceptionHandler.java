package com.saru.exceptionHandler;

import com.saru.error.ErrorResponse;
import com.saru.error.UserServiceException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Date;
import java.util.stream.Collectors;

@RestControllerAdvice
public class UserServiceExceptionHandler {

    /**
     * Handles MethodArgumentNotValidException and returns a ResponseEntity with a 400 status code and an ErrorResponse
     * object containing the error details.
     *
     * @param exception the MethodArgumentNotValidException that occurred
     * @return a ResponseEntity with a 400 status code and an ErrorResponse object containing the error details
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> methodArgumentExceptionHandler(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(400).body(ErrorResponse.builder()
                .timestamp(new Date(System.currentTimeMillis()))
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("Validation Failed")
                .details(exception.getBindingResult().getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","))).build());
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ErrorResponse> serviceExceptionHandler(UserServiceException exception){
        return ResponseEntity.status(400).body(ErrorResponse.builder()
                .timestamp(new Date(System.currentTimeMillis()))
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("Invalid id")
                .details(exception.getMessage()).build()
        );
    }
}
