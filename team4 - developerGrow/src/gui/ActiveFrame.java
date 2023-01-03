package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ActiveFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActiveFrame frame = new ActiveFrame();
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
	public ActiveFrame() {
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("상하차");
		btnNewButton.setBounds(37, 59, 97, 45);
		contentPane.add(btnNewButton);
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("활동");	
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(188, 10, 183, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("이력서 작성");
		btnNewButton_1.setBounds(37, 126, 97, 45);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBackground(new Color(255, 0, 0, 0));
		btnNewButton_1.setBorderPainted(false);
		
		JButton btnNewButton_2 = new JButton("담배피기");
		btnNewButton_2.setBounds(37, 197, 97, 45);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setBackground(new Color(255, 0, 0, 0));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setOpaque(false);
		
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
