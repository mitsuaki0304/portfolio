package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.ProductDAO;
import com.portfolio.lefigaro.dao.ReviewDAO;
import com.portfolio.lefigaro.dto.ProductInfoDTO;
import com.portfolio.lefigaro.dto.ReviewInfoDTO;

public class ProductDetailAction extends ActionSupport implements SessionAware {
	private String userId;
	public Map<String, Object> session;

	private ArrayList<ProductInfoDTO> productList = new ArrayList<ProductInfoDTO>();
	private ArrayList<ReviewInfoDTO> reviewList = new ArrayList<ReviewInfoDTO>();
 	ReviewInfoDTO reviewInfoDTO = new ReviewInfoDTO();
	private int productId;

	public String execute() throws SQLException {
		ProductDAO productDAO = new ProductDAO();
		ProductInfoDTO productInfoDTO  = new ProductInfoDTO();
		ReviewDAO reviewDAO = new ReviewDAO();

		productInfoDTO = productDAO.getProductInfo(productId);
		session.put("productId", productInfoDTO.getProductId());
		session.put("productName", productInfoDTO.getProductName());
		session.put("productDetail", productInfoDTO.getProductDetail());
		session.put("categoryId", productInfoDTO.getCategoryId());
		session.put("price", productInfoDTO.getPrice());
		session.put("weight", productInfoDTO.getWeight());
		session.put("vintage", productInfoDTO.getVintage());
		session.put("area", productInfoDTO.getArea());
		session.put("kind", productInfoDTO.getKind());
		session.put("taiste", productInfoDTO.getTaiste());
		session.put("reviewStar", productInfoDTO.getReviewStar());
		session.put("reviewUserCount", productInfoDTO.getReviewUserCount());
		session.put("imageFilePath", productInfoDTO.getImageFilePath());
		session.put("imageFileName", productInfoDTO.getImageFileName());

		if(!(session.containsKey("tempId"))){
		session.put("tempId", UUID.randomUUID());
		}
		if(session.containsKey("userId")){
			System.out.println("ProductDetailcontainskeyuserID"+userId);
		}

		reviewList=reviewDAO.serchReview(productId);
		session.put("reviewList", reviewList);



		String result = SUCCESS;
		return result;

	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

	public ArrayList<ProductInfoDTO>getBuyItemList(){
		return this.productList;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
	public ArrayList<ReviewInfoDTO>getReviewList(){
		return this.reviewList;
	}

	public void setReviewList(ArrayList<ReviewInfoDTO> reviewList) {
		this.reviewList =reviewList;
	}


}
