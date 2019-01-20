package com.portfolio.lefigaro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.portfolio.lefigaro.dto.CartInfoDTO;
import com.portfolio.lefigaro.util.DBConnector;
import com.portfolio.lefigaro.util.DateUtil;

public class CartDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	public Map<String, Object> session;


	//#ProductDeteilで商品をカートに入れる
	public void cartIn(String userId, String tempId, int productId, int productCount ,int totalPrice )throws SQLException{
		 String sql = "INSERT INTO cart_info (user_id, temp_user_id, product_id, product_count, total_price, regist_date) VALUES(?,?,?,?,?,?)";

		try{
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, tempId);
			preparedStatement.setInt(3, productId);
			preparedStatement.setInt(4, productCount);
			preparedStatement.setInt(5, totalPrice);
			preparedStatement.setString(6, dateUtil.getDate());
			preparedStatement.execute();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
//			connection.close();
		}
	}

	//#Cartページでカートに入れた商品を表示（未ログイン状態でも可）
	public ArrayList<CartInfoDTO> getCartInfo(String tempId) throws SQLException {
		ArrayList<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();
		String sql = "SELECT ci.*, pi.product_name, pi.price, pi.image_file_path, pi.image_file_name FROM cart_info as ci left JOIN product_info as pi on ci.product_id = pi.product_id where temp_user_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tempId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductCount(resultSet.getInt("product_count"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setTotalPrice(resultSet.getInt("total_price"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				System.out.println("DAOimage"+dto.getImageFileName());
				cartInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartInfoDTO;
	}

//	public ArrayList<CartInfoDTO> createCartInfo(String userId) throws SQLException {
//		ArrayList<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();
//		String sql = "SELECT*FROM cart_info where user_id=?";
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, userId);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				CartInfoDTO dto = new CartInfoDTO();
////				dto.setUserId(resultSet.getString("user_id"));
//				dto.setProductId(resultSet.getInt("product_id"));
////				dto.setProductName(resultSet.getString("product_name"));
////				dto.setPrice(resultSet.getInt("price"));
//				dto.setProductCount(resultSet.getInt("product_count"));
//				dto.setTotalPrice(resultSet.getInt("total_price"));
//				dto.setRegistDate(resultSet.getString("regist_date"));
//				cartInfoDTO.add(dto);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return cartInfoDTO;
//	}

	//#Cartから#BuyDestinationへログインしたとき,UserIdを挿入する。
	public void insertUserId(String userId,String tempId) throws SQLException {

		String sql = "UPDATE cart_info SET user_id=? WHERE temp_user_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, tempId);
			preparedStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//カートの合計金額を計算する
	public int getCartTotalPrice(String tempId) throws SQLException {
		int sum = 0;
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "select SUM(total_price) as sum from cart_info where temp_user_id=? group by temp_user_id";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tempId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				sum = resultSet.getInt("sum");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sum;

	}
	//購入完了時カート情報を削除する
	public void deleteCart(String tempId) throws SQLException {

		String sql = "delete from cart_info WHERE temp_user_id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tempId);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteProduct(int id) throws SQLException {

		String sql = "delete from cart_info WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//ログイン後の最終画面にてuserID情報が入っているカートを表示させる。
	public ArrayList<CartInfoDTO> serchCartInfo(String userId, String tempId) throws SQLException {
		ArrayList<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();
		String sql = "SELECT ci.*, pi.product_name, pi.image_file_path, pi.image_file_name FROM cart_info as ci left JOIN product_info as pi on ci.product_id = pi.product_id where user_id=? AND temp_user_id=?";
System.out.println("DAOSss"+tempId);
System.out.println("DAOSdddddddddddddddss"+userId);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, tempId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setUserId(resultSet.getString("user_id"));
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
//				dto.setPrice(resultSet.getInt("price"));
				dto.setProductCount(resultSet.getInt("product_count"));
				dto.setTotalPrice(resultSet.getInt("total_price"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				cartInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartInfoDTO;
	}


	public Map<String, Object> getSession() {
		return this.session;
	}
}
