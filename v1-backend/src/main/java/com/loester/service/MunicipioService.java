package com.loester.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loester.dao.MunicipioDao;
import com.loester.entity.Municipio;

@Service
public class MunicipioService {

    private static final Logger logger = LoggerFactory.getLogger(MunicipioService.class);

    @Autowired
    private MunicipioDao municipioDao;

    public List<Municipio> findAll() {
        logger.info("Buscando todos os municípios.");
        return municipioDao.findAll();
    }

    public Optional<Municipio> findById(Integer id) {
        logger.info("Buscando município com ID: {}", id);
        return Optional.ofNullable(municipioDao.findById(id));
    }

    public Municipio createMunicipio(Municipio municipio) {
        logger.info("Inserindo o município: {}", municipio.getNome());
        return municipioDao.insertMunicipio(municipio);
    }

    public Optional<Municipio> updateMunicipio(int id, Municipio municipio) {
        logger.info("Atualizando o município com ID: {}", id);
        if (municipioDao.existsById(id)) {
            municipio.setId(id);
            return Optional.of(municipioDao.updateMunicipio(municipio));
        } else {
            logger.warn("Município com ID {} não encontrado para atualização.", id);
            return Optional.empty();
        }
    }

    public boolean deleteMunicipio(int id) {
        logger.info("Removendo o município com ID: {}", id);
        if (municipioDao.existsById(id)) {
            municipioDao.deleteMunicipioById(id);
            return true;
        } else {
            logger.warn("Município com ID {} não encontrado para remoção.", id);
            return false;
        }
    }
}
