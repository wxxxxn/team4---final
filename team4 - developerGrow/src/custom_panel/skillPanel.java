package custom_panel;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import java.awt.Font;


public class skillPanel extends JPanel {

	public skillPanel() {
		EtchedBorder eborder = new EtchedBorder(EtchedBorder.RAISED);
		
		setBorder(eborder);
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 560, 100);
		setLayout(null);
		
		JLabel imageLabel = new JLabel("이미지");
		imageLabel.setBorder(eborder);
		imageLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setForeground(Color.BLACK);
		imageLabel.setBackground(Color.WHITE);
		imageLabel.setOpaque(true);
		imageLabel.setBounds(12, 10, 80, 80);
		add(imageLabel);
		
		JLabel itemNameLabel = new JLabel("item name");
		itemNameLabel.setBorder(eborder);
		itemNameLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		itemNameLabel.setForeground(Color.BLACK);
		itemNameLabel.setBackground(Color.WHITE);
		itemNameLabel.setOpaque(true);
		itemNameLabel.setBounds(104, 10, 352, 23);
		add(itemNameLabel);
		
		JLabel itemDescriptionLabel = new JLabel("description");
		itemDescriptionLabel.setBorder(eborder);
		itemDescriptionLabel.setVerticalAlignment(SwingConstants.TOP);
		itemDescriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		itemDescriptionLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		itemDescriptionLabel.setBackground(Color.WHITE);
		itemDescriptionLabel.setOpaque(true);
		itemDescriptionLabel.setBounds(104, 43, 352, 47);
		add(itemDescriptionLabel);
		
		JLabel LevelLabel = new JLabel("LV.1");
		LevelLabel.setBorder(eborder);
		LevelLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		LevelLabel.setBackground(Color.WHITE);
		LevelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LevelLabel.setOpaque(true);
		LevelLabel.setBounds(468, 10, 80, 80);
		add(LevelLabel);
	}
}
