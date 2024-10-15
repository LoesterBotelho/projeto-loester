package com.loester.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.loester.entity.Pessoa;
import com.loester.mapper.PessoaRowMapper;

@Repository
public class PessoaDaoImpl implements PessoaDao {
    private final NamedParameterJdbcTemplate template;

    public PessoaDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Pessoa> findAll() {
        String sql = "SELECT * FROM tb_pessoas";
        return template.query(sql, new PessoaRowMapper());
    }

    @Override
    public Pessoa findById(Integer id) {
        String sql = "SELECT * FROM tb_pessoas WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        List<Pessoa> pessoas = template.query(sql, params, new PessoaRowMapper());
        return pessoas.isEmpty() ? null : pessoas.get(0);
    }

    @Override
    public Pessoa insertPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO tb_pessoas (nome, telefone, cpf, endereco, numero, complemento, cep, bairro, nome_municipio, nome_estado) " +
                     "VALUES (:nome, :telefone, :cpf, :endereco, :numero, :complemento, :cep, :bairro, :nomeMunicipio, :nomeEstado)";

        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("nome", pessoa.getNome())
                .addValue("telefone", pessoa.getTelefone())
                .addValue("cpf", pessoa.getCpf())
                .addValue("endereco", pessoa.getEndereco())
                .addValue("numero", pessoa.getNumero())
                .addValue("complemento", pessoa.getComplemento())
                .addValue("cep", pessoa.getCep())
                .addValue("bairro", pessoa.getBairro());

        KeyHolder holder = new GeneratedKeyHolder();
        template.update(sql, paramSource, holder);
        

		pessoa.setId(extracted(holder).intValue());
        return pessoa;
    }

	private Number extracted(KeyHolder holder) {
		return holder.getKey();
	}

    @Override
    public Pessoa updatePessoa(Pessoa pessoa) {
        String sql = "UPDATE tb_pessoas SET nome = :nome, telefone = :telefone, cpf = :cpf, endereco = :endereco, " +
                     "numero = :numero, complemento = :complemento, cep = :cep, bairro = :bairro, " +
                     "nome_municipio = :nomeMunicipio, nome_estado = :nomeEstado WHERE id = :id";

        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", pessoa.getId())
                .addValue("nome", pessoa.getNome())
                .addValue("telefone", pessoa.getTelefone())
                .addValue("cpf", pessoa.getCpf())
                .addValue("endereco", pessoa.getEndereco())
                .addValue("numero", pessoa.getNumero())
                .addValue("complemento", pessoa.getComplemento())
                .addValue("cep", pessoa.getCep())
                .addValue("bairro", pessoa.getBairro());

        template.update(sql, paramSource);
        
        return pessoa;
    }

    @Override
    public void deletePessoa(Pessoa pessoa) {
        deletePessoaById(pessoa.getId());
    }

    @Override
    public void deletePessoaById(Integer id) {
        String sql = "DELETE FROM tb_pessoas WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        template.update(sql, params);
    }

    @Override
    public boolean existsById(Integer id) {
        String sql = "SELECT COUNT(*) FROM tb_pessoas WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        
        Integer count = template.queryForObject(sql, params, Integer.class);
        return count != null && count > 0;
    }

}
