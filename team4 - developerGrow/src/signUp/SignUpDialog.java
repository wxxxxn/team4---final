package signUp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUpDialog extends JDialog  {

	private JDialog dialog;
	private JTextField idField;
	private JTextField nameField;
	private JTextField passwordChkField;
	private JTextField passwordField;
	private JLabel lblPwCheck;
	private String userId;
	private String userPw;
	private String nick;
	private SignUpEventImpl signUp = new SignUpEventImpl(this);
	private JLabel lblIdCheck;
	private JLabel lblNickCheck;

	public SignUpDialog(int x, int y) {
		dialog = new JDialog();
		dialog.getContentPane().setBackground(new Color (255, 0, 0, 0));
		ClassLoader classLoader = getClass().getClassLoader();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color (255, 0, 0, 0));
		panel.setBounds(357, 73, 410, 330);
		dialog.getContentPane().add(panel);
		panel.setLayout(null);
		
		// 중복확인버튼
		JButton btnIdCheck = new JButton("");
		URL URLduplicateImage = classLoader.getResource("images/btn_img/duplicateBtnImage.png");
		ImageIcon duplicateBtnIcon = new ImageIcon(URLduplicateImage);
		URL URLduplicatePushImage = classLoader.getResource("images/btn_img/duplicatePushBtnImage.png");
		ImageIcon duplicatePushBtnIcon = new ImageIcon(URLduplicatePushImage);
		btnIdCheck.setIcon(duplicateBtnIcon);
		btnIdCheck.setPressedIcon(duplicatePushBtnIcon);
		btnIdCheck.setBounds(313, 20, 97, 26);
		btnIdCheck.setBorderPainted(false);
		btnIdCheck.setOpaque(false);
		btnIdCheck.setBackground(new Color(255, 0, 0, 0));
		panel.add(btnIdCheck);
		
		JButton btnNickCheck = new JButton("");
		btnNickCheck.setIcon(duplicateBtnIcon);
		btnNickCheck.setPressedIcon(duplicatePushBtnIcon);
		btnNickCheck.setBorderPainted(false);
		btnNickCheck.setOpaque(false);
		btnNickCheck.setBackground(new Color(255, 0, 0, 0));
		btnNickCheck.setBounds(313, 102, 97, 26);
		panel.add(btnNickCheck);
		
		lblIdCheck = new JLabel("");
		lblIdCheck.setForeground(Color.RED);
		lblIdCheck.setBounds(216, 20, 57, 26);
		panel.add(lblIdCheck);
		
		idField = new JTextField();
		idField.setBounds(67, 20, 116, 28);
		panel.add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(67, 100, 116, 28);
		panel.add(nameField);
		
		passwordChkField = new JTextField();
		passwordChkField.setColumns(10);
		passwordChkField.setBounds(67, 183, 116, 28);
		panel.add(passwordChkField);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(67, 275, 116, 28);
		panel.add(passwordField);
		
		lblNickCheck = new JLabel("");
		lblNickCheck.setForeground(Color.RED);
		lblNickCheck.setBounds(216, 110, 57, 15);
		panel.add(lblNickCheck);
		
		lblPwCheck = new JLabel("");
		lblPwCheck.setForeground(Color.RED);
		lblPwCheck.setBounds(216, 281, 57, 15);
		panel.add(lblPwCheck);
		
//		JLabel lblNewLabel = new JLabel("회원가입");
//		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 24));
//		lblNewLabel.setBounds(197, 22, 130, 33);
//		dialog.getContentPane().add(lblNewLabel);
		
		btnIdCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				signUp.idCheck();
			}
		});
		btnNickCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				signUp.nickNameCheck();
			}
		});
		
		passwordField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				signUp.passWordCheck();
			}
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		passwordChkField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				signUp.passWordCheck();
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		JButton okbtn = new JButton("");
		URL URLOkImage = classLoader.getResource("images/btn_img/signofconfirmBtnImage.png");
		ImageIcon OkBtnIcon = new ImageIcon(URLOkImage);
		URL URLOkPushImage = classLoader.getResource("images/btn_img/signofconfirmPushBtnImage.png");
		ImageIcon OkPushBtnIcon = new ImageIcon(URLOkPushImage);
		okbtn.setIcon(OkBtnIcon);
		okbtn.setPressedIcon(OkPushBtnIcon);
		okbtn.setBorderPainted(false);
		okbtn.setOpaque(false);
		okbtn.setBackground(new Color(255, 0, 0, 0));
		
		okbtn.setBounds(560, 401, 97, 41);
		okbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				userId = idField.getText();
				userPw = passwordField.getText();
				nick = nameField.getText();
				
				if ((userPw != null) && (userId != null) && (nick != null)) {
					signUp.signUp(userId, userPw, nick);
					dialog.dispose();
				} else {
					new JOptionPane();
					JOptionPane.showMessageDialog(null, "가입 정보를 다시 확인해주세요. ");
				}
			}
		});
		dialog.getContentPane().add(okbtn);
		
		JButton CancelBtn = new JButton("");
		URL URLCancelImage = classLoader.getResource("images/btn_img/cancelBtnImage.png");
		ImageIcon CancelIcon = new ImageIcon(URLCancelImage);
		URL URLCancelPushImage = classLoader.getResource("images/btn_img/cancelPushBtnImage.png");
		ImageIcon CancelPushIcon = new ImageIcon(URLCancelPushImage);
		CancelBtn.setIcon(CancelIcon);
		CancelBtn.setPressedIcon(CancelPushIcon);
		CancelBtn.setBorderPainted(false);
		CancelBtn.setOpaque(false);
		CancelBtn.setBackground(new Color(255, 0, 0, 0));
		
		CancelBtn.setBounds(670, 401, 97, 41);
		CancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		
		dialog.getContentPane().add(CancelBtn);
		
		JLabel label = new JLabel("");
		URL URLSignBackImage = classLoader.getResource("images/back_img/SignBackground.png");
		ImageIcon SignBackIcon = new ImageIcon(URLSignBackImage);
		label.setIcon(SignBackIcon);
		label.setBounds(0, 0, 984, 463);
		dialog.getContentPane().add(label);
		
		dialog.setBounds(x + 8, y + 30, 984, 463);
		dialog.setUndecorated(true);
		dialog.setModal(true);
		dialog.getContentPane().setLayout(null);
	}
	
	public JTextField getIdField() {
		return idField;
	}

	public JLabel getLblIdCheck() {
		return lblIdCheck;
	}
	
	public JTextField getPasswordChkField() {
		return passwordChkField;
	}

	public JTextField getPasswordField() {
		return passwordField;
	}
	
	public JLabel getLblPwCheck() {
		return lblPwCheck;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPw() {
		return userPw;
	}
	
	public JLabel getLblNickCheck() {
		return lblNickCheck;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public String getNick() {
		return nick;
	}

	public void showGUI() {
		dialog.setVisible(true);
	}
}