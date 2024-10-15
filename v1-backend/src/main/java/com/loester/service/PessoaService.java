package com.loester.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loester.dao.PessoaDao;
import com.loester.entity.Pessoa;

@Service
public class PessoaService {

    private static final Logger logger = LoggerFactory.getLogger(PessoaService.class);

    @Autowired
    private PessoaDao pessoaDao;

    public List<Pessoa> findAll() {
        logger.info("Buscando todas as pessoas.");
        return pessoaDao.findAll();
    }

    public Optional<Pessoa> findById(Integer id) {
        logger.info("Buscando pessoa com ID: {}", id);
        return Optional.ofNullable(pessoaDao.findById(id));
    }

    public Pessoa createPessoa(Pessoa pessoa) {
        logger.info("Inserindo a pessoa: {}", pessoa.getNome());
        return pessoaDao.insertPessoa(pessoa);
    }

    public Optional<Pessoa> updatePessoa(int id, Pessoa pessoa) {
        logger.info("Atualizando a pessoa com ID: {}", id);
        if (pessoaDao.existsById(id)) {
            pessoa.setId(id);
            return Optional.of(pessoaDao.updatePessoa(pessoa));
        } else {
            logger.warn("Pessoa com ID {} não encontrada para atualização.", id);
            return Optional.empty();
        }
    }

    public boolean deletePessoa(int id) {
        logger.info("Removendo a pessoa com ID: {}", id);
        if (pessoaDao.existsById(id)) {
            pessoaDao.deletePessoaById(id);
            return true;
        } else {
            logger.warn("Pessoa com ID {} não encontrada para remoção.", id);
            return false;
        }
    }
}
