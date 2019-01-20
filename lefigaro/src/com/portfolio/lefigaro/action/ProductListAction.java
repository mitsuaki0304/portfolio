package com.portfolio.lefigaro.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.ProductDAO;
import com.portfolio.lefigaro.dto.ProductInfoDTO;


public class ProductListAction extends ActionSupport implements SessionAware {
	private String userId;
	public Map<String, Object> session;
	private ProductDAO productDAO = new ProductDAO();
	private ArrayList<ProductInfoDTO> productList = new ArrayList<ProductInfoDTO>();
	public String execute() throws SQLException {


		productList = productDAO.getProductListInfo();

		session.put("productList", productList); //要査定
		String result = SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ArrayList<ProductInfoDTO>getProductList(){
		return this.productList ;
	}

	public void setProductList(ArrayList<ProductInfoDTO> productList) {
		this.productList = productList;
	}
	}