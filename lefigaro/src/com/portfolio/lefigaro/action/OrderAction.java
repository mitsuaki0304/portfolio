package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.ProductDAO;
import com.portfolio.lefigaro.dto.ProductInfoDTO;

public class OrderAction extends ActionSupport implements SessionAware {
	private String userId;
	private int sort;
	private String area;
	private String kind;
	private int categoryId;
	private String sql;
	public Map<String, Object> session;
	private ProductDAO productDAO = new ProductDAO();
	private ArrayList<ProductInfoDTO> productList = new ArrayList<ProductInfoDTO>();

	public String execute() throws SQLException {
		if (!(sort == 0)) {
			System.out.println("sort"+sort);
			switch (sort) {
			case 1:
				sql = "SELECT pi.product_id, pi.product_name, pi.product_detail, pi.category_id, pi.price, pi.weight, pi.vintage, pi.area, pi.kind, pi.taiste, pi.image_file_path, pi.image_file_name, ur.review_star ,ua.review_user_count from product_info as pi left join (select product_id, round(avg(review_star),1) as review_star from user_review GROUP BY product_id) as ur on pi.product_id = ur.product_id left join (select product_id, round(count(review_star),1) as review_user_count from user_review GROUP BY product_id) as ua on pi.product_id = ua.product_id order by pi.price desc";
				break;
			case 2:
				sql = "SELECT pi.product_id, pi.product_name, pi.product_detail, pi.category_id, pi.price, pi.weight, pi.vintage, pi.area, pi.kind, pi.taiste, pi.image_file_path, pi.image_file_name, ur.review_star ,ua.review_user_count from product_info as pi left join (select product_id, round(avg(review_star),1) as review_star from user_review GROUP BY product_id) as ur on pi.product_id = ur.product_id left join (select product_id, round(count(review_star),1) as review_user_count from user_review GROUP BY product_id) as ua on pi.product_id = ua.product_id order by pi.price asc";
				break;
			case 3:
				sql = "SELECT pi.product_id, pi.product_name, pi.product_detail, pi.category_id, pi.price, pi.weight, pi.vintage, pi.area, pi.kind, pi.taiste, pi.image_file_path, pi.image_file_name, ur.review_star ,ua.review_user_count from product_info as pi left join (select product_id, round(avg(review_star),1) as review_star from user_review GROUP BY product_id) as ur on pi.product_id = ur.product_id left join (select product_id, round(count(review_star),1) as review_user_count from user_review GROUP BY product_id) as ua on pi.product_id = ua.product_id order by ur.review_star desc";
				break;
			}
			productList = productDAO.sortProductList(sql);
			session.put("productList", productList);
		}

		if (!(categoryId == 0)) {
			productList = productDAO.refineCategory(categoryId);
			session.put("productList", productList);
		}

		if (!(Objects.equals(area, null))) {
			switch (area) {
			case "1":
				area = "フランス";
				break;
			case "2":
				area = "イタリア";
				break;
			case "3":
				area = "チリ";
				break;
			case "4":
				area = "アメリカ";
				break;
			case "5":
				area = "日本";
				break;
			}
			productList = productDAO.refineArea(area);
			session.put("productList", productList);
		}

		if (!(Objects.equals(kind, null))) {
			switch (kind) {
			case "1":
				kind = "カベルネソーヴィニヨン";
				break;
			case "2":
				kind = "メルロー";
				break;
			case "3":
				kind = "ピノ・ノワール";
				break;
			case "4":
				kind = "リースリング";
				break;
			case "5":
				kind = "甲州";
				break;
			}
			productList = productDAO.refineKind(kind);
			session.put("productList", productList);
		}

		String result = SUCCESS;
		return result;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getUserId() {
		return userId;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ArrayList<ProductInfoDTO> getProductList() {
		return this.productList;
	}

	public void setProductList(ArrayList<ProductInfoDTO> productList) {
		this.productList = productList;
	}
}
//package com.portfolio.lefigaro.action;
//
//import java.util.Map;
//
//import org.apache.struts2.interceptor.SessionAware;
//
//import com.opensymphony.xwork2.ActionSupport;
//import com.portfolio.lefigaro.dao.ProductDAO;
//
//public class OrderAction extends ActionSupport implements SessionAware {
//	public Map<String,Object> session;
//	public String area;
//	private ProductDAO productDAO = new ProductDAO();
//	public String execute() {
//		System.out.println("area"+area);
//
//		switch(area){
//		case "1":
//			area="フランス";
//			productDAO.refineArea(area);
//		case "2":
//			area="イタリア";
//			}
//
//	}
//
//	public Map<String, Object> getSession() {
//		return this.session;
//	}
//	@Override
//	public void setSession(Map<String, Object>session){
//		this.session = session;
//	}
//	public String getArea() {
//		return area;
//	}
//
//	public void setArea(String area) {
//		this.area=area;
//	}
//}
