package com.testjavaweb.services.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.testjavaweb.dao.ICaotegoryDAO;
import com.testjavaweb.dao.INewsDAO;
import com.testjavaweb.model.CategoryModel;
import com.testjavaweb.model.NewsModel;
import com.testjavaweb.paging.Pageble;
import com.testjavaweb.services.INewsService;

public class NewsService implements INewsService{
	
	@Inject
	private INewsDAO newsDAO;

	@Inject
	private ICaotegoryDAO caotegoryDAO;
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId){
		return newsDAO.findByCategoryId(categoryId);
	}
	
	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = caotegoryDAO.findOneByCode(newsModel.getCategoryCode());
		newsModel.setCategoryId(category.getId());
		Long newsId = newsDAO.save(newsModel);
		return newsDAO.findOne(newsId);
	}
	
	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNews = newsDAO.findOne(updateNews.getId());
		updateNews.setCreateDate(oldNews.getCreateDate());
		updateNews.setCreateBy(oldNews.getCreateBy());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = caotegoryDAO.findOneByCode(updateNews.getCategoryCode());
		updateNews.setCategoryId(category.getId());
		newsDAO.update(updateNews);
		return newsDAO.findOne(updateNews.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			//phải delete comment trước, do comment nó có chứa khóa ngoại của bài viết
			newsDAO.delete(id);
		}
	}

	@Override
	public List<NewsModel> findAll(Pageble pageble) {
		return newsDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newsDAO.getTotalItem();
	}

	@Override
	public NewsModel findOne(long id) {
		NewsModel newsModel = newsDAO.findOne(id);
		CategoryModel categoryModel = caotegoryDAO.findOne(newsModel.getCategoryId());
		newsModel.setCategoryCode(categoryModel.getCode());
		return newsModel;
	}
}
