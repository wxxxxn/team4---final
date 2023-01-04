package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.net.URL;
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
		settinglbl.setFont(new Font("HY목각파임B", Font.BOLD, 40));
		settinglbl.setBounds(12, 23, 1161, 68);
		contentPane.add(settinglbl);

		JLabel lblNewLabel = new JLabel("현재 접속중인 닉네임");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("HY목각파임B", Font.PLAIN, 30));
		lblNewLabel.setBounds(50, 152, 585, 54);
		contentPane.add(lblNewLabel);
				
		JButton resetbtn = new JButton("리셋");
		resetbtn.setBounds(517, 246, 152, 45);
		resetbtn.setIcon(convertToIcon(getClass(), "btn_setting\\reset.png", 165, 45));
		resetbtn.setPressedIcon(convertToIcon(getClass(), "btn_setting\\resetPush.png", 165, 45));
		contentPane.add(resetbtn);
		resetbtn.setOpaque(false);
		resetbtn.setBorderPainted(false);

		JButton logoutbtn = new JButton("로그아웃");
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logoutbtn.setBounds(517, 321, 152, 45);
		logoutbtn.setIcon(convertToIcon(getClass(), "btn_setting\\logout.png", 165, 45));
		logoutbtn.setPressedIcon(convertToIcon(getClass(), "btn_setting\\logoutPush.png", 165, 45));
		contentPane.add(logoutbtn);
		logoutbtn.setOpaque(false);
		logoutbtn.setBorderPainted(false);

		JButton outbtn = new JButton("회원탈퇴");
		outbtn.setBounds(517, 397, 152, 45);
		outbtn.setIcon(convertToIcon(getClass(), "btn_setting\\userout.png", 165, 45));
		outbtn.setPressedIcon(convertToIcon(getClass(), "btn_setting\\useroutPush.png", 165, 45));
		contentPane.add(outbtn);
		outbtn.setOpaque(false);
		outbtn.setBorderPainted(false);
		
		JButton closebtn = new JButton("닫기");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		closebtn.setBounds(517, 543, 152, 45);
		closebtn.setIcon(convertToIcon(getClass(), "btn_image\\closeBtnImage.png", 165, 45));
		closebtn.setPressedIcon(convertToIcon(getClass(), "btn_image\\closeBtnPushImage.png", 165, 45));
		contentPane.add(closebtn);
		
		JLabel lblNewLabel_1 = new JLabel("포비");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("휴먼편지체", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(710, 152, 487, 54);
		contentPane.add(lblNewLabel_1);
		

	}
	
	public void showGUI() {
		setVisible(true);
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
}
