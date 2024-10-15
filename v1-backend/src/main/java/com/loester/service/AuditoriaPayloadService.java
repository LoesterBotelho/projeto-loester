package com.loester.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.loester.dao.AuditoriaPayloadDao;
import com.loester.entity.AuditoriaPayload;

@Service
public class AuditoriaPayloadService {

    private final AuditoriaPayloadDao auditoriaDao;

    public AuditoriaPayloadService(AuditoriaPayloadDao auditoriaDao) {
        this.auditoriaDao = auditoriaDao;
    }

    /**
     * Inserts a new audit record into the database.
     * 
     * @param auditoria The audit record to be inserted.
     * @return The inserted audit record, including any generated fields.
     */
    public AuditoriaPayload insertAuditoria(AuditoriaPayload auditoria) {
        return auditoriaDao.inserirAuditoria(auditoria);
    }

    /**
     * Retrieves all audit records from the database.
     * 
     * @return A list of all audit records.
     */
    public List<AuditoriaPayload> findAllAuditoria() {
        return auditoriaDao.listarTodaAuditoria();
    }
}
