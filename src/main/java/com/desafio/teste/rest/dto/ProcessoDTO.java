package com.desafio.teste.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessoDTO {

    private Integer id;

    private String npu;

    private LocalDate dataCadastro;

    private LocalDate dataVisualizacao;

    private String municipio;

    private String uf;

    private byte[] documento;

}
