package com.testjavaweb.dao;

import java.util.List;

import com.testjavaweb.model.CategoryModel;

public interface ICaotegoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	CategoryModel findOneByCode(String code);
}
