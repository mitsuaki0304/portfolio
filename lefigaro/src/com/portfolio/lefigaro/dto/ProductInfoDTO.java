package com.portfolio.lefigaro.dto;

public class ProductInfoDTO {
	private int productId;

	private String productName;

	private String productDetail;

	private int categoryId;

	private int price;

	private int weight;

	private int vintage;

	private String area;

	private String kind;

	private String taiste;

	private double reviewStar;

	private int reviewUserCount;

	private String imageFilePath;

	private String imageFileName;


	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}

	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductDetail(){
		return productDetail;
	}
	public void setProductDetail(String productDetail){
		this.productDetail = productDetail;
	}

	public int getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}

	public int getWeight(){
		return weight;
	}
	public void setWeight(int weight){
		this.weight =  weight;
	}

	public int getVintage(){
		return vintage;
	}
	public void setVintage(int  vintage){
		this.vintage =  vintage;
	}

	public String getArea(){
		return area;
	}
	public void setArea(String  area){
		this.area =  area;
	}

	public String getKind(){
		return kind;
	}
	public void setKind(String  kind){
		this.kind =  kind;
	}

	public String getTaiste(){
		return taiste;
	}
	public void setTaiste(String taiste){
		this.taiste =  taiste;
	}

	public double getReviewStar(){
		return reviewStar;
	}
	public void setReviewStar(double  reviewStar){
		this.reviewStar =  reviewStar;
	}

	public int getReviewUserCount(){
		return reviewUserCount;
	}
	public void setReviewUserCount(int reviewUserCount){
		this.reviewUserCount = reviewUserCount;
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
