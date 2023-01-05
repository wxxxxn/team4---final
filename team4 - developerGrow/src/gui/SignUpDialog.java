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

public class SignUpDialog extends JDialog  {

	private JDialog dialog;
	private JTextField idField;
	private JTextField nameField;
	private JTextField passwordChkField;
	private JTextField passwordField;

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
		JButton btnNewButton_1 = new JButton("");
		URL URLduplicateImage = classLoader.getResource("btn_image/duplicateBtnImage.png");
		ImageIcon duplicateBtnIcon = new ImageIcon(URLduplicateImage);
		URL URLduplicatePushImage = classLoader.getResource("btn_image/duplicatePushBtnImage.png");
		ImageIcon duplicatePushBtnIcon = new ImageIcon(URLduplicatePushImage);
		btnNewButton_1.setIcon(duplicateBtnIcon);
		btnNewButton_1.setPressedIcon(duplicatePushBtnIcon);
		btnNewButton_1.setBounds(313, 102, 97, 26);
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
		btnNewButton_2.setBounds(313, 20, 97, 26);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("중복");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(216, 20, 57, 26);
		panel.add(lblNewLabel_2);
		
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
		passwordChkField.setBounds(67, 275, 116, 28);
		panel.add(passwordChkField);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(67, 183, 116, 28);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2_1 = new JLabel("중복");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setBounds(216, 110, 57, 15);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("일치");
		lblNewLabel_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1.setBounds(216, 281, 57, 15);
		panel.add(lblNewLabel_2_1_1);
		
//		JLabel lblNewLabel = new JLabel("회원가입");
//		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 24));
//		lblNewLabel.setBounds(197, 22, 130, 33);
//		dialog.getContentPane().add(lblNewLabel);
		
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
		
		okbtn.setBounds(560, 401, 97, 41);
		okbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		dialog.getContentPane().add(okbtn);
		
		JButton CancelBtn = new JButton("");
		URL URLCancelImage = classLoader.getResource("btn_image/cancelBtnImage.png");
		ImageIcon CancelIcon = new ImageIcon(URLCancelImage);
		URL URLCancelPushImage = classLoader.getResource("btn_image/cancelPushBtnImage.png");
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
		URL URLSignBackImage = classLoader.getResource("backimg/SignBackground.png");
		ImageIcon SignBackIcon = new ImageIcon(URLSignBackImage);
		label.setIcon(SignBackIcon);
		label.setBounds(0, 0, 984, 463);
		dialog.getContentPane().add(label);
		
		dialog.setBounds(x + 8, y + 30, 984, 463);
		dialog.setUndecorated(true);
		dialog.setModal(true);
		dialog.getContentPane().setLayout(null);
	}

	public void showGUI() {
		dialog.setVisible(true);
	}
}