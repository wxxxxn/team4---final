package database.controllDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import database.dblist.UserInfo;
import database.dblist.UserProject;
import database.dblist.UserSkill;
import database.util.ConnectionProvider;

public class UpdateDB {
	public int[] updateUserInfo(List<UserInfo> list, int userId, int infoId) {
		String sql = "UPDATE userInfo SET date =?, time = ?, level = ?, exp = ?"
				+ ", hp = ?, health = ?, stress = ?, ciga = ?, usedCiga = ?, gameover = ? "
				+ "WHERE userId = ? AND infoId = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			for (UserInfo elem : list) {
				stmt.setInt(1, elem.getDate());
				stmt.setInt(2, elem.getTime());
				stmt.setInt(3, elem.getLevel());
				stmt.setInt(4, elem.getExp());
				stmt.setInt(5, elem.getHp());
				stmt.setInt(6, elem.getHealth());
				stmt.setInt(7, elem.getStress());
				stmt.setInt(8, elem.getCiga());
				stmt.setInt(9, elem.getUsedCiga());
				stmt.setBoolean(10, elem.isGameover());
				stmt.setInt(11, userId);
				stmt.setInt(12, infoId);
				
				stmt.addBatch();
			}
			return stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int[] updateUserProject(List<UserProject> list, int userId, int infoId) {
		String sql = "UPDATE userProject SET complete = ?, lastHour = ? lastMin = ? WHERE userId = ? AND infoId = ? AND projectId = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			for (UserProject elem : list) {
				stmt.setBoolean(1, elem.isComplete());
				stmt.setInt(2, elem.getLastHour());
				stmt.setInt(3, elem.getLastMin());
				stmt.setInt(4, userId);
				stmt.setInt(5, infoId);
				stmt.setInt(6, elem.getProjectId());
				
				stmt.addBatch();
			}
			return stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int[] updateUserSkill(List<UserSkill> list, int userId, int infoId) {
		String sql = "UPDATE userSkill SET skillLevel = ? WHERE userId = ? AND infoId = ? AND skillId = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			for (UserSkill elem : list) {
				stmt.setInt(1, elem.getSkillLevel());
				stmt.setInt(2, userId);
				stmt.setInt(3, infoId);
				stmt.setInt(4, elem.getSkillId());
				
				stmt.addBatch();
			}
			return stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
}
