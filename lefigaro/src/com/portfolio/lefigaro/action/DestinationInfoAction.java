package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.DestinationDAO;
import com.portfolio.lefigaro.dto.DestinationInfoDTO;


public class DestinationInfoAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

	private String userId;

	private DestinationDAO destinationDAO  = new DestinationDAO();
	private ArrayList<DestinationInfoDTO> destinationList = new ArrayList<DestinationInfoDTO>();

	public String execute() throws SQLException{

			destinationList=destinationDAO.getUserDestinaton(userId);
			session.put("destinationList", destinationList);
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}



}
