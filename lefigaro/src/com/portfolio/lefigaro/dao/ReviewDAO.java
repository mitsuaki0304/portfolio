package com.portfolio.lefigaro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.portfolio.lefigaro.dto.LoginInfoDTO;
import com.portfolio.lefigaro.dto.ReviewInfoDTO;
import com.portfolio.lefigaro.util.DBConnector;

public class ReviewDAO implements SessionAware {
	public Map<String, Object> session;
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
//	private  ProductInfoDTO productInfoDTO = new ProductInfoDTO();

	public void userReview(String userId, int productId, String title, int reviewStar, String comment) throws SQLException {
		String sql = "INSERT INTO user_review(user_id, product_id, title, review_star, comment) VALUES(?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setString(3, title);
			preparedStatement.setInt(4, reviewStar);
			preparedStatement.setString(5, comment);
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	//表示機能//
	public ArrayList<ReviewInfoDTO> serchReview(int productId) throws SQLException {
		ArrayList<ReviewInfoDTO> reviewInfoDTO = new ArrayList<ReviewInfoDTO>();
		String sql = "SELECT ur.title, ur.review_star, ur.comment, lui.family_name, lui.first_name From user_review ur LEFT JOIN login_user_info lui ON ur.user_id=lui.user_id where product_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ReviewInfoDTO dto = new ReviewInfoDTO();
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setFirstName(resultSet.getString("first_name"));
				dto.setTitle(resultSet.getString("title"));
				dto.setReviewStar(resultSet.getInt("review_star"));
				dto.setComment(resultSet.getString("comment"));
				reviewInfoDTO.add(dto);
//				System.out.println("reviewtest"+dto.getFamilyName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewInfoDTO;

	}

	// 二重書き込み判定
	public LoginInfoDTO doublecheck(int productId, String userId) throws SQLException {

		String sql = "select*from user_review where product_id=? AND user_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			preparedStatement.setString(2, userId);
			System.out.println("ReviewDAO通過テスト");
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				ReviewInfoDTO dto = new ReviewInfoDTO();
				dto.setUserId(resultSet.getString("user_id"));
			}
			System.out.println("ReviewDAOuserId" + resultSet.getString("user_id"));
			if (!(resultSet.getString("user_id").equals(null))) {
				System.out.println("IF通過テスト");
				loginInfoDTO.setReviewFlg(true);
				System.out.print(loginInfoDTO.getReviewFlg());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return loginInfoDTO;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public LoginInfoDTO getLoginDTO() {
		return loginInfoDTO;
	}

}
