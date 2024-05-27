package com.desafio.teste.service;

import com.desafio.teste.model.Municipio;
import com.desafio.teste.model.Uf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RegiaoService {


    @Autowired
    private RestTemplate restTemplate;

    public Municipio[] getMunicipio(@PathVariable String uf) {
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + uf + "/municipios";

        try {
            ResponseEntity<Municipio[]> responseEntity = restTemplate.getForEntity(url, Municipio[].class);
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Erro " + e.getMessage());
        }
    }

    public Uf[] getUf() {
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";

        try {
            ResponseEntity<Uf[]> responseEntity = restTemplate.getForEntity(url, Uf[].class);
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Erro " + e.getMessage());
        }
    }


}
