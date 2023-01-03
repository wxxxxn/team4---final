package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class ProjectFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectFrame frame = new ProjectFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProjectFrame() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Hello world 출력");
		btnNewButton.setBounds(37, 59, 97, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("업무(프로젝트)");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(146, 10, 225, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("이력서 작성");
		btnNewButton_1.setBounds(37, 126, 97, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("담배피기");
		btnNewButton_2.setBounds(37, 197, 97, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("밥먹기");
		btnNewButton_3.setBounds(37, 252, 97, 45);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("잠자기");
		btnNewButton_4.setBounds(37, 320, 97, 45);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("게임하기");
		btnNewButton_5.setBounds(37, 393, 97, 45);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("설명");
		lblNewLabel_1.setBounds(175, 59, 245, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(175, 126, 245, 45);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setBounds(175, 197, 245, 45);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setBounds(175, 252, 245, 45);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setBounds(175, 320, 245, 45);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("New label");
		lblNewLabel_1_5.setBounds(175, 393, 245, 45);
		contentPane.add(lblNewLabel_1_5);
	}

}
