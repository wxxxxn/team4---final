package custom_panel;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.SwingConstants;


public class ItemPanel extends JPanel {

	public ItemPanel() {
		setBackground(Color.GRAY);
		setBounds(100, 100, 560, 100);
		setLayout(null);
		
		JLabel imageLabel = new JLabel("이미지");
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setForeground(Color.BLACK);
		imageLabel.setBackground(Color.WHITE);
		imageLabel.setOpaque(true);
		imageLabel.setBounds(12, 10, 80, 80);
		add(imageLabel);
		
		JLabel itemNameLabel = new JLabel("item name");
		itemNameLabel.setForeground(Color.BLACK);
		itemNameLabel.setBackground(Color.WHITE);
		itemNameLabel.setOpaque(true);
		itemNameLabel.setBounds(104, 10, 352, 23);
		add(itemNameLabel);
		
		JLabel itemDescriptionLabel = new JLabel("description");
		itemDescriptionLabel.setBackground(Color.WHITE);
		itemDescriptionLabel.setOpaque(true);
		itemDescriptionLabel.setBounds(104, 43, 352, 47);
		add(itemDescriptionLabel);
		
		JLabel LevelLabel = new JLabel("LV.1");
		LevelLabel.setBackground(Color.WHITE);
		LevelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LevelLabel.setOpaque(true);
		LevelLabel.setBounds(468, 10, 80, 80);
		add(LevelLabel);
	}
}
