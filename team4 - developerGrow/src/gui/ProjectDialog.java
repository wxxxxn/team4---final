package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class ProjectDialog extends JDialog {

	private JPanel contentPane;

	public ProjectDialog(int x, int y) {
		setUndecorated(true);
		setModal(true);
		setBounds(x + 7, y + 30, 1185, 762);
		setBackground(new Color(0, 0, 0, 100));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Hello world 출력");
		btnNewButton.setBounds(420, 110, 130, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("업무(프로젝트)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY목각파임B", Font.BOLD, 40));
		lblNewLabel.setBounds(12, 10, 1161, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("이력서 작성");
		btnNewButton_1.setBounds(420, 210, 130, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("담배피기");
		btnNewButton_2.setBounds(420, 310, 130, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("밥먹기");
		btnNewButton_3.setBounds(420, 410, 130, 45);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("잠자기");
		btnNewButton_4.setBounds(420, 510, 130, 45);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("게임하기");
		btnNewButton_5.setBounds(420, 610, 130, 45);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("설명");
		lblNewLabel_1.setBounds(653, 110, 520, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(653, 210, 520, 45);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setBounds(653, 310, 520, 45);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setBounds(653, 410, 520, 45);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setBounds(653, 510, 520, 45);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("New label");
		lblNewLabel_1_5.setBounds(653, 610, 520, 45);
		contentPane.add(lblNewLabel_1_5);
		
		JButton btnNewButton_6 = new JButton("닫기");
		btnNewButton_6.setBounds(535, 700, 130, 45);
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnNewButton_6);
	}

	public void showGUI() {
		setVisible(true);
	}
}
