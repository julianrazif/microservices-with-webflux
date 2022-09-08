package com.example.microservices.service.simple.math.exception;

import com.example.microservices.service.simple.math.dto.InputFailedValidationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InputValidationExceptionHandler {

  @ExceptionHandler(InputValidationException.class)
  public ResponseEntity<InputFailedValidationResponse> handleException(InputValidationException ex) {
    InputFailedValidationResponse response = new InputFailedValidationResponse();
    response.setEc(ex.getEc());
    response.setInput(ex.getInput());
    response.setMessage(ex.getMessage());
    return ResponseEntity.badRequest().body(response);
  }
}
