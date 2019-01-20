package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.BuyHistoryDAO;
import com.portfolio.lefigaro.dao.CartDAO;
import com.portfolio.lefigaro.dto.CartInfoDTO;

public class BuyCompleteAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private String userId;
	private String tempId;
	private String pay;

	private int id;
	private BuyHistoryDAO buyHistoryDAO = new BuyHistoryDAO();
	private CartDAO cartDAO = new CartDAO();

	private ArrayList<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();

	private String addressNum;
	private String region;
	private String city;
	private String other;

	public String execute() throws SQLException {

		cartList = cartDAO.serchCartInfo(userId, tempId);
		for (int i = 0; i < cartList.size(); ++i) {
			System.out.println("userId"+cartList.get(i).getUserId());
			System.out.println("TotalPrice"+cartList.get(i).getTotalPrice());
			System.out.println("idsssssssssss"+id);
			System.out.println("userIddadadadaddddddddddddddddddddddd");
			buyHistoryDAO.buyProductInfo(
					cartList.get(i).getUserId(),
					cartList.get(i).getProductId(),
					cartList.get(i).getProductCount(),
					cartList.get(i).getTotalPrice(),
					id
					);
		}
		cartDAO.deleteCart(tempId);
		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getTempId(){
		return tempId;
	}
	public void setTempId(String tempId){
		this.tempId = tempId;
	}

	public ArrayList<CartInfoDTO>getCartList(){
		return this.cartList;
	}
	public void serCartList(ArrayList<CartInfoDTO>cartList){
		this.cartList = cartList;
	}

	public String getPay(){
		return pay;
	}

	public void setPay(String pay){
		this.pay = pay;
	}
	public String getAddressNum() {
		return addressNum;
	}

	public void setAddressNum(String addressNum) {
		this.addressNum = addressNum;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city=city;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}



}