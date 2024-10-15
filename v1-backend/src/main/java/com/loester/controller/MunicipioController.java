package com.loester.controller;

import com.loester.entity.Municipio;
import com.loester.service.MunicipioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    private final MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping
    public ResponseEntity<List<Municipio>> getAllMunicipios() {
        List<Municipio> municipios = municipioService.findAll();
        return ResponseEntity.ok(municipios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Municipio>> getMunicipioById(@PathVariable Integer id) {
        Optional<Municipio> municipio = municipioService.findById(id); 
        return municipio.isPresent() 
            ? ResponseEntity.ok(municipio) 
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
    }

    @PostMapping
    public ResponseEntity<Municipio> createMunicipio(@RequestBody Municipio municipio) {
        Municipio novoMunicipio = municipioService.createMunicipio(municipio); 
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMunicipio); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Municipio>> updateMunicipio(@PathVariable Integer id, @RequestBody Municipio municipio) {
        Optional<Municipio> municipioAtualizado = municipioService.updateMunicipio(id, municipio);
        return municipioAtualizado.isPresent() 
            ? ResponseEntity.ok(municipioAtualizado)
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMunicipio(@PathVariable Integer id) {
        if (municipioService.deleteMunicipio(id)) {
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        }
    }
}
