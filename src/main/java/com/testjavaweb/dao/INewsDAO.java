package com.testjavaweb.dao;

import java.util.List;

import com.testjavaweb.model.NewsModel;
import com.testjavaweb.paging.Pageble;

public interface INewsDAO extends GenericDAO<NewsModel> {
	List<NewsModel> findByCategoryId(Long categoryId);
	
	Long save(NewsModel newsModel);
	NewsModel findOne(Long id);
	void update(NewsModel updateNews);
	void delete(long id);
	List<NewsModel> findAll(Pageble pageble);
	int getTotalItem();
}
