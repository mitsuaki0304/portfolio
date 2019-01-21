package com.portfolio.lefigaro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.portfolio.lefigaro.dto.DestinationInfoDTO;
import com.portfolio.lefigaro.util.DBConnector;

public class DestinationDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();


	public void createDestination(String userId, String familyName, String firstName, String familyNameKana, String firstNameKana, String telNum, String addressNum, String region ,String city,
			String other)throws SQLException{
		String sql = "INSERT INTO user_destination (user_id, family_name, first_name, family_name_kana, first_name_kana, tel_num, address_num, region, city, other) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try{
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, familyName);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, familyNameKana);
			preparedStatement.setString(5, firstNameKana);
			preparedStatement.setString(6, telNum);
			preparedStatement.setString(7, addressNum);
			preparedStatement.setString(8, region);
			preparedStatement.setString(9, city);
			preparedStatement.setString(10,other);
			preparedStatement.execute();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

	public ArrayList<DestinationInfoDTO> getUserDestinaton(String userId) throws SQLException {

		ArrayList<DestinationInfoDTO> DestinationInfoDTO = new ArrayList<DestinationInfoDTO>();
		String sql = "SELECT*FROM user_destination where user_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				DestinationInfoDTO dto = new DestinationInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setUserId(resultSet.getString("user_id"));
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setFirstName(resultSet.getString("first_name"));
				dto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setFirstNameKana(resultSet.getString("first_name_kana"));
				dto.setTelNum(resultSet.getString("tel_num"));
				dto.setAddressNum(resultSet.getString("address_num"));
				dto.setRegion(resultSet.getString("region"));
				dto.setCity(resultSet.getString("city"));
				dto.setOther(resultSet.getString("other"));
				DestinationInfoDTO.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return DestinationInfoDTO;
	}
	public ArrayList<DestinationInfoDTO> serchDestinaton(int id) throws SQLException {

		ArrayList<DestinationInfoDTO> DestinationInfoDTO = new ArrayList<DestinationInfoDTO>();
		String sql = "SELECT*FROM user_destination where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				DestinationInfoDTO dto = new DestinationInfoDTO();
				dto.setUserId(resultSet.getString("user_id"));
				dto.setTelNum(resultSet.getString("tel_num"));
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setFirstName(resultSet.getString("first_name"));
				dto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setFirstNameKana(resultSet.getString("first_name_kana"));
				dto.setAddressNum(resultSet.getString("address_num"));
				dto.setRegion(resultSet.getString("region"));
				dto.setCity(resultSet.getString("city"));
				dto.setOther(resultSet.getString("other"));
				DestinationInfoDTO.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return DestinationInfoDTO;
}
	public  ArrayList<DestinationInfoDTO> getNewDestinaton(String userId) throws SQLException {

		ArrayList<DestinationInfoDTO> DestinationInfoDTO = new ArrayList<DestinationInfoDTO>();
		String sql = "SELECT tel_num, family_name, first_name, family_name_kana, first_name_kana, address_num, region, city, other FROM user_destination WHERE user_id=? AND id=(SELECT max(id) FROM user_destination WHERE user_id=?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				DestinationInfoDTO dto = new DestinationInfoDTO();
				dto.setTelNum(resultSet.getString("tel_num"));
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setFirstName(resultSet.getString("first_name"));
				dto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setFirstNameKana(resultSet.getString("first_name_kana"));
				dto.setAddressNum(resultSet.getString("address_num"));
				dto.setRegion(resultSet.getString("region"));
				dto.setCity(resultSet.getString("city"));
				dto.setOther(resultSet.getString("other"));
				DestinationInfoDTO.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return DestinationInfoDTO;
	}
}
