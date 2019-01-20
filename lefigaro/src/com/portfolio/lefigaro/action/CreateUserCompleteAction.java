package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.UserCreateDAO;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware {

	private String userId;
	private String userPass;
	private String email;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;


	public Map<String, Object> session;
	private UserCreateDAO userCreateDAO = new UserCreateDAO();


	public String execute() throws SQLException {

		userCreateDAO.createUser(
				session.get("userId").toString(),
				session.get("userPass").toString(),
				session.get("email").toString(),
				session.get("firstName").toString(),
				session.get("familyName").toString(),
				session.get("firstNameKana").toString(),
				session.get("familyNameKana").toString()
				);

		String result = SUCCESS;

		return result;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserPass(){
		return userPass;
	}

	public void setUserPass(String userPass){
		this.userPass = userPass;
	}

	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}

	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFamilyNameKana(){
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana = firstNameKana;
	}

	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
