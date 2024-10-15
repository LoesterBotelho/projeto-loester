package com.loester.dao;

import java.util.List;

import com.loester.entity.AuditoriaPayload;

public interface AuditoriaPayloadDao {

    /**
     * Insere um novo registro de auditoria no banco de dados.
     * 
     * @param auditoria O objeto Auditoria a ser inserido.
     * @return O objeto Auditoria inserido, incluindo o ID gerado.
     */
	AuditoriaPayload inserirAuditoria(AuditoriaPayload auditoria);

    /**
     * Recupera todos os registros de auditoria do banco de dados.
     * 
     * @return Lista de objetos Auditoria.
     */
    List<AuditoriaPayload> listarTodaAuditoria();
}
