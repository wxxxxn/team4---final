package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import custom_panel.ItemPanel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class StoreFrame extends JFrame {

	private JPanel contentPane;

	public StoreFrame() {
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel storeLabel = new JLabel("스킬 목록");
		storeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		storeLabel.setFont(new Font("굴림", Font.BOLD, 25));
		storeLabel.setBounds(12, 10, 560, 50);
		contentPane.add(storeLabel);
		
		JPanel itemsPanel = new JPanel();
		itemsPanel.setOpaque(true);
		itemsPanel.setBackground(new Color(255, 0, 0, 0));
		itemsPanel.setBounds(12, 72, 560, 619);
		contentPane.add(itemsPanel);
		itemsPanel.setLayout(new GridLayout(5, 0, 0, 25));
		
		ItemPanel[] item = new ItemPanel[5];
		for (int i = 0; i < item.length; i++) {
			ItemPanel itemPanel = new ItemPanel();
			item[i] = itemPanel;
			itemsPanel.add(item[i]);
		}
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		URL URLCloseButtonImage = classLoader.getResource("btn_image/closeBtnImage.png");
		ImageIcon CloseButtonIcon = new ImageIcon(URLCloseButtonImage);
		
		URL URLCloseButtonPushImage = classLoader.getResource("btn_image/closeBtnPushImage.png");
		ImageIcon CloseButtonPushIcon = new ImageIcon(URLCloseButtonPushImage);
		
		JButton closeButton = new JButton("");
		closeButton.setBounds(180, 701, 200, 50);
		closeButton.setIcon(CloseButtonIcon);
		closeButton.setPressedIcon(CloseButtonPushIcon);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(closeButton);
	}
	
	public void showGUI() {
		setVisible(true);
	}
}
