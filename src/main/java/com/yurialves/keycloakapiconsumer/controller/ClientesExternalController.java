package com.yurialves.keycloakapiconsumer.controller;

import com.yurialves.keycloakapiconsumer.dto.ClientesExternalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes-external")
public class ClientesExternalController {

    private final ClientesExternalService clientesExternalService;

    @GetMapping
    List<ClientesExternalDTO> buscarClientesExternos (){
        return  clientesExternalService.carregarTodosClientes();
    }

}
