package database.controllDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.util.ConnectionProvider;

public class InsertDB {
	public int insertUser(String userId, String userPw, String nick) { // 회원가입
		String sql = "INSERT INTO team4.user (userId, userPw, userNickname) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, userId);
			stmt.setString(2, userPw);
			stmt.setString(3, nick);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertUserInfo(int userId) {
		String sql = "INSERT INTO team4.userinfo "
				+ "(date, time, level, exp, hp, health, stress, ciga, usedciga, gameover, userid) "
				+ "VALUES (0, 0, 1, 0, 100, 100, 0, 10, 0, 0, ?)";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int[] insertUserProject(int userId, int infoId) {
		String sql = "INSERT INTO team4.userProject (userId, infoId, projectId, complete, lastTime) "
				+ "VALUES(?, ?, ?, 0, 0)";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			for (int i = 0; i < 17; i++) {
				stmt.setInt(1, userId);
				stmt.setInt(2, infoId);
				stmt.setInt(3, i + 1);
				
				stmt.addBatch();
			}
			return stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int[] insertUserSkill(int userId, int infoId) {
		String sql = "INSERT INTO team4.userSkill (userId, infoId, skillId, skillLevel)"
				+ "VALUES(?, ?, ?, 0)";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			for (int i = 0; i < 5; i++) {
				stmt.setInt(1, userId);
				stmt.setInt(2, infoId);
				stmt.setInt(3, i + 1);
				
				stmt.addBatch();
			}
			return stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
