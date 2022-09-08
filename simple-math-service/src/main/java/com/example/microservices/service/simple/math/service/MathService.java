package com.example.microservices.service.simple.math.service;

import com.example.microservices.service.simple.math.dto.MultiplyRequestDto;
import com.example.microservices.service.simple.math.dto.Response;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class MathService {

  public Mono<Response> square(int input) {
    return Mono.fromSupplier(() -> input * input)
      .map(Response::new);
  }

  public Flux<Response> multiplicationTable(int input) {
    return Flux.range(1, 10)
      .delayElements(Duration.ofSeconds(1L))
      .doOnNext(i -> System.out.println("Math for " + i))
      .map(i -> new Response(i * input));
  }

  public Mono<Response> multiply(Mono<MultiplyRequestDto> request) {
    return request.map(dto -> dto.getFirst() * dto.getSecond())
      .map(Response::new);
  }
}
