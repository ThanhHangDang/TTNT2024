package com.testjavaweb.dao.impl;

import java.util.List;

import com.testjavaweb.dao.ICaotegoryDAO;
import com.testjavaweb.mapper.CategoryMapper;
import com.testjavaweb.mapper.NewsMapper;
import com.testjavaweb.model.CategoryModel;
import com.testjavaweb.model.NewsModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICaotegoryDAO{
	
	@Override
	public List<CategoryModel> findAll(){
		String sql = "SELECT * FROM Category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(Long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), id);
		return category.isEmpty() ? null : category.get(0);
	}

    @Override
    public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), code);
		return category.isEmpty() ? null : category.get(0);
    }
}
