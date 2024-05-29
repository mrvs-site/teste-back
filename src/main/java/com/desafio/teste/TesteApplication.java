package com.desafio.teste;

import com.desafio.teste.model.Processo;
import com.desafio.teste.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class TesteApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner run(@Autowired ProcessoRepository repository){

		return args -> {
			Processo p = Processo.builder()
					.npu("12345678909")
					.municipio("Recife")
					.uf("PE")
					.dataCadastro(LocalDateTime.now())
					.build();

			repository.save(p);

			Processo p1 = Processo.builder()
					.npu("9845606506")
					.municipio("Olinda")
					.uf("PE")
					.dataCadastro(LocalDateTime.now())
					.build();

			repository.save(p1);

			Processo p2 = Processo.builder()
					.npu("32102506506")
					.municipio("Bonito")
					.uf("PE")
					.dataCadastro(LocalDateTime.now())
					.build();

			repository.save(p2);

			Processo p3 = Processo.builder()
					.npu("00111220120")
					.municipio("Belo Horizonte")
					.uf("MG")
					.dataCadastro(LocalDateTime.now())
					.dataVisualizacao(LocalDateTime.now())
					.build();

			repository.save(p3);


			Processo p4 = Processo.builder()
					.npu("55011011")
					.municipio("FLorianópolis")
					.uf("SC")
					.dataCadastro(LocalDateTime.now())
					.build();

			repository.save(p4);


			Processo p5 = Processo.builder()
					.npu("6633225451")
					.municipio("Salvador")
					.uf("BA")
					.dataCadastro(LocalDateTime.now())
					.build();

			repository.save(p5);


			Processo p6 = Processo.builder()
					.npu("0002223255")
					.municipio("Natal")
					.uf("RN")
					.dataCadastro(LocalDateTime.now())
					.build();

			repository.save(p6);

			Processo p7 = Processo.builder()
					.npu("9845606506")
					.municipio("Olinda")
					.uf("PE")
					.dataCadastro(LocalDateTime.now())
					.dataVisualizacao(LocalDateTime.now())
					.build();

			repository.save(p7);


			Processo p8 = Processo.builder()
					.npu("33366555221")
					.municipio("Salgueiro")
					.uf("PE")
					.dataCadastro(LocalDateTime.now())
					.build();

			repository.save(p8);


			Processo p9 = Processo.builder()
					.npu("98456065060000")
					.municipio("Pesqueira")
					.uf("PE")
					.dataCadastro(LocalDateTime.now())
					.dataVisualizacao(LocalDateTime.now())
					.build();

			repository.save(p9);

			Processo p10 = Processo.builder()
					.npu("9845606343433506")
					.municipio("Caruaru")
					.uf("PE")
					.dataCadastro(LocalDateTime.now())
					.dataVisualizacao(LocalDateTime.now())
					.build();

			repository.save(p10);

			Processo p11 = Processo.builder()
					.npu("5054065087")
					.municipio("Alagoas")
					.uf("AL")
					.dataCadastro(LocalDateTime.now())
					.dataVisualizacao(LocalDateTime.now())
					.build();

			repository.save(p11);
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}

}
