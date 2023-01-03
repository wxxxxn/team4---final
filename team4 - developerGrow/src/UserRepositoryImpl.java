import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.ConnectionProvider;

public class UserRepositoryImpl implements UserRepository {
	@Override
	public int countById(String userId) {
		String sql = "SELECT COUNT(*) FROM user WHERE userId = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, userId);
			
			try (ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					return rs.getInt("COUNT(*)");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	@Override
	public int countByNickname(String nickname) {
		String sql = "SELECT COUNT(*) FROM user WHERE nickname = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nickname);
			
			try (ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					return rs.getInt("COUNT(*)");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int insertUser(String userId, String userPw, String nickname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int moveUser(int id, Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int id, Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}
}
