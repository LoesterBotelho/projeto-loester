package com.loester.mapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import com.loester.entity.Municipio;
import com.loester.annotation.ColumnName;

public class MunicipioRowMapper implements RowMapper<Municipio> {

	@Override
	public Municipio mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
		Municipio map = new Municipio();

		for (Field field : Municipio.class.getDeclaredFields()) {
			ColumnName columnName = field.getAnnotation(ColumnName.class);
			if (columnName != null) {
				field.setAccessible(true);
				try {
					Object columnValue = rs.getObject(columnName.value());
					if (columnValue != null) {
						field.set(map, columnValue);
					} else {
						field.set(map, null);
					}
				} catch (IllegalAccessException e) {
					throw new SQLException("Error accessing field " + field.getName(), e);
				} catch (SQLException e) {
					throw new SQLException("Error getting value for column " + columnName.value(), e);
				}
			}
		}

		return map;
	}
}
