import java.sql.Connection;

public interface UserRepository {
	int countById(String userId);
	int countByNickname(String nickname);
	
	int insertUser(String userId, String userPw, String nickname);
	int moveUser(int userId, Connection conn);
	int deleteUser(int userId, Connection conn);
}
