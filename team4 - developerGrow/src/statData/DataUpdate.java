package statData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.util.ConnectionProvider;

//public MainFrame(int id){
//DataUpdate dataUpdate = new DataUpdate();
//}
//dataUpdate.statUpdate(스탯, 값, userInfo): 스탯의 값에 입력값을 증감 (+5 -5 이런 식)
//dataUpdate.statUpdateAbs(스탯, 값, userInfo): 스탯의 값을 입력값으로 변경 

public class DataUpdate {
	int num;
	
	public void statUpdate(String stat, int value, UserInfo userInfo) {
		int userId = userInfo.getUserId();
		int infoId = userInfo.getInfoId();
		num = -1;
		String sql = sqlValue(stat, userInfo);
		
		if (num != -1) {
			num += value;
			if (num < 0) {
				num = 0;
			}
			try (Connection conn = ConnectionProvider.makeConnection();
					PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, num);
				stmt.setInt(2, userId);
				stmt.setInt(3, infoId);
				stmt.executeUpdate();
				statApply(stat, userInfo, num);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void statUpdateAbs(String stat, int num, UserInfo userInfo) {
		int userId = userInfo.getUserId();
		int infoId = userInfo.getInfoId();
		
		String sql = sqlValue(stat, userInfo);
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, num);
			stmt.setInt(2, userId);
			stmt.setInt(3, infoId);
			stmt.executeUpdate();
			statApply(stat, userInfo, num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String sqlValue(String stat, UserInfo userInfo) {
		String sql = null;
		if (stat.equalsIgnoreCase("date")) {
			num = userInfo.getDate();
			sql = "UPDATE team4.userInfo SET date = ? WHERE userId = ? AND infoId = ?;";
		} else if (stat.equalsIgnoreCase("level")) {
			num = userInfo.getLevel();
			sql = "UPDATE team4.userInfo SET level = ? WHERE userId = ? AND infoId = ?;";
		} else if (stat.equalsIgnoreCase("exp")) {
			num = userInfo.getExp();
			sql = "UPDATE team4.userInfo SET exp = ? WHERE userId = ? AND infoId = ?;";
		} else if (stat.equalsIgnoreCase("hp")) {
			num = userInfo.getHp();
			sql = "UPDATE team4.userInfo SET hp = ? WHERE userId = ? AND infoId = ?;";
		} else if (stat.equalsIgnoreCase("health")) {
			num = userInfo.getHealth();
			sql = "UPDATE team4.userInfo SET health = ? WHERE userId = ? AND infoId = ?;";
		} else if (stat.equalsIgnoreCase("stress")) {
			num = userInfo.getStress();
			sql = "UPDATE team4.userInfo SET stress = ? WHERE userId = ? AND infoId = ?;";
		} else if (stat.equalsIgnoreCase("ciga")) {
			num = userInfo.getCiga();
			sql = "UPDATE team4.userInfo SET ciga = ? WHERE userId = ? AND infoId = ?;";
		} else if (stat.equalsIgnoreCase("usedciga")) {
			num = userInfo.getUsedCiga();
			sql = "UPDATE team4.userInfo SET usedciga = ? WHERE userId = ? AND infoId = ?;";
		}
		return sql;
	}
	public void statApply (String stat, UserInfo userInfo, int num) {
		if (stat.equalsIgnoreCase("date")) {
			userInfo.setDate(num);
		} else if (stat.equalsIgnoreCase("level")) {
			userInfo.setLevel(num);
		} else if (stat.equalsIgnoreCase("exp")) {
			userInfo.setExp(num);
		} else if (stat.equalsIgnoreCase("hp")) {
			userInfo.setHp(num);
		} else if (stat.equalsIgnoreCase("health")) {
			userInfo.setHealth(num);
		} else if (stat.equalsIgnoreCase("stress")) {
			userInfo.setStress(num);
		} else if (stat.equalsIgnoreCase("ciga")) {
			userInfo.setCiga(num);
		} else if (stat.equalsIgnoreCase("usedciga")) {
			userInfo.setUsedCiga(num);
		}
	}
	
}
