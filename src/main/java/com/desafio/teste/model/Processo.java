package com.desafio.teste.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate dataCadastro;

    @Column(name = "data_visualizacao")
    private LocalDate dataVisualizacao;

    @Column(nullable = false)
    private String municipio;

    @Column(nullable = false)
    private String uf;

    @Lob
    @Column(nullable = true)
    private byte[] documento;

    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDate.now());
    }


}
