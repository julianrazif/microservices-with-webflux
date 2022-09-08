package com.example.microservices.service.simple.math.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InputFailedValidationResponse {

  private int ec;
  private int input;
  private String message;
}
