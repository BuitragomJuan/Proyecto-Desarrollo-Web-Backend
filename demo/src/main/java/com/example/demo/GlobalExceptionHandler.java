package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        // Log the exception
        e.printStackTrace();

        // Create an ErrorResponse object
        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error");

        // Return a JSON response with status 500 and the ErrorResponse
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    // Add more exception handlers as needed

    // Example for handling specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        // Log the exception
        e.printStackTrace();

        // Create an ErrorResponse object
        ErrorResponse errorResponse = new ErrorResponse("Resource Not Found");

        // Return a JSON response with status 404 and the ErrorResponse
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    // ErrorResponse class to represent the structure of error responses
    public static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
