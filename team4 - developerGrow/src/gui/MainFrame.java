package gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {

	private JPanel Mainpnl;
	private JButton settingbtn;
	private static Clip clip;

	public MainFrame() {
		ClassLoader classLoader = getClass().getClassLoader();
		sound("src\\music\\mix.wav");
		
		setBounds(100, 100, 1200, 800);
		Mainpnl = new JPanel();
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
		hppnl.setOpaque(false);
		hppnl.setBackground(new Color(255, 0, 0, 0));
		hppnl.setLayout(null);
		

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

		JButton rankingbtn = new JButton();
		rankingbtn.setBounds(1051, 140, 90, 89);
		URL URLrankImage = classLoader.getResource("btn_image/rankBtnImage.png");
		rankingbtn.setIcon(new ImageIcon(URLrankImage));
		Mainpnl.add(rankingbtn);
		rankingbtn.setBorderPainted(false);
		rankingbtn.setOpaque(false);
		rankingbtn.setBackground(new Color(255, 0, 0, 0));
		rankingbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RankingFrame rankingFrame = new RankingFrame();
				rankingFrame.showGUI();
			}
		});

		settingbtn = new JButton();
		settingbtn.setBounds(1051, 10, 90, 89);
		URL URLsettingImage = classLoader.getResource("btn_image/settingBtnImage.png");
		settingbtn.setIcon(new ImageIcon(URLsettingImage));
		Mainpnl.add(settingbtn);
		settingbtn.setOpaque(false);
		settingbtn.setBorderPainted(false);
		settingbtn.setBackground(new Color(255, 0, 0, 0));
		settingbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SettingFrame settingFrame = new SettingFrame();
				settingFrame.showGUI();
				stopSound();
			}
		});

		JButton storebtn = new JButton();
		storebtn.setBounds(1051, 275, 90, 89);
		URL URLstoreImage = classLoader.getResource("btn_image/StoreBtnImage.png");
		storebtn.setIcon(new ImageIcon(URLstoreImage));
		Mainpnl.add(storebtn);
		storebtn.setOpaque(false);
		storebtn.setBackground(new Color(255, 0, 0, 0));
		storebtn.setBorderPainted(false);
		storebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StoreFrame storeFrame = new StoreFrame();
				storeFrame.showGUI();
			}
		});
		
		
		JButton gamebtn = new JButton();
		gamebtn.setBounds(1051, 395, 90, 81);
		URL URLgameImage = classLoader.getResource("btn_image/miniGameBtnImage.png");
		gamebtn.setIcon(new ImageIcon(URLgameImage));
		Mainpnl.add(gamebtn);
		gamebtn.setOpaque(false);
		gamebtn.setBorderPainted(false);
		gamebtn.setBackground(new Color(255, 0, 0, 0));

		JButton taskbtn = new JButton();
		taskbtn.setBounds(1052, 525, 89, 81);
		URL URLtaskImage = classLoader.getResource("btn_image/projectBtnImage.png");
		taskbtn.setIcon(new ImageIcon(URLtaskImage));
		taskbtn.setOpaque(false);
		taskbtn.setBackground(new Color(255, 0, 0, 0));
		taskbtn.setBorderPainted(false);
		taskbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProjectFrame projectFrame = new ProjectFrame();
				projectFrame.showGUI();
			}
		});
		Mainpnl.add(taskbtn);

		JButton activitybtn = new JButton();
		activitybtn.setBounds(1058, 633, 83, 89);
		URL URLactiveImage = classLoader.getResource("btn_image/activeBtnImage.png");
		activitybtn.setIcon(new ImageIcon(URLactiveImage));
		Mainpnl.add(activitybtn);
		activitybtn.setOpaque(false);
		activitybtn.setBorderPainted(false);
		activitybtn.setBackground(new Color(255, 0, 0, 0));
		activitybtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActiveFrame activeFrame = new ActiveFrame();
				activeFrame.showGUI();
			}
		});

		JLabel lblNewLabel_2 = new JLabel("exp");
		lblNewLabel_2.setBounds(22, 736, 723, 15);
		Mainpnl.add(lblNewLabel_2);
		
		JLabel character = new JLabel("");
		character.setBounds(211, 392, 210, 300);
		URL URLcharImage = classLoader.getResource("character/character.gif");
		character.setIcon(new ImageIcon(URLcharImage));
//		character.setOpaque(false);
//		character.setBackground(new Color(255, 0, 0, 0));
		Mainpnl.add(character);
		
		JLabel Image = new JLabel("");
		Image.setBounds(0, 0, 1200, 800);
		URL URLbackImage = classLoader.getResource("backimg/background.png");
		Image.setIcon(new ImageIcon(URLbackImage));
		Mainpnl.add(Image);
		Image.setOpaque(false);
		Image.setBackground(new Color(255, 0, 0, 0));
		

		
	}
	
	public void showGUI() {
		setVisible(true);
	}
	
	public static void sound(String file) {
		try {
			AudioInputStream ais1 = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais1);
			clip.start();
			clip.loop(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void stopSound() {
		clip.stop();
		clip.close();
	}
}
