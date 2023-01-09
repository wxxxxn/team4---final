package signUp;

public interface SignUpEvent {

	void signUp(String userId, String userPw, String nick);
	boolean verifyUserId(String userId);
	boolean verifyUserNickName(String userNickName);
	boolean verifyUserPw(String userPw);
	boolean useridDuplicationCheck(String userId);
	boolean userNickNameDuplicationCheck(String userNickName);
	void idCheck();
	void nickNameCheck();
	void passWordCheck();
}
