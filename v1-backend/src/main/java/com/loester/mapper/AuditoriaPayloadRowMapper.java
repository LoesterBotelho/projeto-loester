package com.loester.mapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import com.loester.entity.AuditoriaPayload;
import com.loester.annotation.ColumnName;

public class AuditoriaPayloadRowMapper implements RowMapper<AuditoriaPayload> {

    @Override
    public AuditoriaPayload mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
    	AuditoriaPayload auditoria = new AuditoriaPayload();

        for (Field field : AuditoriaPayload.class.getDeclaredFields()) {
            ColumnName columnName = field.getAnnotation(ColumnName.class);
            if (columnName != null) {
                field.setAccessible(true);
                try {
                    Object columnValue = rs.getObject(columnName.value());
                    if (columnValue != null) {
                        field.set(auditoria, columnValue);
                    } else {
                        field.set(auditoria, null);
                    }
                } catch (IllegalAccessException e) {
                    throw new SQLException("Error accessing field " + field.getName(), e);
                } catch (SQLException e) {
                    throw new SQLException("Error getting value for column " + columnName.value(), e);
                }
            }
        }

        return auditoria;
    }
}
