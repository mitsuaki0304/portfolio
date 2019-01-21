package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.ReviewDAO;
import com.portfolio.lefigaro.dto.LoginInfoDTO;
import com.portfolio.lefigaro.dto.ReviewInfoDTO;

public class CreateReviewAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private String type;
	private String message;
	private ArrayList<ReviewInfoDTO> reviewList = new ArrayList<ReviewInfoDTO>();
	private LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
	private ReviewDAO reviewDAO = new ReviewDAO();
	private String userId;
	private int productId;
	public String execute()throws SQLException{

		if(session.containsKey("userId")){
			System.out.println("review-user"+userId);

			loginInfoDTO=reviewDAO.doublecheck(productId, userId);

			if (loginInfoDTO.getReviewFlg()) { //trueで書き込みありのデータ確認 二重書き込み禁止へ
				String result = ERROR;
				setMessage("すでにレビュー投稿されています。");
				reviewList=reviewDAO.serchReview(productId);
				return result;
			}

			String result = SUCCESS;
			return result;
		}
		String result = "login";

		type="review";
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
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<ReviewInfoDTO>getReviewList(){
		return this.reviewList;
	}
	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
