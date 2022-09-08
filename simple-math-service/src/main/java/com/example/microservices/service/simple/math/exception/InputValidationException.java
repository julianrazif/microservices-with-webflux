package com.example.microservices.service.simple.math.exception;

public class InputValidationException extends RuntimeException {

  private final int input;
  private final int ec;

  public InputValidationException(String message, int input, int ec) {
    super(message);
    this.input = input;
    this.ec = ec;
  }

  public int getInput() {
    return this.input;
  }

  public int getEc() {
    return this.ec;
  }
}
