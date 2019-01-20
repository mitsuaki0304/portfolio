package com.portfolio.lefigaro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.portfolio.lefigaro.dto.BuyHistoryInfoDTO;
import com.portfolio.lefigaro.util.DBConnector;
import com.portfolio.lefigaro.util.DateUtil;
public class BuyHistoryDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	public ArrayList<BuyHistoryInfoDTO> getBuyHistoryInfo(String user_id)throws SQLException{
		ArrayList<BuyHistoryInfoDTO> buyHistoryInfoDTO = new ArrayList<BuyHistoryInfoDTO>();
		String sql ="SELECT ubh.*, pi.product_name, pi.image_file_path, pi.image_file_name, ud.address_num, ud.region, ud.city, ud.other FROM user_buy_history as ubh left JOIN product_info as pi on ubh.product_id = pi.product_id left JOIN user_destination as ud on ubh.destination_id = ud.id where ubh.user_id=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				BuyHistoryInfoDTO dto = new BuyHistoryInfoDTO();
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductCount(resultSet.getInt("product_count"));
				dto.setTotalPrice(resultSet.getInt("total_price"));
				dto.setAddressNum(resultSet.getString("address_num"));
				dto.setRegion(resultSet.getString("region"));
				dto.setCity(resultSet.getString("city"));
				dto.setOther(resultSet.getString("other"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setInsertDate(resultSet.getString("regist_date"));
				buyHistoryInfoDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return buyHistoryInfoDTO;
	}
	public int buyHistoryDelete(String user_id)throws SQLException{
		String sql = "DELETE FROM user_buy_history WHERE user_id = ?";

		PreparedStatement preparedStatement;
		int result = 0;
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			result = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}

	public void buyProductInfo(String userId, int productId ,int productCount ,int totalPrice, int id)throws SQLException {
		 String sql="INSERT INTO user_buy_history(user_id, product_id, product_count, total_price, destination_id, regist_date) VALUES(?, ?, ?, ?, ?, ?)";
		 System.out.println("DAO通過テスト"+userId);
			try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,userId);
			preparedStatement.setInt(2,productId);
			preparedStatement.setInt(3,productCount);
			preparedStatement.setInt(4,totalPrice);
			preparedStatement.setInt (5,id);//お届け先Id//
			preparedStatement.setString(6,dateUtil.getDate());
			preparedStatement.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
//			connection.close();
		}
	}
}
