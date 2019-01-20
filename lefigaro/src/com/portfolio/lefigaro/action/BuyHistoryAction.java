package com.portfolio.lefigaro.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.portfolio.lefigaro.dao.BuyHistoryDAO;
import com.portfolio.lefigaro.dto.BuyHistoryInfoDTO;

public class BuyHistoryAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private String deleteFlg;
	private String message;
	private String userId;
	private ArrayList<BuyHistoryInfoDTO> buyHistoryList = new ArrayList<BuyHistoryInfoDTO>();
	private BuyHistoryDAO buyHistoryDAO = new BuyHistoryDAO();

	public String execute() throws SQLException {

		if (deleteFlg == null) {
			buyHistoryList = buyHistoryDAO.getBuyHistoryInfo(userId);
			session.put("buyHistoryList", buyHistoryList);
		} else if (deleteFlg.equals("1")) {
			delete();
		}
		String result = SUCCESS;
		return result;

	}

	public void delete() throws SQLException {

		String userId = session.get("userId").toString();

		int res = buyHistoryDAO.buyHistoryDelete(userId);

		if (res > 0) {
			buyHistoryList = null;
			setMessage("商品情報を削除しました。");
		} else if (res == 0) {
			setMessage("商品情報を削除できませんでした。");
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public ArrayList<BuyHistoryInfoDTO> getBuyHistoryList() {
		return this.buyHistoryList;
	}
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
