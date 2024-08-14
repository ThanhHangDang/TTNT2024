package com.testjavaweb.services;

import java.util.List;

import com.testjavaweb.model.NewsModel;
import com.testjavaweb.paging.Pageble;

public interface INewsService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel updateNews);
	void delete(long[] ids);
	List<NewsModel> findAll(Pageble pageble);
	int getTotalItem();
	NewsModel findOne(long id);
}
