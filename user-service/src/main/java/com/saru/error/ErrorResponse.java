package com.saru.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.sql.Date;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String message;
    private Date timestamp;
    private String details;
}
