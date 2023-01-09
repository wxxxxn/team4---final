package gui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainFrame;

public class DeathDialog extends JDialog {
	
	private JPanel contentPane;
	
	public DeathDialog(int x, int y) {
		ClassLoader classLoader = getClass().getClassLoader();
		URL Back = classLoader.getResource("backimg/DeathBackground.png");
		ImageIcon back = new ImageIcon(Back);
		
		getContentPane().setLayout(null);
		setUndecorated(true);
		setModal(true);
		setBounds(x, y, 1200, 800);
		setBackground(new Color(0, 0, 0, 100));
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1200, 800);
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		
		JButton returnBtn = new JButton("다시하기");
		returnBtn.setBounds(1030, 698, 146, 53);
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				MainFrame mainFrame = new MainFrame();
//				mainFrame.showGUI();
//				dispose();
			}
		});
		contentPane.add(returnBtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(back);
		lblNewLabel.setBounds(0, 0, 1200, 800);
		contentPane.add(lblNewLabel);
	}
	
	public void showGUI() {
		setVisible(true);
	}
}
