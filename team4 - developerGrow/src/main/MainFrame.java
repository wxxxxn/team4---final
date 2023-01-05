package main;

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
import javax.swing.border.LineBorder;

import gui.ActiveDialog;
import gui.ProjectDialog;
import gui.RankingDialog;
import gui.SettingDialog;
import gui.StoreDialog;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel Mainpnl;
	private JButton settingbtn;
	private static Clip clip;
	private JLabel datelbl;
	private JLabel hourlbl;
	private JLabel minutelbl;
	private GameControllerImpl gameControllerImpl = new GameControllerImpl(this);
	private GameEventImpl gameEventImpl = new GameEventImpl(this);

	public MainFrame(int id) {
		// 나중에 채우기
	}
		// 테스트용
	public MainFrame() {
		
		gameControllerImpl.timeController();

		ClassLoader classLoader = getClass().getClassLoader();
		URL URLmix = classLoader.getResource("music\\mix.wav");
		sound(URLmix);

		setBounds(100, 100, 1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		date.setBounds(12, 10, 135, 45);
		Mainpnl.add(date);
		date.setLayout(null);
		date.setOpaque(false);

		datelbl = new JLabel("00일차");
		datelbl.setHorizontalAlignment(SwingConstants.CENTER);
//		datelbl.setBorder(new LineBorder(Color.BLACK, 2));
		datelbl.setFont(new Font("HY목각파임B", Font.BOLD, 30));
		datelbl.setBounds(0, 0, 135, 45);
		date.add(datelbl);
		
		JPanel currentTime = new JPanel();
		currentTime.setBounds(147, 10, 135, 45);
		Mainpnl.add(currentTime);
//		currentTime.setBorder(new LineBorder(Color.BLACK, 2));
		currentTime.setOpaque(false);
		currentTime.setBackground(new Color(255, 0, 0, 0));
		currentTime.setLayout(null);
		
		hourlbl = new JLabel("07");
		hourlbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		hourlbl.setFont(new Font("HY목각파임B", Font.BOLD, 30));
		hourlbl.setBounds(0, 0, 60, 45);
		currentTime.add(hourlbl);
		
		minutelbl = new JLabel("00");
		minutelbl.setHorizontalAlignment(SwingConstants.CENTER);
		minutelbl.setFont(new Font("HY목각파임B", Font.BOLD, 28));
		minutelbl.setBounds(75, 0, 60, 45);
		currentTime.add(minutelbl);
		
		JLabel colonlbl = new JLabel(":");
		colonlbl.setHorizontalAlignment(SwingConstants.CENTER);
		colonlbl.setFont(new Font("Algerian", Font.BOLD, 30));
		colonlbl.setBounds(60, 0, 15, 45);
		currentTime.add(colonlbl);

		JPanel statuspnl = new JPanel();
		statuspnl.setBounds(12, 608, 877, 114);
		Mainpnl.add(statuspnl);
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
		taskbtn.setHorizontalAlignment(SwingConstants.LEFT);
		taskbtn.setBounds(1042, 525, 99, 81);
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
		Mainpnl.add(character);

		JLabel Image = new JLabel("");
		Image.setBounds(0, 0, 1200, 800);
		URL URLbackImage = classLoader.getResource("backimg/background.png");
		Image.setIcon(new ImageIcon(URLbackImage));
		Mainpnl.add(Image);
		Image.setOpaque(false);
		Image.setBackground(new Color(255, 0, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("현재 진행중인 업무");
		lblNewLabel_1.setBounds(12, 201, 250, 159);
		Mainpnl.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

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
	
	public JLabel getHourlbl() {
		return hourlbl;
	}

	public JLabel getMinutelbl() {
		return minutelbl;
	}

	public JLabel getDatelbl() {
		return datelbl;
	}
}
