package com.yurialves.keycloakapiconsumer.controller;

import com.yurialves.keycloakapiconsumer.dto.ClientesExternalDTO;
import com.yurialves.keycloakapiconsumer.service.ClientesExternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes-external")
public class ClientesExternalController {

    private final ClientesExternalService clientesExternalService;

    @GetMapping
    Mono<ResponseEntity> buscarClientesExternos (){
        return  clientesExternalService.carregarTodosClientes();
    }

}
