package com.testjavaweb.dao;

import java.util.List;

import com.testjavaweb.model.ProductModel;
import com.testjavaweb.paging.Pageble;

public interface IProductDAO extends GenericDAO<ProductModel>{
	Long save(ProductModel newsModel);
	ProductModel findOne(Long id);
	void update(ProductModel updateProduct);
	void delete(long id);
	List<ProductModel> findAll(Pageble pageble);
	int getTotalItem();
}
