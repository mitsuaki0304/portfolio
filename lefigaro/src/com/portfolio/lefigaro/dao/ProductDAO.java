package com.portfolio.lefigaro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.portfolio.lefigaro.dto.ProductInfoDTO;
import com.portfolio.lefigaro.util.DBConnector;

public class ProductDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public Map<String, Object> session;

	public ArrayList<ProductInfoDTO> getProductListInfo() throws SQLException {

		ArrayList<ProductInfoDTO> productInfoDTO = new ArrayList<ProductInfoDTO>();
		String sql = "SELECT pi.product_id, pi.product_name, pi.product_detail, pi.category_id, pi.price, pi.weight, pi.vintage, pi.area, pi.kind, pi.taiste, pi.image_file_path, pi.image_file_name, ur.review_star ,ua.review_user_count from product_info as pi left join (select product_id, round(avg(review_star),1) as review_star from user_review GROUP BY product_id) as ur on pi.product_id = ur.product_id left join (select product_id, round(count(review_star),1) as review_user_count from user_review GROUP BY product_id) as ua on pi.product_id = ua.product_id";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ProductInfoDTO  dto = new ProductInfoDTO ();
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductDetail(resultSet.getString("product_detail"));
				dto.setCategoryId(resultSet.getInt("category_id"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setWeight(resultSet.getInt("weight"));
				dto.setVintage(resultSet.getInt("vintage"));
				dto.setArea(resultSet.getString("area"));
				dto.setKind(resultSet.getString("kind"));
				dto.setTaiste(resultSet.getString("taiste"));
				dto.setReviewStar(resultSet.getDouble("review_star"));
				dto.setReviewUserCount(resultSet.getInt("review_user_count"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return productInfoDTO ;
	}

	public ProductInfoDTO getProductInfo(int productId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		String sql = "SELECT pi.product_id, pi.product_name, pi.product_detail, pi.category_id, pi.price, pi.weight, pi.vintage, pi.area, pi.kind, pi.taiste, pi.image_file_path, pi.image_file_name, ur.review_star ,ua.review_user_count from product_info as pi left join (select product_id, round(avg(review_star),1) as review_star from user_review GROUP BY product_id) as ur on pi.product_id = ur.product_id left join (select product_id, round(count(review_star),1) as review_user_count from user_review GROUP BY product_id) as ua on pi.product_id = ua.product_id where pi.product_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductDetail(resultSet.getString("product_detail"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setWeight(resultSet.getInt("weight"));
				productInfoDTO.setVintage(resultSet.getInt("vintage"));
				productInfoDTO.setArea(resultSet.getString("area"));
				productInfoDTO.setKind(resultSet.getString("kind"));
				productInfoDTO.setTaiste(resultSet.getString("taiste"));
				productInfoDTO.setReviewStar(resultSet.getDouble("review_star"));
				productInfoDTO.setReviewUserCount(resultSet.getInt("review_user_count"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTO;
	}

	public ArrayList<ProductInfoDTO> sortProductList(String sql) throws SQLException {

		ArrayList<ProductInfoDTO> productInfoDTO = new ArrayList<ProductInfoDTO>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ProductInfoDTO  dto = new ProductInfoDTO ();
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductDetail(resultSet.getString("product_detail"));
				dto.setCategoryId(resultSet.getInt("category_id"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setWeight(resultSet.getInt("weight"));
				dto.setVintage(resultSet.getInt("vintage"));
				dto.setArea(resultSet.getString("area"));
				dto.setKind(resultSet.getString("kind"));
				dto.setTaiste(resultSet.getString("taiste"));
				dto.setReviewStar(resultSet.getDouble("review_star"));
				dto.setReviewUserCount(resultSet.getInt("review_user_count"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return productInfoDTO ;
	}

	public ArrayList<ProductInfoDTO> refineCategory(int categoryId) throws SQLException {

		ArrayList<ProductInfoDTO> productInfoDTO = new ArrayList<ProductInfoDTO>();
		String sql = "SELECT pi.product_id, pi.product_name, pi.product_detail, pi.category_id, pi.price, pi.weight, pi.vintage, pi.area, pi.kind, pi.taiste, pi.image_file_path, pi.image_file_name, ur.review_star ,ua.review_user_count from product_info as pi left join (select product_id, round(avg(review_star),1) as review_star from user_review GROUP BY product_id) as ur on pi.product_id = ur.product_id left join (select product_id, round(count(review_star),1) as review_user_count from user_review GROUP BY product_id) as ua on pi.product_id = ua.product_id where category_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, categoryId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ProductInfoDTO  dto = new ProductInfoDTO ();
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductDetail(resultSet.getString("product_detail"));
				dto.setCategoryId(resultSet.getInt("category_id"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setWeight(resultSet.getInt("weight"));
				dto.setVintage(resultSet.getInt("vintage"));
				dto.setArea(resultSet.getString("area"));
				dto.setKind(resultSet.getString("kind"));
				dto.setTaiste(resultSet.getString("taiste"));
				dto.setReviewStar(resultSet.getDouble("review_star"));
				dto.setReviewUserCount(resultSet.getInt("review_user_count"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return productInfoDTO ;
	}

	public ArrayList<ProductInfoDTO> refineArea(String area) throws SQLException {

		ArrayList<ProductInfoDTO> productInfoDTO = new ArrayList<ProductInfoDTO>();
		String sql = "SELECT pi.product_id, pi.product_name, pi.product_detail, pi.category_id, pi.price, pi.weight, pi.vintage, pi.area, pi.kind, pi.taiste, pi.image_file_path, pi.image_file_name, ur.review_star ,ua.review_user_count from product_info as pi left join (select product_id, round(avg(review_star),1) as review_star from user_review GROUP BY product_id) as ur on pi.product_id = ur.product_id left join (select product_id, round(count(review_star),1) as review_user_count from user_review GROUP BY product_id) as ua on pi.product_id = ua.product_id where area=?";
		System.out.println("area"+area);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, area);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ProductInfoDTO  dto = new ProductInfoDTO ();
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductDetail(resultSet.getString("product_detail"));
				dto.setCategoryId(resultSet.getInt("category_id"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setWeight(resultSet.getInt("weight"));
				dto.setVintage(resultSet.getInt("vintage"));
				dto.setArea(resultSet.getString("area"));
				dto.setKind(resultSet.getString("kind"));
				dto.setTaiste(resultSet.getString("taiste"));
				dto.setReviewStar(resultSet.getDouble("review_star"));
				dto.setReviewUserCount(resultSet.getInt("review_user_count"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return productInfoDTO ;
	}
	public ArrayList<ProductInfoDTO> refineKind(String kind) throws SQLException {

		ArrayList<ProductInfoDTO> productInfoDTO = new ArrayList<ProductInfoDTO>();
		String sql = "SELECT pi.product_id, pi.product_name, pi.product_detail, pi.category_id, pi.price, pi.weight, pi.vintage, pi.area, pi.kind, pi.taiste, pi.image_file_path, pi.image_file_name, ur.review_star ,ua.review_user_count from product_info as pi left join (select product_id, round(avg(review_star),1) as review_star from user_review GROUP BY product_id) as ur on pi.product_id = ur.product_id left join (select product_id, round(count(review_star),1) as review_user_count from user_review GROUP BY product_id) as ua on pi.product_id = ua.product_id where kind=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, kind);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ProductInfoDTO  dto = new ProductInfoDTO ();
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductDetail(resultSet.getString("product_detail"));
				dto.setCategoryId(resultSet.getInt("category_id"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setWeight(resultSet.getInt("weight"));
				dto.setVintage(resultSet.getInt("vintage"));
				dto.setArea(resultSet.getString("area"));
				dto.setKind(resultSet.getString("kind"));
				dto.setTaiste(resultSet.getString("taiste"));
				dto.setReviewStar(resultSet.getDouble("review_star"));
				dto.setReviewUserCount(resultSet.getInt("review_user_count"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return productInfoDTO ;
	}
}
