package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.DestinationDAO;
import com.portfolio.lefigaro.dto.DestinationInfoDTO;

public class CreateDestinationCompleteAction  extends ActionSupport implements SessionAware {
	private String userId;
	private String telNum;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String addressNum;
	private String region;
	private String city;
	private String other;
	private String tempId;
	private String flg;

	public Map<String, Object> session;
	private DestinationDAO destinationDAO = new  DestinationDAO();
	private ArrayList<DestinationInfoDTO> destinationList = new ArrayList<DestinationInfoDTO>();
	public String execute() throws SQLException {
		String result = SUCCESS;
		System.out.println("userId"+userId);
		destinationDAO.createDestination(
				session.get("userId").toString(),
				session.get("familyName").toString(),
				session.get("firstName").toString(),
				session.get("familyNameKana").toString(),
				session.get("firstNameKana").toString(),
				session.get("telNum").toString(),
				session.get("addressNum").toString(),
				session.get("region").toString(),
				session.get("city").toString(),
				session.get("other").toString());



		if(!(tempId.isEmpty()))
		{
			System.out.println("userddddddddddddId"+userId);
			System.out.println("tempddddddddddddId"+tempId);
			destinationList=destinationDAO.getUserDestinaton(userId);
			session.put("destinationList", destinationList);
			session.put("tempId", tempId);
			flg="1";
			session.put("flg", flg);
			result="buyPay";
			return result;
		}


		return result;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getTempId(){
		return tempId;
	}
	public void setTempId(String tempId){
		this.tempId = tempId;
	}

	public String getFlg(){
		return flg;
	}
	public void setFlg(String flg){
		this.flg = flg;
	}

}