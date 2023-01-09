package login;

public interface LoginEvent {

	String checkUserId(String userId);
	boolean checkUserPw(String userPw, String inputPw);
	int idValue(String userId);
	
}
