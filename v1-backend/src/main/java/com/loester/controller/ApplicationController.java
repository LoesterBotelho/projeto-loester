package com.loester.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.loester.entity.Pessoa;
import com.loester.entity.AuditoriaPayload;
import com.loester.entity.Municipio;

@RestController
@RequestMapping("/api")
public class ApplicationController {

	private final PessoaController pessoaController;
	private final MunicipioController municipioController;
	private final AuditoriaPayloadController auditoriaPayloadController;

	public ApplicationController(PessoaController pessoaController, MunicipioController municipioController,
			AuditoriaPayloadController auditoriaPayloadController) {
		this.pessoaController = pessoaController;
		this.municipioController = municipioController;
		this.auditoriaPayloadController = auditoriaPayloadController;
	}

	// ----------------------------------------------------------------------------------

	@GetMapping("/pessoas")
	public ResponseEntity<List<Pessoa>> getAllPessoas() {
		return pessoaController.getAllPessoas();
	}

	@GetMapping("/pessoas/{id}")
	public ResponseEntity<Optional<Pessoa>> getPessoaById(@PathVariable int id) {
		return pessoaController.getPessoaById(id);
	}

	@PostMapping("/pessoas")
	public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
		return pessoaController.createPessoa(pessoa);
	}

	@PutMapping("/pessoas/{id}")
	public ResponseEntity<Optional<Pessoa>> updatePessoa(@PathVariable int id, @RequestBody Pessoa pessoa) {
		return pessoaController.updatePessoa(id, pessoa);
	}

	@DeleteMapping("/pessoas/{id}")
	public ResponseEntity<Void> deletePessoa(@PathVariable int id) {
		return pessoaController.deletePessoa(id);
	}

	// ----------------------------------------------------------------------------------

	@GetMapping("/municipios")
	public ResponseEntity<List<Municipio>> getAllMunicipios() {
		return municipioController.getAllMunicipios();
	}

	@GetMapping("/municipios/{id}")
	public ResponseEntity<Optional<Municipio>> getMunicipioById(@PathVariable int id) {
		return municipioController.getMunicipioById(id);
	}

	@PostMapping("/municipios")
	public ResponseEntity<Municipio> createMunicipio(@RequestBody Municipio municipio) {
		return municipioController.createMunicipio(municipio);
	}

	@PutMapping("/municipios/{id}")
	public ResponseEntity<Optional<Municipio>> updateMunicipio(@PathVariable int id, @RequestBody Municipio municipio) {
		return municipioController.updateMunicipio(id, municipio);
	}

	@DeleteMapping("/municipios/{id}")
	public ResponseEntity<Void> deleteMunicipio(@PathVariable int id) {
		return municipioController.deleteMunicipio(id);
	}

	// ----------------------------------------------------------------------------------

	@GetMapping("/auditorias")
	public ResponseEntity<List<AuditoriaPayload>> getAllAuditorias() {
		return auditoriaPayloadController.getAllAuditoria();
	}

	@PostMapping("/auditorias")
	public ResponseEntity<AuditoriaPayload> createAuditoria(@RequestBody AuditoriaPayload auditoriaPayload) {
		return auditoriaPayloadController.createAuditoria(auditoriaPayload);
	}

	// ----------------------------------------------------------------------------------

}
