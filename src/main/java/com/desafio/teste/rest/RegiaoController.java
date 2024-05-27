package com.desafio.teste.rest;

import com.desafio.teste.model.Municipio;
import com.desafio.teste.model.Uf;
import com.desafio.teste.service.RegiaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/regioes")
@AllArgsConstructor
public class RegiaoController {

    private final RegiaoService service;

    @GetMapping("{uf}")
    public Municipio[] getMunicipio(@PathVariable String uf) {

        return service.getMunicipio(uf);
    }

    @RequestMapping
    public Uf[] getUf() {
        return service.getUf();
    }


}
