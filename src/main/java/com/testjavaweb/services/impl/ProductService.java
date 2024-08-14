package com.testjavaweb.services.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.testjavaweb.dao.IProductDAO;
import com.testjavaweb.model.ProductModel;
import com.testjavaweb.paging.Pageble;
import com.testjavaweb.services.IProductService;

public class ProductService implements IProductService{
	
	@Inject
	private IProductDAO productDAO;
	
	@Override
	public ProductModel save(ProductModel productModel) {
		productModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
		Long productId = productDAO.save(productModel);
		return productDAO.findOne(productId);
	}
	
	@Override
	public ProductModel update(ProductModel updateProduct) {
		ProductModel oldProduct = productDAO.findOne(updateProduct.getId());
		updateProduct.setCreateDate(oldProduct.getCreateDate());
		updateProduct.setCreateBy(oldProduct.getCreateBy());
		updateProduct.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		productDAO.update(updateProduct);
		return productDAO.findOne(updateProduct.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			productDAO.delete(id);
		}
	}

	@Override
	public List<ProductModel> findAll(Pageble pageble) {
		return productDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return productDAO.getTotalItem();
	}

	@Override
	public ProductModel findOne(long id) {
		ProductModel productModel = productDAO.findOne(id);
		return productModel;
	}
}
