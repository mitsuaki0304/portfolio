package com.portfolio.lefigaro.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateReviewConfirmAction  extends ActionSupport implements SessionAware{

	private String title;
	private int reviewStar;
	private String comment;
	public Map<String,Object> session;
	private String errorMassage;
	private String userId;
	private int productId;

	public String execute(){
		String result = SUCCESS;
		System.out.println("confirm"+userId);
		if(!(title.equals(""))
			&&!(reviewStar==0)
			&&!(comment.equals(""))){
				session.put("userId", userId);
				session.put("productId", productId);
				session.put("title", title);
				session.put("reviewStar", reviewStar);
				session.put("comment", comment);
			}else{
				setErrorMassage("未入力の項目があります。");
				result = ERROR;
			}
		return result;
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


	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
	public String getErrorMassage(){
		return errorMassage;
	}
	public void setErrorMassage(String errorMassage){
		this.errorMassage=errorMassage;
	}
}
