package com.loester.controller;

import com.loester.entity.Pessoa;
import com.loester.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        List<Pessoa> pessoas = pessoaService.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> getPessoaById(@PathVariable int id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);

        return pessoa.isPresent()
            ? ResponseEntity.ok(pessoa) 
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
        Pessoa novaPessoa = pessoaService.createPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> updatePessoa(@PathVariable int id, @RequestBody Pessoa pessoa) {
        Optional<Pessoa> pessoaAtualizada = pessoaService.updatePessoa(id, pessoa);
        return pessoaAtualizada.isPresent()
            ? ResponseEntity.ok(pessoaAtualizada) 
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable int id) {
        if (pessoaService.deletePessoa(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
