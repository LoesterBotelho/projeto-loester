package com.loester.dao;

import java.util.List;
import com.loester.entity.Pessoa;

public interface PessoaDao {

    /**
     * Recupera todos os registros de Pessoa do banco de dados.
     * 
     * @return Lista de objetos Pessoa.
     */
    List<Pessoa> findAll();

    /**
     * Recupera um registro de Pessoa pelo seu ID.
     * 
     * @param id O ID da Pessoa.
     * @return O objeto Pessoa, ou null se não encontrado.
     */
    Pessoa findById(Integer id);
    
    /**
     * Insere um novo registro de Pessoa no banco de dados.
     * 
     * @param pessoa O objeto Pessoa a ser inserido.
     * @return O objeto Pessoa inserido, incluindo o ID gerado.
     */
    Pessoa insertPessoa(Pessoa pessoa);

    /**
     * Atualiza um registro existente de Pessoa no banco de dados.
     * 
     * @param pessoa O objeto Pessoa com os dados atualizados.
     * @return O objeto Pessoa atualizado, ou null se não encontrado.
     */
    Pessoa updatePessoa(Pessoa pessoa);

    /**
     * Remove um registro de Pessoa do banco de dados.
     * 
     * @param pessoa O objeto Pessoa a ser removido.
     */
    void deletePessoa(Pessoa pessoa);

    /**
     * Remove um registro de Pessoa do banco de dados pelo seu ID.
     * 
     * @param id O ID da Pessoa a ser removida.
     */
    void deletePessoaById(Integer id);
    
    /**
     * Verifica se uma Pessoa existe pelo ID.
     * 
     * @param id O ID da Pessoa.
     * @return true se a Pessoa existir, false caso contrário.
     */
    boolean existsById(Integer id);
}
