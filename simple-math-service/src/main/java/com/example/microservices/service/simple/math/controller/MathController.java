package com.example.microservices.service.simple.math.controller;

import com.example.microservices.service.simple.math.dto.MultiplyRequestDto;
import com.example.microservices.service.simple.math.dto.Response;
import com.example.microservices.service.simple.math.exception.InputValidationException;
import com.example.microservices.service.simple.math.service.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("math")
public class MathController {

  private final MathService mathService;

  @GetMapping("square/{input}")
  public Mono<Response> findSquare(@PathVariable int input) {
    return Mono.just(input)
      .handle((integer, sink) -> {
        if (integer > 10 || integer <= 0) {
          sink.error(new InputValidationException("error", integer, 100));
        } else {
          sink.next(integer);
        }
      })
      .cast(Integer.class)
      .flatMap(mathService::square);
  }

  @GetMapping(value = "table/{input}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Response> multiplicationTable(@PathVariable int input) {
    return mathService.multiplicationTable(input);
  }

  @PostMapping("multiply")
  public Mono<Response> multiply(@RequestBody Mono<MultiplyRequestDto> request, @RequestHeader Map<String, String> headers) {
    System.out.println(headers);
    return mathService.multiply(request);
  }
}
