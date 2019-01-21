package com.portfolio.lefigaro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.portfolio.lefigaro.dto.LoginInfoDTO;
import com.portfolio.lefigaro.util.DBConnector;
public class LoginDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginInfoDTO loginInfoDTO = new LoginInfoDTO();

	public LoginInfoDTO getLoginInfo(String userId, String userPass){
	String sql = "SELECT*FROM login_user_info where user_id=? AND user_pass=?";

	try
	{
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, userId);
		preparedStatement.setString(2, userPass);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			loginInfoDTO.setUserId(resultSet.getString("user_id"));
			loginInfoDTO.setUserPass(resultSet.getString("user_pass"));


			if (!(resultSet.getString("user_id").equals(null))) {
				loginInfoDTO.setLoginFlg(true);
				System.out.println("fgl"+loginInfoDTO.getLoginFlg());
			}


		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return loginInfoDTO;
}

	public LoginInfoDTO getLoginUserInfo(String userId, String userPass) {
		String sql = "SELECT*FROM login_user_info where user_id=? AND user_pass=?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPass);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				loginInfoDTO.setFamilyName(resultSet.getString("family_name"));
				loginInfoDTO.setFirstName(resultSet.getString("first_name"));
				loginInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				loginInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
				loginInfoDTO.setEmail(resultSet.getString("email"));
				loginInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return loginInfoDTO;
	}


	public LoginInfoDTO getLoginInfoDTO(){
		return loginInfoDTO;
	}

}
