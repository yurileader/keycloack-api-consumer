package com.yurialves.keycloakapiconsumer.service;

import com.yurialves.keycloakapiconsumer.dto.ClientesExternalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientesExternalService {

    private final WebClient webClient;

    public Mono<ResponseEntity> carregarTodosClientes() {
        return webClient
                .get()
                .uri("http://localhost:8080/clientes")
                .retrieve()
                .bodyToMono(ClientesExternalDTO[].class)
                .map(clientes -> ResponseEntity.status(HttpStatus.OK).body(clientes))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NO_CONTENT).body("Lista vazia"));

    }
}

