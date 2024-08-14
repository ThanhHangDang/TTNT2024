package com.testjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testjavaweb.constant.SystemConstant;
import com.testjavaweb.model.NewsModel;
import com.testjavaweb.paging.PageRequest;
import com.testjavaweb.paging.Pageble;
import com.testjavaweb.services.ICategoryService;
import com.testjavaweb.services.INewsService;
import com.testjavaweb.sort.Sorter;
import com.testjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet{
	private static final long serialVersionUID = 2686801510274002166L;
	
	@Inject
	private INewsService newsService;

	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsModel model = FormUtil.toModel(NewsModel.class, req);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)){
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(newsService.findAll(pageble));
			model.setTotalItem(newsService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/product/list.jsp";

		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null){
				model = newsService.findOne(model.getId());
			}else {

			}
			req.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/product/edit.jsp";
		}
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
