package com.portfolio.lefigaro.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private String userId;
	private String tempId;
	public String execute() {
		session.put("userId", userId);
		session.put("tempId", tempId);
		System.out.println("tempId"+tempId);
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object>session){
		this.session = session;
	}
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}


	public String getTempId(){
		return tempId;
	}
	public void setTempId(String tempId){
		this.tempId = tempId;
	}

}