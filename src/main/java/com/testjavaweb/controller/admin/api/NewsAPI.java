package com.testjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testjavaweb.model.NewsModel;
import com.testjavaweb.model.UserModel;
import com.testjavaweb.services.INewsService;
import com.testjavaweb.utils.HttpUtils;
import com.testjavaweb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsAPI extends HttpServlet{
	
	@Inject 
	private INewsService newsService;
	
	private static final long serialVersionUID = -915988021506484384L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel newsModel = HttpUtils.of(req.getReader()).ToModel(NewsModel.class);
		newsModel.setCreateBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		newsModel = newsService.save(newsModel);
		mapper.writeValue(resp.getOutputStream(), newsModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel updateNews = HttpUtils.of(req.getReader()).ToModel(NewsModel.class);
		updateNews.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		updateNews = newsService.update(updateNews);
		mapper.writeValue(resp.getOutputStream(), updateNews);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel newsModel = HttpUtils.of(req.getReader()).ToModel(NewsModel.class);
		newsService.delete(newsModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
