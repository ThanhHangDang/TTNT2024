package com.testjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.testjavaweb.model.ProductModel;

public class ProductMapper implements RowMapper<ProductModel>{
	@Override
	public ProductModel mapRow(ResultSet resultSet) {
		try {
			ProductModel product = new ProductModel();
			product.setId(resultSet.getLong("id"));
			product.setName(resultSet.getString("name"));
			product.setType(resultSet.getString("type"));
			product.setPrice(resultSet.getLong("price"));
			product.setQuantity(resultSet.getLong("quantity"));
			product.setDescription(resultSet.getString("description"));
			product.setImage(resultSet.getString("image"));
			product.setCreateDate(resultSet.getTimestamp("createdate"));
			product.setCreateBy(resultSet.getString("createby"));
			if(resultSet.getTimestamp("modifieddate") != null) {
				product.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getTimestamp("modifiedby") != null) {
				product.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return product;
		} catch (SQLException e) {
			return null;
		}
	}
}
