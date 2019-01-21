package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dto.CartInfoDTO;

public class BuyPayAction extends ActionSupport implements SessionAware{
	private int id;
	private String userId;
	public Map<String, Object> session;
	private int sum;
	private String flg;

	private String tempId;

	private ArrayList<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();

	public String execute()throws SQLException{

		session.put("id", id);
		session.put("userId", userId);
		session.put("tempId", tempId);
		session.put("flg", flg);
		return SUCCESS;
	}

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setSession(Map<String,Object>session){
		this.session= session;
	}
	public Map<String,Object>getSession(){
		return this.session;
	}

	public int getSum(){
		return sum;
	}
	public void setSum(int sum){
		this.sum = sum;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public ArrayList<CartInfoDTO>getCartList(){
		return this.cartList;
	}
	public void setCartList(ArrayList<CartInfoDTO>cartList){
		this.cartList = cartList;
	}
	public String getFlg(){
		return flg;
	}
	public void setFlg(String flg){
		this.flg = flg;
	}

}

