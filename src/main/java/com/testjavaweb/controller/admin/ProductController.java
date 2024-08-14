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
import com.testjavaweb.model.ProductModel;
import com.testjavaweb.paging.PageRequest;
import com.testjavaweb.paging.Pageble;
import com.testjavaweb.services.IProductService;
import com.testjavaweb.sort.Sorter;
import com.testjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-product"})
public class ProductController extends HttpServlet{
	private static final long serialVersionUID = 2686801510274002166L;
	
	@Inject
	private IProductService productService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductModel model = FormUtil.toModel(ProductModel.class, req);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)){
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(productService.findAll(pageble));
			model.setTotalItem(productService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/product/list.jsp";

		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null){
				model = productService.findOne(model.getId());
			}else {

			}
			view = "/views/admin/product/edit.jsp";
		}
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
