package com.testjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.testjavaweb.dao.GenericDAO;
import com.testjavaweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {

	ResourceBundle dbbundle = ResourceBundle.getBundle("db");

	public Connection getConnection() {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/javatestproject1";
//			String user = "root";
//			String password = "caphemanhzu1997";
			Class.forName(dbbundle.getString("driverName"));
			String url = dbbundle.getString("url");
			String user = dbbundle.getString("user");
			String password = dbbundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters){
		List<T> results =new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			//set parameter
			setParameters(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (Exception e) {
			return null;
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	private void setParameters(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if(parameter instanceof Long) {
					statement.setLong(index, (Long) (parameter));
				}
				else if (parameter instanceof String) {
					statement.setString(index, (String) (parameter));
				}
				else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) (parameter));
				}
				else if (parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Long id = null;
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
			setParameters(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			int count = 0;
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			//set parameter
			setParameters(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (Exception e) {
			return 0;
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
	}
}
