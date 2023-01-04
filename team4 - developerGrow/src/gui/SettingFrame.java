package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingFrame extends JDialog {

	private JPanel contentPane;

	public SettingFrame() {
		setBounds(500, 200, 400, 600);
		setUndecorated(true);
		setModal(true);
		setBackground(new Color(0,0,0,100));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0, 0, 0, 0));

		JLabel settinglbl = new JLabel("환경설정");
		settinglbl.setForeground(Color.WHITE);
		settinglbl.setFont(new Font("휴먼편지체", Font.PLAIN, 40));
		settinglbl.setBounds(132, 23, 140, 68);
		contentPane.add(settinglbl);

		JLabel lblNewLabel = new JLabel("현재 접속중인 닉네임");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		lblNewLabel.setBounds(39, 153, 170, 54);
		contentPane.add(lblNewLabel);

		JButton resetbtn = new JButton("리셋");
		resetbtn.setBounds(122, 254, 150, 40);
		contentPane.add(resetbtn);
		resetbtn.setOpaque(false);
		resetbtn.setBorderPainted(false);

		JButton logoutbtn = new JButton("로그아웃");
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logoutbtn.setBounds(122, 326, 150, 40);
		contentPane.add(logoutbtn);
		logoutbtn.setOpaque(false);
		logoutbtn.setBorderPainted(false);

		JButton outbtn = new JButton("회원탈퇴");
		outbtn.setBounds(122, 398, 150, 40);
		contentPane.add(outbtn);
		outbtn.setOpaque(false);
		outbtn.setBorderPainted(false);
		
		JButton btnNewButton = new JButton("닫기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(288, 544, 100, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("포비");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_1.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(238, 153, 126, 54);
		contentPane.add(lblNewLabel_1);
		

	}

	public void showGUI() {
		setVisible(true);
	}
}
