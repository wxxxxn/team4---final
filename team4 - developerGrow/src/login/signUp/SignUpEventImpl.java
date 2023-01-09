package login.signUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;

import database.util.ConnectionProvider;

public class SignUpEventImpl {

	private SignUpDialog signUpDialog;

	public SignUpEventImpl(SignUpDialog signUpDialog) {
		this.signUpDialog = signUpDialog;
	}
	
	public void signUp(String userId, String userPw, String nick) { // 회원가입
		String sql = "INSERT INTO user (userId, userPw, userNickname) values (?, ?, ?)";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, userId);
			stmt.setString(2, userPw);
			stmt.setString(3, nick);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean verifyUserId(String userId) {
		Pattern p = Pattern.compile("[a-zA-Z0-9]{1,30}");
		Matcher m = p.matcher(userId);

		if (m.matches()) {
			return true; // 아이디 사용 가능 양식이면 true
		}
		return false; // 아니면 false
	}

	public boolean verifyUserNickName(String userNickName) {
		Pattern p = Pattern.compile("[a-zA-Z0-9]{1,30}");
		Matcher m = p.matcher(userNickName);

		if (m.matches()) {
			return true; // 닉네임 사용 가능 양식이면 true
		}
		return false; // 아니면 false
	}

	public boolean verifyUserPw(String userPw) {
		Pattern p = Pattern.compile("[a-zA-Z0-9]{1,30}");
		Matcher m = p.matcher(userPw);

		if (m.matches()) {
			return true; // 비밀번호 사용 가능 양식이면 true
		}
		return false; // 아니면 false
	}

	public boolean useridDuplicationCheck(String userId) {
		String sql = "SELECT * FROM team4.user WHERE userId = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, userId);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return false; // 아이디 중복이면 false 반환
				} else {
					return true; // 아이디 중복 아니면 true 반환
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean userNickNameDuplicationCheck(String userNickName) {
		String sql = "SELECT * FROM team4.user WHERE userNickname = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, userNickName);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return false; // 닉네임 중복이면 false 반환
				} else {
					return true; // 닉네임 중복 아니면 true 반환
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void idCheck() {
		
		JLabel lblIdCheck = signUpDialog.getLblIdCheck();
		String testId = signUpDialog.getIdField().getText();
		String userId = signUpDialog.getUserId();

		if (verifyUserId(testId) && useridDuplicationCheck(testId)) {
			lblIdCheck.setText("허용");
			userId = testId;
		} else if (!verifyUserId(testId)) {
			lblIdCheck.setText("불가");
			userId = null;
		} else {
			lblIdCheck.setText("중복");
			userId = null;
		}
	}

	public void nickNameCheck() {
		
		JLabel lblNickCheck = signUpDialog.getLblNickCheck();
		String nick = signUpDialog.getNick();
		String testNick = signUpDialog.getNameField().getText();
		
		if (verifyUserNickName(testNick) && userNickNameDuplicationCheck(testNick)) {
			lblNickCheck.setText("허용");
			nick = testNick;
		} else if (!verifyUserNickName(testNick)) {
			lblNickCheck.setText("불가");
			nick = null;
		} else {
			lblNickCheck.setText("중복");
			nick = null;
		}
	}
	
	public void passWordCheck() {

		JTextField passwordField = signUpDialog.getPasswordField();
		JTextField passwordChkField = signUpDialog.getPasswordChkField();
		JLabel lblPwCheck = signUpDialog.getLblPwCheck();
		String userPw = signUpDialog.getUserPw();
		String testPw = passwordField.getText();
		String testPwCheck = passwordChkField.getText();

		if (verifyUserPw(testPw) && testPw.equals(testPwCheck)) {
			lblPwCheck.setText("일치");
			userPw = testPw;
		} else if (!verifyUserPw(testPw)) {
			lblPwCheck.setText("비밀번호 형식이 틀립니다");
			userPw = null;
		} else if (!(testPw.equals(testPwCheck))) {
			lblPwCheck.setText("불일치");
			userPw = null;
		}
	}
}