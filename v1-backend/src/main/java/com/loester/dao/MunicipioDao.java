package com.loester.dao;

import java.util.List;
import com.loester.entity.Municipio;

public interface MunicipioDao {

    /**
     * Recupera todos os registros de Município do banco de dados.
     * 
     * @return Lista de objetos Municipio.
     */
    List<Municipio> findAll();

    /**
     * Recupera um registro de Município pelo seu ID.
     * 
     * @param id O ID do Município.
     * @return O objeto Municipio, ou null se não encontrado.
     */
    Municipio findById(Integer id);
    
    /**
     * Insere um novo registro de Município no banco de dados.
     * 
     * @param municipio O objeto Municipio a ser inserido.
     * @return O objeto Municipio inserido, incluindo o ID gerado.
     */
    Municipio insertMunicipio(Municipio municipio);

    /**
     * Atualiza um registro existente de Município no banco de dados.
     * 
     * @param municipio O objeto Municipio com os dados atualizados.
     * @return O objeto Municipio atualizado, ou null se não encontrado.
     */
    Municipio updateMunicipio(Municipio municipio);

    /**
     * Remove um registro de Município do banco de dados.
     * 
     * @param municipio O objeto Municipio a ser removido.
     */
    void deleteMunicipio(Municipio municipio);

    /**
     * Remove um registro de Município do banco de dados pelo seu ID.
     * 
     * @param id O ID do Município a ser removido.
     */
    void deleteMunicipioById(Integer id);
    
    /**
     * Verifica se um Município existe pelo ID.
     * 
     * @param id O ID do Município.
     * @return true se o Município existir, false caso contrário.
     */
    boolean existsById(Integer id);
}
