package com.loester.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.loester.entity.AuditoriaPayload;
import com.loester.service.AuditoriaPayloadService;

@RestController
@RequestMapping("/api/auditoria")
public class AuditoriaPayloadController {

    private final AuditoriaPayloadService auditoriaService;

    public AuditoriaPayloadController(AuditoriaPayloadService auditoriaService) {
        this.auditoriaService = auditoriaService;
    }

    /**
     * Inserts a new audit record.
     * 
     * @param auditoria The audit record to be inserted.
     * @return A response entity containing the inserted audit record.
     */
    @PostMapping
    public ResponseEntity<AuditoriaPayload> createAuditoria(@RequestBody AuditoriaPayload auditoria) {
    	AuditoriaPayload createdAuditoria = auditoriaService.insertAuditoria(auditoria);
        return new ResponseEntity<>(createdAuditoria, HttpStatus.CREATED);
    }

    /**
     * Retrieves all audit records.
     * 
     * @return A response entity containing a list of all audit records.
     */
    @GetMapping
    public ResponseEntity<List<AuditoriaPayload>> getAllAuditoria() {
        List<AuditoriaPayload> auditoriaList = auditoriaService.findAllAuditoria();
        return new ResponseEntity<>(auditoriaList, HttpStatus.OK);
    }
}
