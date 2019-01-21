package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.ReviewDAO;

public class CreateReviewCompleteAction extends ActionSupport implements SessionAware{

	private String userId;
	private int productId;
	private String title;
	private int reviewStar;
	private String comment;
	public Map<String,Object>session;
	private ReviewDAO reviewDAO = new ReviewDAO();

	public String execute() throws SQLException {

		reviewDAO.userReview(
				userId,
				productId,
				title,
				reviewStar,
				comment
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

	public int getProdcutId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}

	public int getReviewStar(){
		return reviewStar;
	}
	public void setReviewStar(int reviewStar){
		this.reviewStar = reviewStar;
	}

	public String Comment(){
		return comment;
	}
	public void setComment(String comment){
		this.comment = comment;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
}
