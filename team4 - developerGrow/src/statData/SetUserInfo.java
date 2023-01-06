package statData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.ConnectionProvider;

// public MainFrame(int id){
// UserInfo userInfo = SetUserInfo.GameUserInfo(id);
// }

public class SetUserInfo {
	public static List<UserInfo> getUserInfo(int userId) {
		String sql = "SELECT * FROM team4.userinfo WHERE userid = ?";
		List<UserInfo> userInfoes = new ArrayList<>();
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int infoId = rs.getInt("infoId");
					int date = rs.getInt("date");
					int level = rs.getInt("level");
					int exp = rs.getInt("exp");
					int hp = rs.getInt("hp");
					int health = rs.getInt("health");
					int stress = rs.getInt("stress");
					int ciga = rs.getInt("ciga");
					int usedCiga = rs.getInt("usedCiga");
					boolean gameover = rs.getBoolean("gameover");
					int userId1 = rs.getInt("userId");
					userInfoes.add(new UserInfo(infoId, date, level, exp, hp, health, stress, ciga, usedCiga, gameover, userId1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoes;
	}
	
	public static UserInfo searchNowGame(List<UserInfo> userInfoes) {
		for (int i = 0; i < userInfoes.size(); i++) {
			if (! userInfoes.get(i).isGameover()) {
				return userInfoes.get(i);
			}
		}
		return null;
	}
	
	public static UserInfo GameUserInfo(int userId) {
		int infoId = getUserInfo(userId).size() + 1; // 세이브 게임은 쓸 일x. 새 게임인 경우 마지막 회차 + 1을 infoId 값으로 가짐
		UserInfo userInfo = searchNowGame(getUserInfo(userId)); 
		if (userInfo == null) { // 새 게임이면 if null 세이브 게임이면 else 
			String sql = "INSERT INTO userinfo (userId, infoId) VALUES (?, ?);";
			try (Connection conn = ConnectionProvider.makeConnection();
					PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, userId);
				stmt.setInt(2, infoId);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} // userInfo테이블에 새 회차 생성
			UserInfo userInfo_ = searchNowGame(getUserInfo(userId)); // 새 회차 값 부여
			return userInfo_;
		} else {
			return userInfo; // 세이브 게임 값 부여
		}
	}
	
}
