package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import database.util.ConnectionProvider;

public class LoginEventImpl implements LoginEvent {
	
	@Override
	public String checkUserId(String userId) { // 아디 입력 받음
		String sql = "SELECT userPw FROM team4.user where userId = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, userId);
			try (ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					return rs.getString("userPw"); // 아디 있으면 비번 반환
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null; // 아디 없으면 null 반환
	}
	
	@Override
	public boolean checkUserPw(String userPw, String inputPw) {
		if (userPw.equals(inputPw)) {
			return true; // 비번과 입력 비번이 같으면 true 반환
		} else {
			return false; // 다르면 false 반환
		}
	}
	
	@Override
	public int idValue(String userId) {
		String sql = "SELECT id FROM team4.user where userId = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, userId);
			try (ResultSet rs = stmt.executeQuery()){
				if (rs.next()) {
					return rs.getInt("id");
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}