package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.CartDAO;
import com.portfolio.lefigaro.dao.DestinationDAO;
import com.portfolio.lefigaro.dao.LoginDAO;
import com.portfolio.lefigaro.dao.ReviewDAO;
import com.portfolio.lefigaro.dto.DestinationInfoDTO;
import com.portfolio.lefigaro.dto.LoginInfoDTO;
import com.portfolio.lefigaro.dto.ReviewInfoDTO;
public class LoginAction extends ActionSupport implements SessionAware {

	private int productId;
	public Map<String, Object> session;
	//ログイン判定
	private String userId;
	private String userPass;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
	//ログイン先のページ判定
	private String type;
//	購入session.put用
	private DestinationDAO destinationDAO  = new DestinationDAO();
	private ArrayList<DestinationInfoDTO> destinationList = new ArrayList<DestinationInfoDTO>();
	private String tempId;
	//レビュー判定
	private ReviewDAO reviewCompleteDAO = new ReviewDAO();
	private ArrayList<ReviewInfoDTO> reviewList = new ArrayList<ReviewInfoDTO>();
	private String message;
	public String execute() throws SQLException{

		String result = ERROR;
		loginInfoDTO = loginDAO.getLoginInfo(userId, userPass);
		session.put("loginUser", loginInfoDTO);

		if (((LoginInfoDTO) session.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;

			session.put("userId", loginInfoDTO.getUserId());
			session.put("userPass", loginInfoDTO.getUserPass());
			System.out.println("fgl"+loginInfoDTO.getLoginFlg());
//			if (loginDTO.getAdminFlg()) {
//				result = "admin";
//				return result;
//			}
//			String userId=loginInfoDTO.getUserId();

//			String userName = loginInfoDTO.getUserName();

			System.out.println("loginUserId"+userId);
			System.out.println("loginUserPass"+userPass);
			if("buy".equals(type)) {
				result="buy";
				CartDAO cartDAO = new CartDAO();
//				String tempId = session.get("tempId").toString();
				cartDAO.insertUserId(userId, tempId);
				destinationList=destinationDAO.getUserDestinaton(userId);
				session.put("destinationList", destinationList);
				session.put("tempId",tempId);
				return result;
			}else if("review".equals(type)) {
				result="review";
				System.out.println("type"+type);
				session.put("userId",userId);
				session.put("productId", session.get("productId"));
				setMessage("すでにレビュー投稿されています。");
				int productId = Integer.parseInt(session.get("productId").toString());
				loginInfoDTO=reviewCompleteDAO.doublecheck(productId, userId);
				if (loginInfoDTO.getReviewFlg()) {
				    result = "reviewError";
				    reviewList=reviewCompleteDAO.serchReview(productId);
				}
				return result;
			}

		}
		return result;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ReviewInfoDTO>getReviewList(){
		return this.reviewList;
	}
	public void serCartList(ArrayList<ReviewInfoDTO>reviewList){
		this.reviewList=reviewList;
	}

}
