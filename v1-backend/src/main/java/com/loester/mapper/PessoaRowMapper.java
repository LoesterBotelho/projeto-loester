package com.loester.mapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import com.loester.entity.Pessoa;
import com.loester.annotation.ColumnName;

public class PessoaRowMapper implements RowMapper<Pessoa> {

	@Override
	public Pessoa mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
		Pessoa map = new Pessoa();

		for (Field field : Pessoa.class.getDeclaredFields()) {
			ColumnName columnName = field.getAnnotation(ColumnName.class);
			if (columnName != null) {
				field.setAccessible(true);
				try {
					Object columnValue = rs.getObject(columnName.value());

					if (columnValue != null) {
						if (field.getType().isAssignableFrom(columnValue.getClass())) {
							field.set(map, columnValue);
						} else {

							if (field.getType() == Integer.class) {
								field.set(map, ((Number) columnValue).intValue());
							} else if (field.getType() == String.class) {
								field.set(map, String.valueOf(columnValue));
							} else {
								throw new SQLException("Type mismatch for field " + field.getName());
							}
						}
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
