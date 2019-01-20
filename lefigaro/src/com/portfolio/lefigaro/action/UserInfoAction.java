package com.portfolio.lefigaro.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.LoginDAO;
import com.portfolio.lefigaro.dto.LoginInfoDTO;

public class UserInfoAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private String userId;
	private String userPass;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
	public String execute(){
		System.out.println("userId"+userId);
		System.out.println("userPass"+userPass);
		loginInfoDTO = loginDAO.getLoginUserInfo(userId, userPass);
		session.put("userId", userId);
		session.put("familyName",loginInfoDTO.getFamilyName());
		session.put("firstName",loginInfoDTO.getFirstName());
		session.put("familyNameKana",loginInfoDTO.getFamilyNameKana());
		session.put("firstNameKana",loginInfoDTO.getFirstNameKana());
		session.put("email",loginInfoDTO.getEmail());
		session.put("registDate",loginInfoDTO.getRegistDate());
		System.out.println("sesion"+loginInfoDTO.getRegistDate());
		return SUCCESS;
	}


	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

}
