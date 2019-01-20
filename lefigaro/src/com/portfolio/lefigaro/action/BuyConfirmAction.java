package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.CartDAO;
import com.portfolio.lefigaro.dao.DestinationDAO;
import com.portfolio.lefigaro.dto.CartInfoDTO;
import com.portfolio.lefigaro.dto.DestinationInfoDTO;

public class BuyConfirmAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private int id;
	private int sum;
	private String userId;
	private String pay;
	private String tempId;
	private String flg;

	private ArrayList<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();
	private ArrayList<DestinationInfoDTO> destinationList = new ArrayList<DestinationInfoDTO>();
	private CartDAO cartDAO = new CartDAO();
	private DestinationDAO destinationDAO = new DestinationDAO();
	public DestinationInfoDTO dto = new DestinationInfoDTO();

	public String execute() throws SQLException {

		if (pay.equals("1")) {
			pay = "現金払い";
			System.out.println("pay" + pay);
			session.put("pay", pay);
		} else {
			pay = "クレジットカード";
			session.put("pay", pay);
		}
		sum = Integer.parseInt(String.valueOf(cartDAO.getCartTotalPrice(tempId)));
		session.put("sum", sum);
		cartList = cartDAO.serchCartInfo(userId, tempId);
		session.put("cartList", cartList);
		System.out.println("FLG"+flg);
		if(!(flg.isEmpty())) {
			destinationList=destinationDAO.getNewDestinaton(userId);
			session.put("destinationList", destinationList);
		}else {

		destinationList = destinationDAO.serchDestinaton(id);
		session.put("destinationList", destinationList);
		}
		String result = SUCCESS;
		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public ArrayList<CartInfoDTO> getCartList() {
		return this.cartList;
	}

	public void setCartList(ArrayList<CartInfoDTO> cartList) {
		this.cartList = cartList;
	}

	public ArrayList<DestinationInfoDTO> getDestinationList() {
		return this.destinationList;
	}

	public void setDestinationList(ArrayList<DestinationInfoDTO> destinationList) {
		this.destinationList = destinationList;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getFlg(){
		return flg;
	}
	public void setFlg(String flg){
		this.flg = flg;
	}
}