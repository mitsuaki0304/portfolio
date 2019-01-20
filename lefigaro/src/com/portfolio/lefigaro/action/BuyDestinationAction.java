package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.CartDAO;
import com.portfolio.lefigaro.dao.DestinationDAO;
import com.portfolio.lefigaro.dto.DestinationInfoDTO;

public class BuyDestinationAction  extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private String type;
	private String userId;
	private CartDAO cartDAO = new CartDAO();
	private DestinationDAO destinationDAO  = new DestinationDAO();
//	private LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
	private ArrayList<DestinationInfoDTO> destinationList = new ArrayList<DestinationInfoDTO>();
	private String tempId;
	public String execute() throws SQLException{
		System.out.println("buyuserId"+userId);

		if(session.containsKey("userId")){

			System.out.println("成功");
//			String userId = session.get("userId").toString();

			cartDAO.insertUserId(userId, tempId);

			destinationList=destinationDAO.getUserDestinaton(userId);
			session.put("destinationList", destinationList);
			session.put("tempId", tempId);
			String result = SUCCESS;
			return result;
		}
		System.out.println("失敗");
		String result = "login";

		type="buy";
		session.put("tempId", tempId);
		session.put("type", type);
		return result;
	}

//		CartDAO cartDAO = new CartDAO();
//		CartInfoDTO cartInfoDTO = cartDAO.getCartItemInfo();
//		session.put("itemId", cartInfoDTO.getItemId());
//		session.put("itemCount", cartInfoDTO.getItemCount());
//		session.put("totalPrice", cartInfoDTO.getTotalPrice());
//		session.put("regist_date", cartInfoDTO.getRegist_date());

//		String result = "login";
//		if(session.containsKey("id")){
//			CartDAO cartDAO = new CartDAO();
//			CartInfoDTO cartInfoDTO = cartDAO.getCartItemInfo();
//			session.put("id",cartInfoDTO.getId());
//			session.put("buyItem_name",cartInfoDTO.getItemName());
//			session.put("buyItem_price",cartInfoDTO.getItemPrice());
//			return SUCCESS;
//		}
//		String cart;
//		session.put("type", cart);
//		return result;


	@Override
	public void setSession(Map<String,Object>session){
		this.session= session;
	}
	public Map<String,Object>getSession(){
		return this.session;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId=tempId;
	}

}
