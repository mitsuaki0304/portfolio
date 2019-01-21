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

	private ArrayList<DestinationInfoDTO> destinationList = new ArrayList<DestinationInfoDTO>();
	private String tempId;
	public String execute() throws SQLException{

		if(session.containsKey("userId")){

			cartDAO.insertUserId(userId, tempId);

			destinationList=destinationDAO.getUserDestinaton(userId);
			session.put("destinationList", destinationList);
			session.put("tempId", tempId);
			String result = SUCCESS;
			return result;
		}

		String result = "login";

		type="buy";
		session.put("tempId", tempId);
		session.put("type", type);
		return result;
	}


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
