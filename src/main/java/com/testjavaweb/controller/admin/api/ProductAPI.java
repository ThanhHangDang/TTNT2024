package com.testjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testjavaweb.model.ProductModel;
import com.testjavaweb.model.UserModel;
import com.testjavaweb.services.IProductService;
import com.testjavaweb.utils.HttpUtils;
import com.testjavaweb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-product"})
public class ProductAPI extends HttpServlet{
	
	@Inject
	private IProductService productService;
	
	private static final long serialVersionUID = -915988021506484384L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProductModel productModel = HttpUtils.of(req.getReader()).ToModel(ProductModel.class);
		productModel.setCreateBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		productModel = productService.save(productModel);
		mapper.writeValue(resp.getOutputStream(), productModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProductModel productModel = HttpUtils.of(req.getReader()).ToModel(ProductModel.class);
		productModel.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		productModel = productService.update(productModel);
		mapper.writeValue(resp.getOutputStream(), productModel);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProductModel productModel = HttpUtils.of(req.getReader()).ToModel(ProductModel.class);
		productService.delete(productModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
