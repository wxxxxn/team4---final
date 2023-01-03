package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SettingFrame extends JFrame {

	private JPanel contentPane;

	public SettingFrame() {
		setBounds(500, 200, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel settinglbl = new JLabel("환경설정");
		settinglbl.setFont(new Font("굴림", Font.PLAIN, 30));
		settinglbl.setBounds(132, 10, 143, 45);
		contentPane.add(settinglbl);

		JLabel lblNewLabel = new JLabel("현재 접속중인 닉네임");
		lblNewLabel.setBounds(112, 139, 214, 54);
		contentPane.add(lblNewLabel);

		JButton resetbtn = new JButton("리셋");
		resetbtn.setBounds(122, 254, 97, 23);
		contentPane.add(resetbtn);
		resetbtn.setOpaque(false);
		resetbtn.setBackground(new Color(255, 0, 0, 0));
		resetbtn.setBorderPainted(false);

		JButton logoutbtn = new JButton("로그아웃");
		logoutbtn.setBounds(122, 334, 97, 23);
		contentPane.add(logoutbtn);
		logoutbtn.setOpaque(false);
		logoutbtn.setBackground(new Color(255, 0, 0, 0));
		logoutbtn.setBorderPainted(false);

		JButton outbtn = new JButton("회원탈퇴-기능없");
		outbtn.setBounds(222, 509, 136, 23);
		contentPane.add(outbtn);
		outbtn.setOpaque(false);
		outbtn.setBackground(new Color(255, 0, 0, 0));
		outbtn.setBorderPainted(false);
	}

	public void showGUI() {
		setVisible(true);
	}
}
