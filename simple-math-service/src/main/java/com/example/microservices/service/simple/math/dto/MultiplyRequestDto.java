package com.example.microservices.service.simple.math.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MultiplyRequestDto {

  private int first;
  private int second;
}
