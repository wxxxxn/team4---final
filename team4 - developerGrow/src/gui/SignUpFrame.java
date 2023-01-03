package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JButton btnNewButton_1 = new JButton("중복 확인");
		btnNewButton_1.setBounds(280, 62, 97, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("중복 확인");
		btnNewButton.setBounds(280, 10, 97, 23);
		panel.add(btnNewButton);
		
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
		
		JButton okbtn = new JButton("확인");
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
		dialog.setVisible(true);
	}

}