package br.com.cesurgmarau.trabalho_final;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TrabalhoFinalApplication {
	public static void main(String[] args) {
		SpringApplication.run(TrabalhoFinalApplication.class, args);
	}
}
