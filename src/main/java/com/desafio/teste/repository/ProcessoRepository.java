package com.desafio.teste.repository;

import com.desafio.teste.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo, Integer> {

    public Boolean existsByNpu(String npu);

}
