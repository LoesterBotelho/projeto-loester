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

import com.loester.entity.Municipio;
import com.loester.mapper.MunicipioRowMapper;

@Repository
public class MunicipioDaoImpl implements MunicipioDao {
    private final NamedParameterJdbcTemplate template;

    public MunicipioDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Municipio> findAll() {
        String sql = "SELECT * FROM tb_municipios";
        return template.query(sql, new MunicipioRowMapper());
    }

    @Override
    public Municipio findById(Integer id) {
        String sql = "SELECT * FROM tb_municipios WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        List<Municipio> municipios = template.query(sql, params, new MunicipioRowMapper());
        return municipios.isEmpty() ? null : municipios.get(0);
    }

    @Override
    public Municipio insertMunicipio(Municipio municipio) {
        String sql = "INSERT INTO tb_municipios (nome, estado) VALUES (:nome, :estado)";

        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("nome", municipio.getNome())
                .addValue("estado", municipio.getEstado());

        KeyHolder holder = new GeneratedKeyHolder();
        template.update(sql, paramSource, holder);

        municipio.setId(extracted(holder).intValue());
        return municipio;
    }

	private Number extracted(KeyHolder holder) {
		return holder.getKey();
	}

    @Override
    public Municipio updateMunicipio(Municipio municipio) {
        String sql = "UPDATE tb_municipios SET nome = :nome, estado = :estado WHERE id = :id";

        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", municipio.getId())
                .addValue("nome", municipio.getNome())
                .addValue("estado", municipio.getEstado());

        template.update(sql, paramSource);
        
        return municipio;
    }

    @Override
    public void deleteMunicipio(Municipio municipio) {
        deleteMunicipioById(municipio.getId());
    }

    @Override
    public void deleteMunicipioById(Integer id) {
        String sql = "DELETE FROM tb_municipios WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        template.update(sql, params);
    }

    @Override
    public boolean existsById(Integer id) {
        String sql = "SELECT COUNT(*) FROM tb_municipios WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        
        Integer count = template.queryForObject(sql, params, Integer.class);
        return count != null && count > 0;
    }
}
