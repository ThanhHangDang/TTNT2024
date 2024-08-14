package com.testjavaweb.dao.impl;

import java.util.List;

import com.testjavaweb.dao.IProductDAO;
import com.testjavaweb.mapper.ProductMapper;
import com.testjavaweb.model.ProductModel;
import com.testjavaweb.paging.Pageble;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO{
	@Override
	public Long save(ProductModel productModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO product (name, type,");
		sql.append(" price, quantity, description, image, createdate, createby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), productModel.getName(), productModel.getType(), productModel.getPrice(), productModel.getQuantity(), productModel.getDescription(), productModel.getImage(), productModel.getCreateDate(), productModel.getCreateBy());
	}

	@Override
	public ProductModel findOne(Long id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		List<ProductModel> product = query(sql, new ProductMapper(), id);
		return product.isEmpty() ? null : product.get(0);
	}

	@Override
	public void update(ProductModel updateProduct) {
		StringBuilder sql = new StringBuilder("UPDATE product SET name = ?, type = ?,");
		sql.append(" price = ?, quantity = ?, description = ?, image = ?,");
		sql.append(" createdate = ?, createby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		System.out.println(updateProduct.getName());
		System.out.println(updateProduct.getType());
		System.out.println(updateProduct.getPrice());
		System.out.println(updateProduct.getQuantity());
		System.out.println(updateProduct.getDescription());
		System.out.println(updateProduct.getImage());
		System.out.println(updateProduct.getCreateDate());
		System.out.println(updateProduct.getCreateBy());
		System.out.println(updateProduct.getModifiedDate());
		System.out.println(updateProduct.getModifiedBy());
		System.out.println(updateProduct.getId());
		update(sql.toString(), updateProduct.getName(), updateProduct.getType(), updateProduct.getPrice(), updateProduct.getQuantity(), updateProduct.getDescription(), updateProduct.getImage(), updateProduct.getCreateDate(), updateProduct.getCreateBy(), updateProduct.getModifiedDate(), updateProduct.getModifiedBy(), updateProduct.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM product WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<ProductModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM product");
		if(pageble.getSorter() != null) {
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		if(pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"");
		}
		return query(sql.toString(), new ProductMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM product";
		return count(sql);
	}
}
