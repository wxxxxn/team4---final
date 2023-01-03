public interface UserService {
	int INPUT_NOT_VALID = -1;
	int ID_DUPLICATED = -2;
	int NICKNAME_DUPLICATED = -2;
	
	int userIn(String userId, String userPw, String nickname);
	int userOut(int userId);
}