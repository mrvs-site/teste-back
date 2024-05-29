package com.desafio.teste.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String npu;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "data_visualizacao")
    private LocalDateTime dataVisualizacao;

    @Column(nullable = false)
    private String municipio;

    @Column(nullable = false)
    private String uf;

    @Lob
    @Column(nullable = true)
    private byte[] documento;

    @Column(name = "nome_documento")
    private String nomeDocumento;

    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDateTime.now());
    }


}
