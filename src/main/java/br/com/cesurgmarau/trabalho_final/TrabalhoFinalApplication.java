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
		Dotenv dotenv = Dotenv.load();

		Map<String, Object> envVars = new HashMap<>();
		dotenv.entries().forEach(entry -> envVars.put(entry.getKey(), entry.getValue()));

		SpringApplication app = new SpringApplication(TrabalhoFinalApplication.class);

		app.addInitializers(context -> {
			context.getEnvironment().getPropertySources()
					.addFirst(new MapPropertySource("dotenv", envVars));
		});

		app.run(args);
	}
}
