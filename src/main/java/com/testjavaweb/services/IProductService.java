package com.testjavaweb.services;

import java.util.List;

import com.testjavaweb.model.ProductModel;
import com.testjavaweb.paging.Pageble;

public interface IProductService {
	ProductModel save(ProductModel productModel);
	ProductModel update(ProductModel updateProduct);
	void delete(long[] ids);
	List<ProductModel> findAll(Pageble pageble);
	int getTotalItem();
	ProductModel findOne(long id);
}
