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
import javax.swing.SwingConstants;

public class SettingDialog extends JDialog {

	private JPanel contentPane;

	public SettingDialog(int x, int y) {
		setBounds(x + 7, y + 30, 1185, 762);
		setUndecorated(true);
		setModal(true);
		setBackground(new Color(0,0,0,100));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0, 0, 0, 0));

		JLabel settinglbl = new JLabel("환경설정");
		settinglbl.setHorizontalAlignment(SwingConstants.CENTER);
		settinglbl.setForeground(Color.WHITE);
		settinglbl.setFont(new Font("휴먼편지체", Font.PLAIN, 40));
		settinglbl.setBounds(12, 23, 1161, 68);
		contentPane.add(settinglbl);

		JLabel lblNewLabel = new JLabel("현재 접속중인 닉네임");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 153, 585, 54);
		contentPane.add(lblNewLabel);

		JButton resetbtn = new JButton("리셋");
		resetbtn.setBounds(517, 246, 150, 40);
		contentPane.add(resetbtn);
		resetbtn.setOpaque(false);
		resetbtn.setBorderPainted(false);

		JButton logoutbtn = new JButton("로그아웃");
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logoutbtn.setBounds(517, 321, 150, 40);
		contentPane.add(logoutbtn);
		logoutbtn.setOpaque(false);
		logoutbtn.setBorderPainted(false);

		JButton outbtn = new JButton("회원탈퇴");
		outbtn.setBounds(517, 397, 150, 40);
		contentPane.add(outbtn);
		outbtn.setOpaque(false);
		outbtn.setBorderPainted(false);
		
		JButton btnNewButton = new JButton("닫기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(542, 543, 100, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("포비");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("휴먼편지체", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(672, 153, 487, 54);
		contentPane.add(lblNewLabel_1);
		

	}

	public void showGUI() {
		setVisible(true);
	}
}
