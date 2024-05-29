package com.desafio.teste.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessoDTO {

    private Integer id;

    private String npu;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataVisualizacao;

    private String municipio;

    private String uf;

    private byte[] documento;

    private String nomeDocumento;

}
