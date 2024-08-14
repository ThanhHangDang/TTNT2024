package com.testjavaweb.services.impl;

import java.util.List;

import javax.inject.Inject;

import com.testjavaweb.dao.ICaotegoryDAO;
import com.testjavaweb.model.CategoryModel;
import com.testjavaweb.services.ICategoryService;

public class CategoryService implements ICategoryService{
	
	//Sử dụng java servlet weld, để có thể gọi nhiều các class imp cái DAO
	@Inject
	private ICaotegoryDAO caotegoryDAO;
	
	@Override
	public List<CategoryModel> findAll(){
		return caotegoryDAO.findAll();
	}
}
