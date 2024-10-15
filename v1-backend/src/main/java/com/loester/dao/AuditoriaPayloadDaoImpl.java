package com.loester.dao;

import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.loester.entity.AuditoriaPayload;
import com.loester.mapper.AuditoriaPayloadRowMapper;

@Repository
public class AuditoriaPayloadDaoImpl implements AuditoriaPayloadDao {
    private final NamedParameterJdbcTemplate template;

    public AuditoriaPayloadDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public AuditoriaPayload inserirAuditoria(AuditoriaPayload auditoria) {
        String sql = "INSERT INTO tb_auditoria_payload (descricao, usuario, data_hora) VALUES (:descricao, :usuario, :data_hora)";

        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("descricao", auditoria.getDescricao())
                .addValue("usuario", auditoria.getUsuario())
                .addValue("data_hora", auditoria.getDataHora());

        KeyHolder holder = new GeneratedKeyHolder();
        template.update(sql, paramSource, holder);

        auditoria.setId(extracted(holder).intValue());
        return auditoria;
    }

	private Number extracted(KeyHolder holder) {
		return holder.getKey();
	}

    @Override
    public List<AuditoriaPayload> listarTodaAuditoria() {
        String sql = "SELECT * FROM tb_auditoria_payload";
        return template.query(sql, new AuditoriaPayloadRowMapper());
    }
}
