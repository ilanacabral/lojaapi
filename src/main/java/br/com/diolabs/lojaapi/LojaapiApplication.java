package br.com.diolabs.lojaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Classe principal da API, habilita o uso OpenFeign na interface {@link FruitAPIService} 
 * 
 */
@SpringBootApplication
@EnableFeignClients
public class LojaapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaapiApplication.class, args);
	}

}
