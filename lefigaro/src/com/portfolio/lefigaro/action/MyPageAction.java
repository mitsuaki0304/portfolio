package com.portfolio.lefigaro.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private String userId;
	private String userPass;
	private String tempId;
	public String execute() {
		System.out.println("mypageId" + userId);
		System.out.println("mypagePass" + userPass);
		session.put("userId", userId);
		session.put("userPass", userPass);
		System.out.println("tempId"+tempId);
		String result = SUCCESS;
		return result;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return this.session;
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
