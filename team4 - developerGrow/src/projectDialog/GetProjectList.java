package projectDialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.ConnectionProvider;

public class GetProjectList {

	public List<Project> getProject() {
		List<Project> list = new ArrayList<>();
		String sql = "SELECT * FROM project";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {		
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					list.add(new Project(rs.getInt("id")
							, rs.getString("projectName")
							, rs.getInt("rewardExp")
							, rs.getInt("time")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Boolean> getCompleteList(int userId, int infoId) {
		List<Boolean> list = new ArrayList<>();
		String sql = "SELECT * FROM userproject WHERE userId = ? AND infoId = ?";
		String complete = null;
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			stmt.setInt(2, infoId);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					complete = rs.getString("complete");
				}
			}
			for (int i = 0; i < complete.length(); i++) {
				if (complete.charAt(i) == '1') {
					list.add(true);
				} else {
					list.add(false);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}		
	
//	public int[] updateProject(List<Project> list, int userId, int infoId) {
//		String sql = "UPDATE project SET id = ?, complete = ? WHERE userId = ? AND infoId = ?";
//		try (Connection conn = ConnectionProvider.makeConnection();
//				PreparedStatement stmt = conn.prepareStatement(sql)) {
//			conn.setAutoCommit(false);
//			for (int i = 0; i < list.size(); i++) {
//				stmt.setInt(1, list.get(i).getId());
//				stmt.setBoolean(2, list.get(i).isComplete());
//				stmt.setInt(3, userId);
//				stmt.setInt(4, infoId);
//				
//				stmt.addBatch();
//			}
//			int[] result = stmt.executeBatch();
//			conn.commit();
//			return result;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}
