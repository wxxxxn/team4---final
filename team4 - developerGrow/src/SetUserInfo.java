import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.ConnectionProvider;

public class SetUserInfo {
	public List<UserInfo> getUserInfo(String userId) {
		String sql = "SELECT * FROM team4.userinfo WHERE userid = ?";
		List<UserInfo> userInfoes = new ArrayList<>();
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, userId);
			
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
	
	public UserInfo searchNowGame(List<UserInfo> userInfoes) {
		for (int i = 0; i < userInfoes.size(); i++) {
			if (!userInfoes.get(i).isGameover()) {
				return userInfoes.get(i);
			}
		}
		return null;
	}
}
