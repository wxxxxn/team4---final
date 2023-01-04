package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import guiDesign.MyPassword;
import guiDesign.MyTextField;

public class LoginFrame extends JFrame {

	private JFrame frame;
	private MyTextField txtId;
	private JButton signupbtn;
	private JButton loginbtn;
	private MyPassword passwordField;
	private JLabel lblNewLabel_1;
	private static Clip clip;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrame() {
		sound("src\\music\\main.wav");
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(60, 200, 362, 115);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txtId = new MyTextField();
		txtId.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
		txtId.setPrefixIcon(convertToIcon(getClass(), "guiDesign\\user.png", 30, 30));
		txtId.setBounds(12, 10, 338, 41);
		panel.add(txtId);

		passwordField = new MyPassword();
		passwordField.setPrefixIcon(convertToIcon(getClass(), "guiDesign\\key.png", 30, 30));
		passwordField.setBounds(12, 61, 338, 41);
		panel.add(passwordField);

		JLabel lblNewLabel = new JLabel("개발자 키우기");
		lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 36));
		lblNewLabel.setBounds(39, 69, 267, 63);
		frame.getContentPane().add(lblNewLabel);

		signupbtn = new JButton("");
		URL URLSignupImage = classLoader.getResource("btn_image/SignBtnImage.png");
		ImageIcon SignupBtnIcon = new ImageIcon(URLSignupImage);
		URL URLSignupPushImage = classLoader.getResource("btn_image/SignPushBtnImage.png");
		ImageIcon SignupPushBtnIcon = new ImageIcon(URLSignupPushImage);
		signupbtn.setIcon(SignupBtnIcon);
		signupbtn.setPressedIcon(SignupPushBtnIcon);
		signupbtn.setBorderPainted(false);
		signupbtn.setOpaque(false);
		signupbtn.setBackground(new Color(255, 0, 0, 0));
		signupbtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupbtn.setBounds(94, 347, 139, 63);
		frame.getContentPane().add(signupbtn);
		signupbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpFrame signUpFrame = new SignUpFrame();
				signUpFrame.showGUI();
			}
		});

		loginbtn = new JButton("");
		URL URLLoginImage = classLoader.getResource("btn_image/loginBtnImage.png");
		ImageIcon LoginBtnIcon = new ImageIcon(URLLoginImage);
		URL URLLoginPushImage = classLoader.getResource("btn_image/loginPushBtnImage.png");
		ImageIcon LoginPushBtnIcon = new ImageIcon(URLLoginPushImage);
		loginbtn.setIcon(LoginBtnIcon);
		loginbtn.setPressedIcon(LoginPushBtnIcon);
		loginbtn.setBorderPainted(false);
		loginbtn.setOpaque(false);
		loginbtn.setBackground(new Color(255, 0, 0, 0));
		loginbtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		loginbtn.setBounds(245, 347, 139, 63);
		frame.getContentPane().add(loginbtn);

		lblNewLabel_1 = new JLabel("");
		URL URLbackImage = classLoader.getResource("character/logincharacter.gif");
		lblNewLabel_1.setIcon(new ImageIcon(URLbackImage));
		lblNewLabel_1.setBounds(299, 24, 161, 166);
		frame.getContentPane().add(lblNewLabel_1);
		loginbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame();
				mainFrame.showGUI();
				stopSound();
			}
		});
	}
	
	public static ImageIcon convertToIcon(Class useClass, String name, int width, int height) {
		String imageName = name;
		int thisWidth = width;
		int thisHeight = height;
		Toolkit kit = Toolkit.getDefaultToolkit();
		ClassLoader classLoader = useClass.getClassLoader();
		try {
			Image image = kit.getImage(classLoader.getResource(imageName));
			image = image.getScaledInstance(thisWidth, thisHeight, Image.SCALE_SMOOTH);
			// 이미지크기조절
			ImageIcon icon = new ImageIcon(image);
			return icon;
		} catch (NullPointerException e) {
			System.out.println(name + " 해당 이미지 파일을 찾을 수 없습니다.");
		}
		return null;
	 }
	
	public static void sound(String file) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void stopSound() {
		clip.stop();
		clip.close();
	}
}