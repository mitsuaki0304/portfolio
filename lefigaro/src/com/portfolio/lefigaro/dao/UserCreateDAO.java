package com.portfolio.lefigaro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.portfolio.lefigaro.util.DBConnector;
import com.portfolio.lefigaro.util.DateUtil;

public class UserCreateDAO {


private DBConnector dbConnector = new DBConnector();
private Connection connection = dbConnector.getConnection();
private DateUtil dateUtil = new DateUtil();

private String sql = "INSERT INTO login_user_info(user_id, user_pass, email, family_name, first_name, family_name_kana, first_name_kana,regist_date) VALUES(?,?,?,?,?,?,?,?)";

public void createUser(String userId, String userPass, String email,
		String familyName, String firstName, String familyNameKana, String firstNameKana) throws SQLException{
	try {
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setString(1, userId);
		preparedStatement.setString(2, userPass);
		preparedStatement.setString(3, email);
		preparedStatement.setString(4, familyName);
		preparedStatement.setString(5, firstName);
		preparedStatement.setString(6, familyNameKana);
		preparedStatement.setString(7, firstNameKana);
		preparedStatement.setString(8, dateUtil.getDate());

		preparedStatement.execute();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		connection.close();
	}
}
}
