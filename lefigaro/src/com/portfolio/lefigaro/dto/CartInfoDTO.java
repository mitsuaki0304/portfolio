package com.portfolio.lefigaro.dto;

public class CartInfoDTO {
	private int id;
	private String userId;
	private String tempId;
	private  int productId;

	private int productCount;
	private int price;
	private int totalPrice;
	private String registDate;

	private String productName;

	private String imageFilePath;

	private String imageFileName;

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getTempId(){
		return tempId;
	}
	public void setTempId(String tempId){
		this.tempId = tempId;
	}


	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductCount(){
		return productCount;
	}
	public void setProductCount(int productCount){
		this.productCount= productCount;
	}

	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}


	public String getRegistDate(){
		return registDate;
	}
	public void setRegistDate(String registDate){
		this.registDate = registDate;
	}

	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
}
