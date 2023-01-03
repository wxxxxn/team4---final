package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {

	private JPanel Mainpnl;
	private JButton settingbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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

	public MainFrame() {
		

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		Mainpnl = new JPanel();
//		Mainpnl.add(contentPanel);
		Mainpnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Mainpnl);
		Mainpnl.setLayout(null);

		JPanel date = new JPanel();
		date.setBounds(12, 10, 184, 45);
		Mainpnl.add(date);
		date.setLayout(null);
		date.setOpaque(false);

		JLabel datelbl = new JLabel("2023-01-03");
		datelbl.setFont(new Font("굴림", Font.PLAIN, 16));
		datelbl.setBounds(12, 5, 160, 40);
		date.add(datelbl);

		JPanel statuspnl = new JPanel();
		statuspnl.setBounds(12, 608, 877, 114);
		Mainpnl.add(statuspnl);
		statuspnl.setOpaque(false);
		statuspnl.setLayout(null);

		JPanel currentcigapnl = new JPanel();
		currentcigapnl.setBounds(22, 10, 225, 42);
		statuspnl.add(currentcigapnl);
		currentcigapnl.setOpaque(false);
		currentcigapnl.setLayout(null);

		JLabel currentcigalbl = new JLabel("담배개비");
		currentcigalbl.setBounds(12, 0, 102, 43);
		currentcigapnl.add(currentcigalbl);

		JPanel stresspnl = new JPanel();
		stresspnl.setBounds(292, 10, 563, 42);
		statuspnl.add(stresspnl);
		stresspnl.setOpaque(false);
		stresspnl.setLayout(null);

		JLabel stresslbl = new JLabel("스트레스");
		stresslbl.setBounds(12, 10, 100, 22);
		stresspnl.add(stresslbl);

		JPanel hppnl = new JPanel();
		hppnl.setBounds(292, 62, 563, 42);
		statuspnl.add(hppnl);
		hppnl.setLayout(null);
		hppnl.setOpaque(false);
		hppnl.setBackground(new Color(255, 0, 0, 0));
		

		JLabel hplbl = new JLabel("HP");
		hplbl.setBounds(12, 10, 57, 22);
		hppnl.add(hplbl);

		JPanel developlvpnl = new JPanel();
		developlvpnl.setBounds(22, 62, 225, 42);
		statuspnl.add(developlvpnl);
		developlvpnl.setOpaque(false);
		developlvpnl.setLayout(null);

		JLabel lblNewLabel = new JLabel("개발능력Lv");
		lblNewLabel.setBounds(12, 10, 110, 32);
		developlvpnl.add(lblNewLabel);

		JPanel currentpnl = new JPanel();
		currentpnl.setBounds(12, 75, 232, 45);
		Mainpnl.add(currentpnl);
		currentpnl.setOpaque(false);
		currentpnl.setBackground(new Color(255, 0, 0, 0));
		currentpnl.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("현재 진행중인 업무");
		lblNewLabel_1.setBounds(12, 5, 177, 40);
		currentpnl.add(lblNewLabel_1);

		JButton rankingbtn = new JButton("랭킹");
		rankingbtn.setBounds(901, 30, 97, 65);
		Mainpnl.add(rankingbtn);
		rankingbtn.setBorderPainted(false);
		rankingbtn.setOpaque(false);
		rankingbtn.setBackground(new Color(255, 0, 0, 0));

		settingbtn = new JButton("설정");
		settingbtn.setBounds(1044, 30, 97, 65);
		Mainpnl.add(settingbtn);
		settingbtn.setOpaque(false);
		settingbtn.setBorderPainted(false);
		settingbtn.setBackground(new Color(255, 0, 0, 0));
		settingbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SettingFrame s1 = new SettingFrame();
				s1.setVisible(true);
			}
		});

		JButton storebtn = new JButton("상점");
		storebtn.setBounds(901, 684, 97, 38);
		Mainpnl.add(storebtn);
		storebtn.setOpaque(false);
		storebtn.setBackground(new Color(255, 0, 0, 0));
		storebtn.setBorderPainted(false);
		
		JButton gamebtn = new JButton("미니게임");
		gamebtn.setBounds(901, 608, 97, 38);
		Mainpnl.add(gamebtn);
		gamebtn.setOpaque(false);
		gamebtn.setBorderPainted(false);
		gamebtn.setBackground(new Color(255, 0, 0, 0));

		JButton taskbtn = new JButton("업무");
		taskbtn.setBounds(1044, 608, 97, 38);
		taskbtn.setOpaque(false);
		taskbtn.setBackground(new Color(255, 0, 0, 0));
		taskbtn.setBorderPainted(false);
		taskbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Mainpnl.add(taskbtn);

		JButton activitybtn = new JButton("활동");
		activitybtn.setBounds(1044, 684, 97, 38);
		Mainpnl.add(activitybtn);
		activitybtn.setOpaque(false);
		activitybtn.setBorderPainted(false);
		activitybtn.setBackground(new Color(255, 0, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("exp");
		lblNewLabel_2.setBounds(22, 736, 723, 15);
		Mainpnl.add(lblNewLabel_2);
		
		JLabel Image = new JLabel("");
		Image.setIcon(new ImageIcon("background.png"));
		Image.setBounds(0, 0, 1200, 800);
		Mainpnl.add(Image);
	}
}
