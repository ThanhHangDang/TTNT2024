package com.testjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.testjavaweb.model.NewsModel;

public class NewsMapper implements RowMapper<NewsModel> {
	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		try {
			NewsModel news = new NewsModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setCreateDate(resultSet.getTimestamp("createdate"));
			news.setCreateBy(resultSet.getString("createby"));
			if(resultSet.getTimestamp("modifieddate") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getTimestamp("modifiedby") != null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			return null;
		}
	}
}
