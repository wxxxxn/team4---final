package main.store;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.MainFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class StoreDialog extends JDialog {

	private JPanel contentPane;
	private SkillPanel[] skills;
	private StoreEventImpl storeEventImpl;

	public StoreDialog(MainFrame mainFrame) {
		
		storeEventImpl = new StoreEventImpl(mainFrame);
		
		setUndecorated(true);
		setModal(true);
		contentPane = new JPanel();
		setBackground(new Color(0, 0, 0, 100));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel storeLabel = new JLabel("스킬 목록");
		storeLabel.setForeground(Color.BLACK);
		storeLabel.setBackground(Color.WHITE);
		storeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		storeLabel.setFont(new Font("HY목각파임B", Font.BOLD, 40));
		storeLabel.setBounds(12, 10, 1176, 50);
		contentPane.add(storeLabel);
		
		JPanel itemsPanel = new JPanel();
		itemsPanel.setForeground(new Color(255, 255, 255));
		itemsPanel.setOpaque(true);
		itemsPanel.setBackground(new Color(255, 0, 0, 0));
		itemsPanel.setBounds(308, 70, 560, 619);
		contentPane.add(itemsPanel);
		itemsPanel.setLayout(new GridLayout(5, 0, 10, 25));
		
		skills = new SkillPanel[5];
		for (int i = 0; i < skills.length; i++) {
			SkillPanel itemPanel = new SkillPanel();
			skills[i] = itemPanel;
			storeEventImpl.inputSkillInfo(i, skills[i]);
			itemsPanel.add(skills[i]);
		}
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		URL URLCloseButtonImage = classLoader.getResource("btn_image/closeBtnImage.png");
		ImageIcon CloseButtonIcon = new ImageIcon(URLCloseButtonImage);
		
		URL URLCloseButtonPushImage = classLoader.getResource("btn_image/closeBtnPushImage.png");
		ImageIcon CloseButtonPushIcon = new ImageIcon(URLCloseButtonPushImage);
		
		JButton closeButton = new JButton("");
		closeButton.setBounds(488, 701, 200, 50);
		closeButton.setIcon(CloseButtonIcon);
		closeButton.setPressedIcon(CloseButtonPushIcon);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < skills.length; i++) {
					mainFrame.getUserSkillList().get(i).setSkillLevel(skills[i].getLevel());
				}
				
				storeEventImpl.updateLevelToDB(skills);
				dispose();
			}
		});
		contentPane.add(closeButton);
	}
	
	public void showGUI() {
		setVisible(true);
	}

	public SkillPanel[] getItems() {
		return skills;
	}	
}