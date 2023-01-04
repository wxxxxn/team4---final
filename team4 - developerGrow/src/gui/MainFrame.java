package gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
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
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				stopSound();
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL URLmix = classLoader.getResource("music\\mix.wav");
		sound(URLmix);
		
		setBounds(100, 100, 1200, 800);
		Mainpnl = new JPanel();
		Mainpnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Mainpnl);
		Mainpnl.setLayout(null);

		JProgressBar expbar = new JProgressBar();
		expbar.setValue(20);
		expbar.setStringPainted(true);
		expbar.setForeground(new Color(30, 144, 255));
		expbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		expbar.setBounds(50, 735, 827, 20);
		Mainpnl.add(expbar);

		JLabel lblNewLabel_2 = new JLabel("exp");
		lblNewLabel_2.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		lblNewLabel_2.setBounds(12, 728, 37, 29);
		Mainpnl.add(lblNewLabel_2);		
		
		
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
//		statuspnl.setOpaque(false);
		statuspnl.setLayout(null);
		statuspnl.setBackground(new Color(255, 255, 255, 100));

		JPanel currentcigapnl = new JPanel();
		currentcigapnl.setBounds(22, 10, 225, 42);
		statuspnl.add(currentcigapnl);
		currentcigapnl.setOpaque(false);
		currentcigapnl.setLayout(null);

		JLabel currentcigalbl = new JLabel("담배  X");
		currentcigalbl.setIcon(new ImageIcon(MainFrame.class.getResource("/rank_image/ciga.png")));
		currentcigalbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		currentcigalbl.setBounds(12, 0, 117, 43);
		currentcigapnl.add(currentcigalbl);
		
		JLabel numOfcigalbl = new JLabel("10");
		numOfcigalbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		numOfcigalbl.setBounds(124, 5, 89, 33);
		currentcigapnl.add(numOfcigalbl);

		JPanel stresspnl = new JPanel();
		stresspnl.setBounds(294, 40, 571, 30);
		statuspnl.add(stresspnl);
		stresspnl.setOpaque(false);
		stresspnl.setLayout(null);

		JLabel stresslbl = new JLabel("스트레스");
		stresslbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		stresslbl.setBounds(12, 5, 64, 22);
		stresspnl.add(stresslbl);
		
		JProgressBar stessbar = new JProgressBar();
		stessbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		stessbar.setValue(10);
		stessbar.setStringPainted(true);
		stessbar.setForeground(new Color(139, 0, 0));
		stessbar.setBounds(80, 5, 480, 22);
		stresspnl.add(stessbar);
		
		JPanel developlvpnl = new JPanel();
		developlvpnl.setBounds(22, 62, 225, 42);
		statuspnl.add(developlvpnl);
		developlvpnl.setOpaque(false);
		developlvpnl.setLayout(null);

		JLabel lblNewLabel = new JLabel("개발능력Lv");
		lblNewLabel.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 5, 110, 32);
		developlvpnl.add(lblNewLabel);
		
		JLabel numOflevellbl = new JLabel("10");
		numOflevellbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		numOflevellbl.setBounds(124, 5, 89, 33);
		developlvpnl.add(numOflevellbl);

		JPanel healthpnl = new JPanel();
		healthpnl.setLayout(null);
		healthpnl.setOpaque(false);
		healthpnl.setBounds(294, 75, 571, 30);
		statuspnl.add(healthpnl);
		
		JLabel healthlbl = new JLabel("건강");
		healthlbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		healthlbl.setBounds(12, 5, 54, 22);
		healthpnl.add(healthlbl);
		
		JProgressBar healthbar = new JProgressBar();
		healthbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		healthbar.setValue(100);
		healthbar.setStringPainted(true);
		healthbar.setForeground(new Color(0, 128, 0));
		healthbar.setBounds(80, 5, 480, 22);
		healthpnl.add(healthbar);
		
				JPanel hppnl = new JPanel();
				hppnl.setBounds(294, 5, 571, 30);
				statuspnl.add(hppnl);
				hppnl.setOpaque(false);
				hppnl.setBackground(new Color(255, 0, 0, 0));
				hppnl.setLayout(null);
				

				JLabel hplbl = new JLabel("HP");
				hplbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
				hplbl.setBounds(12, 5, 57, 22);
				hppnl.add(hplbl);
				
						JProgressBar hpbar = new JProgressBar();
						hpbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
						hpbar.setForeground(Color.RED);
						hpbar.setStringPainted(true);
						hpbar.setValue(100);
						hpbar.setBounds(80, 5, 480, 22);
						hppnl.add(hpbar);
		
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
				RankingDialog rankingFrame = new RankingDialog(MainFrame.this.getX(), MainFrame.this.getY());
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
				SettingDialog settingFrame = new SettingDialog(MainFrame.this.getX(), MainFrame.this.getY());
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
				StoreDialog storeFrame = new StoreDialog(MainFrame.this.getX(), MainFrame.this.getY());
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
				ProjectDialog projectFrame = new ProjectDialog(MainFrame.this.getX(), MainFrame.this.getY());
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
				ActiveDialog activeFrame = new ActiveDialog(MainFrame.this.getX(), MainFrame.this.getY());
				activeFrame.showGUI();
			}
		});

		
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
	
	public static void sound(URL file) {
		try {
			AudioInputStream ais1 = AudioSystem.getAudioInputStream(file);
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
