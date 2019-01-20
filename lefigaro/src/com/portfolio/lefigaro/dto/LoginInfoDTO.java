package com.portfolio.lefigaro.dto;
import java.util.Date;
public class LoginInfoDTO {
	private String userId;

	private String userPass;

	private String familyName;

	private String firstName;

	private String familyNameKana;

	private String firstNameKana;

	private String email;

	private boolean loginFlg = false;

//	private boolean admin_flg = false;

	private boolean reviewFlg = false;

	private Date registDate;

	private Date updateDate;

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

	public boolean getLoginFlg(){
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg){
		this.loginFlg=loginFlg;
	}

//	public boolean getAdminFlg(){
//		return admin_flg;
//	}
//	public void setAdminFlg(boolean admin_flg){
//		this.admin_flg=admin_flg;
//	}

	public boolean getReviewFlg(){
		return reviewFlg;
	}
	public void setReviewFlg(boolean reviewFlg){
		this.reviewFlg=reviewFlg;
	}

	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
