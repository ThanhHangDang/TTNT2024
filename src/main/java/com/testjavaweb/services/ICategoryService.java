package com.testjavaweb.services;

import java.util.List;

import com.testjavaweb.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
