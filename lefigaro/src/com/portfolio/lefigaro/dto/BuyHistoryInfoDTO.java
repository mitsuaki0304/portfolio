package com.portfolio.lefigaro.dto;

public class BuyHistoryInfoDTO {
	private String userId;

	private int productId;

	private String productName;

	private int productCount;

	private int price;

	private int totalPrice;

	private String pay;

	private String addressNum;

	private String region;

	private String city;

	private String other;

	private String insertDate;

	private String imageFilePath;

	private String imageFileName;

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
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


	public String getInsertDate(){
		return insertDate;
	}
	public void setInsertDate(String insertDate){
		this.insertDate = insertDate;
	}

	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getPay(){
		return pay;
	}
	public void setPay(String pay){
		this.pay=pay;
	}

	public String getAddressNum(){
		return addressNum;
	}
	public void setAddressNum(String addressNum){
		this.addressNum = addressNum;
	}

	public String getRegion(){
		return region;
	}
	public void setRegion(String region){
		this.region = region;
	}

	public String getCity(){
		return city;
	}
	public void setCity(String city){
		this.city = city;
	}

	public String getOther(){
		return other;
	}
	public void setOther(String other){
		this.other = other;
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
