package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.CartDAO;
import com.portfolio.lefigaro.dto.CartInfoDTO;

public class CartAction  extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

	private CartDAO cartDAO = new CartDAO();
	private ArrayList<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();
	private String userId;
	private int productId;
	private int sum;
	private int price;
	private String tempId;
	private String deleteFlg;
	private int id;
	private String message;


	public String execute() throws SQLException{
		System.out.println("flg"+deleteFlg);
		if (deleteFlg == null) {
			cartList = cartDAO.getCartInfo(tempId);
			session.put("cartList", cartList);
			sum = Integer.parseInt(String.valueOf(cartDAO.getCartTotalPrice(tempId)));
			session.put("sum",sum);
			session.put("tempId", tempId);
		} else if (deleteFlg.equals("1")) {
			delete();
		}

			String result = SUCCESS;
			return result;
		}
	public void delete() throws SQLException {
		System.out.println("temoId"+tempId);
		cartDAO.deleteCart(tempId);
		cartList = cartDAO.getCartInfo(tempId);
		session.put("cartList", cartList);
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

	public int getProductId(){
		return productId;
	}
	public void setProducrId(int productId){
		this.productId=productId;
	}
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
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

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}


}
