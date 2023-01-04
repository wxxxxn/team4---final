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
import javax.swing.SwingConstants;

public class ProjectDialog extends JDialog {

	private JPanel contentPane;

	public ProjectDialog(int x, int y) {
		setUndecorated(true);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x + 7, y + 30, 1185, 762);
		setBackground(new Color(0, 0, 0, 100));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Hello world 출력");
		btnNewButton.setBounds(420, 130, 130, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("업무(프로젝트)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY목각파임B", Font.BOLD, 40));
		lblNewLabel.setBounds(12, 10, 1161, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("이력서 작성");
		btnNewButton_1.setBounds(420, 230, 130, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("담배피기");
		btnNewButton_2.setBounds(420, 330, 130, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("밥먹기");
		btnNewButton_3.setBounds(420, 430, 130, 45);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("잠자기");
		btnNewButton_4.setBounds(420, 530, 130, 45);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("게임하기");
		btnNewButton_5.setBounds(420, 630, 130, 45);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("설명");
		lblNewLabel_1.setBounds(653, 130, 520, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(653, 230, 520, 45);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setBounds(653, 330, 520, 45);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setBounds(653, 430, 520, 45);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setBounds(653, 530, 520, 45);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("New label");
		lblNewLabel_1_5.setBounds(653, 630, 520, 45);
		contentPane.add(lblNewLabel_1_5);
	}

	public void showGUI() {
		setVisible(true);
	}
}
