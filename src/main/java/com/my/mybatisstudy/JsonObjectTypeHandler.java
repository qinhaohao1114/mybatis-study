package com.my.mybatisstudy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JsonObjectTypeHandler<T> extends BaseTypeHandler<T> {

	private Class<T> type;

	public static ObjectMapper objectMapper=new ObjectMapper();

	public JsonObjectTypeHandler(Class<T> type) {
		if (type == null) {
			throw new IllegalArgumentException("Type argument cannot be null");
		}
		this.type = type;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
		try {
			ps.setString(i, objectMapper.writeValueAsString(parameter));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String result = rs.getString(columnName);
		return toJsonNode(result);
	}

	@Override
	public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String result = rs.getString(columnIndex);
		return toJsonNode(result);
	}

	@Override
	public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String result = cs.getString(columnIndex);
		return toJsonNode(result);
	}

	private T toJsonNode(String s) {
		if (s == null) {
			return null;
		}
		try {
			return objectMapper.readValue(s, type);
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Cannot convert [ " + s + " ] to JsonNode.", e);
		}
	}

}