package com.loester;

import java.util.HashMap;

import org.hibernate.mapping.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loester.model.StatusResponse;

@SpringBootApplication
@RestController
public class TesteLoesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteLoesterApplication.class, args);
	}

	@GetMapping("/health")
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.ok("Application is running");
	}

	@GetMapping(value = "/status")
	public StatusResponse getStatus() {
		Map<String, String> dependencies = new HashMap<>();
		dependencies.put("database", "UP");
		dependencies.put("externalService", "UP"); // SE ESTIVER "DOWN" - REQUSITOS DE CONSUMO DE API EXTERNA FORA DO AR
		return new StatusResponse("UP", "1.0.0", dependencies);
	}
}
