package com.desafio.teste.service;

import com.desafio.teste.model.Processo;
import com.desafio.teste.repository.ProcessoRepository;
import com.desafio.teste.rest.dto.ProcessoDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProcessoService {

    private final ProcessoRepository repository;

    public Page<Processo> getAll(int pagina, int tamanho, String campo, String direcao) {


        Sort sort = Sort.by(Sort.Direction.fromString(direcao), campo);
        PageRequest pageRequest = PageRequest.of(pagina, tamanho, sort);



        return  repository.findAll(pageRequest);
    }

    public ProcessoDTO findByID(int id) {

        var p = repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));

        return ProcessoToDto(p);
    }

    public ProcessoDTO create(ProcessoDTO dto) {

        if (repository.existsByNpu(dto.getNpu())) {
            throw new RuntimeException("NPU Já Cadastrada");
        }

        Processo processoSalvo = repository.save(DtoToProcesso(dto));

        return ProcessoToDto(processoSalvo);
    }


    public ProcessoDTO update(ProcessoDTO dto) {

        repository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Não encontrado"));

        var p = repository.save(DtoToProcesso(dto));

        return ProcessoToDto(p);
    }

    public void delete(int id) {

        repository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado"));

        repository.deleteById(id);

    }


    private Processo DtoToProcesso(ProcessoDTO dto) {

        return Processo.builder()
                .id(dto.getId())
                .npu(dto.getNpu())
                .uf(dto.getUf())
                .municipio(dto.getMunicipio())
                .dataCadastro(dto.getDataCadastro())
                .dataVisualizacao(dto.getDataVisualizacao())
                .documento(dto.getDocumento())
                .build();
    }

    private ProcessoDTO ProcessoToDto(Processo p) {

        return ProcessoDTO
                .builder()
                .id(p.getId())
                .npu(p.getNpu())
                .uf(p.getUf())
                .municipio(p.getMunicipio())
                .dataCadastro(p.getDataCadastro())
                .dataVisualizacao(p.getDataVisualizacao())
                .documento(p.getDocumento())
                .build();
    }

}
