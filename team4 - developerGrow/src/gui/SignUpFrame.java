package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUpFrame {

	private JDialog dialog;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public SignUpFrame() {
		dialog = new JDialog();
		ClassLoader classLoader = getClass().getClassLoader();
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 103, 389, 267);
		dialog.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(0, 10, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("닉네임");
		lblNewLabel_1_1.setBounds(0, 66, 57, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1_1.setBounds(0, 123, 57, 15);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("비밀번호 확인");
		lblNewLabel_1_1_1_1.setBounds(0, 176, 85, 15);
		panel.add(lblNewLabel_1_1_1_1);
		
		// 중복확인버튼
		JButton btnNewButton_1 = new JButton("");
		URL URLduplicateImage = classLoader.getResource("btn_image/duplicateBtnImage.png");
		ImageIcon duplicateBtnIcon = new ImageIcon(URLduplicateImage);
		URL URLduplicatePushImage = classLoader.getResource("btn_image/duplicatePushBtnImage.png");
		ImageIcon duplicatePushBtnIcon = new ImageIcon(URLduplicatePushImage);
		btnNewButton_1.setIcon(duplicateBtnIcon);
		btnNewButton_1.setPressedIcon(duplicatePushBtnIcon);
		btnNewButton_1.setBounds(280, 58, 97, 26);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBackground(new Color(255, 0, 0, 0));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(duplicateBtnIcon);
		btnNewButton_2.setPressedIcon(duplicatePushBtnIcon);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBackground(new Color(255, 0, 0, 0));
		btnNewButton_2.setBounds(280, 2, 97, 26);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("중복");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(228, 10, 57, 15);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(88, 4, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(88, 60, 116, 21);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(88, 179, 116, 21);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(88, 123, 116, 21);
		panel.add(textField_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("중복");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setBounds(228, 66, 57, 15);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("일치");
		lblNewLabel_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1.setBounds(228, 182, 57, 15);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel.setBounds(197, 22, 130, 33);
		dialog.getContentPane().add(lblNewLabel);
		
		JButton okbtn = new JButton("");
		URL URLOkImage = classLoader.getResource("btn_image/signofconfirmBtnImage.png");
		ImageIcon OkBtnIcon = new ImageIcon(URLOkImage);
		URL URLOkPushImage = classLoader.getResource("btn_image/signofconfirmPushBtnImage.png");
		ImageIcon OkPushBtnIcon = new ImageIcon(URLOkPushImage);
		okbtn.setIcon(OkBtnIcon);
		okbtn.setPressedIcon(OkPushBtnIcon);
		okbtn.setBorderPainted(false);
		okbtn.setOpaque(false);
		okbtn.setBackground(new Color(255, 0, 0, 0));
		
		okbtn.setBounds(327, 396, 97, 41);
		okbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		dialog.getContentPane().add(okbtn);
		dialog.setBounds(100, 100, 500, 500);
		dialog.getContentPane().setLayout(null);
	}

	public void showGUI() {
		dialog.setVisible(true);
	}
}