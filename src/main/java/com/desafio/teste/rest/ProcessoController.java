package com.desafio.teste.rest;

import com.desafio.teste.model.Processo;
import com.desafio.teste.rest.dto.ProcessoDTO;
import com.desafio.teste.service.ProcessoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/processos")
@AllArgsConstructor
public class ProcessoController {

    private final ProcessoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProcessoDTO create(@RequestParam("dados") String dados, @RequestParam("file") MultipartFile file) throws IOException {

        ProcessoDTO dto = new ObjectMapper().readValue(dados, ProcessoDTO.class);
        dto.setDocumento(file.getBytes());

        return service.create(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {

        service.delete(id);
    }

    @RequestMapping("{id}")
    public ProcessoDTO findById(@RequestParam int id) {

        return service.findByID(id);
    }

    @RequestMapping
    public Page<Processo> getAll(
            @RequestParam(value = "page", defaultValue = "0") Integer pagina,
            @RequestParam(value = "size", defaultValue = "10") Integer tamanho,
            @RequestParam(value = "campo", defaultValue = "id") String campo,
            @RequestParam(value = "direcao", defaultValue = "asc") String direcao
    ) {
        return service.getAll(pagina, tamanho, campo, direcao);
    }

    @PutMapping
    public ProcessoDTO update(@RequestParam("dados") String dados, @RequestParam("file") MultipartFile file) throws IOException {

        ProcessoDTO dto = new ObjectMapper().readValue(dados, ProcessoDTO.class);
        dto.setDocumento(file.getBytes());

        return service.update(dto);
    }

    @PatchMapping("{id}")
    public ProcessoDTO dataVisualizacao(@PathVariable int id) {

      return  service.dataVisualizacao(id);
    }
}
