package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.CartDAO;
import com.portfolio.lefigaro.dto.CartInfoDTO;

public class CartInAction  extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

	private CartDAO cartDAO = new CartDAO();
	private ArrayList<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();
	private String userId;
	private int productId;
	private int productCount;
	private int price;
	private String tempId;
	private int sum;

	public String execute() throws SQLException{

			int intPrice = Integer.parseInt(session.get("price").toString());
			int totalPrice = productCount*intPrice;

			cartDAO.cartIn(userId, tempId, productId, productCount, totalPrice);

			cartList = cartDAO.getCartInfo(tempId);
			session.put("cartList", cartList);
			sum = Integer.parseInt(String.valueOf(cartDAO.getCartTotalPrice(tempId)));
			session.put("sum",sum);
			session.put("tempId",tempId);

			String result = SUCCESS;
			return result;
		}



	@Override
	public void setSession(Map<String,Object>session){
		this.session= session;
	}
	public Map<String,Object>getSession(){
		return this.session;
	}
	public ArrayList<CartInfoDTO>getCartList(){
		return this.cartList;
	}
	public void serCartList(ArrayList<CartInfoDTO>cartList){
		this.cartList = cartList;
	}

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId=productId;
	}

	public int getProductCount(){
		return productCount;
	}
	public void setProductCount(int productCount){
		this.productCount=productCount;
	}

	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}

	public String getTempId(){
		return tempId;
	}
	public void setTempId(String tempId){
		this.tempId = tempId;
	}


}