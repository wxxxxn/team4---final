package custom_panel;

import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class RankPanel extends JPanel {
	public RankPanel() {
		
		EtchedBorder eborder = new EtchedBorder(EtchedBorder.RAISED);
		setBorder(eborder);
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 540, 100);
		setLayout(null);
		
		JLabel rankLabel = new JLabel("1등");
		rankLabel.setBorder(eborder);
		rankLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		rankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel.setForeground(Color.BLACK);
		rankLabel.setBackground(Color.WHITE);
		rankLabel.setOpaque(true);
		rankLabel.setBounds(12, 10, 80, 80);
		add(rankLabel);
		
		JLabel nickNameLabel = new JLabel("닉네임");
		nickNameLabel.setBorder(eborder);
		nickNameLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		nickNameLabel.setForeground(Color.BLACK);
		nickNameLabel.setBackground(Color.WHITE);
		nickNameLabel.setOpaque(true);
		nickNameLabel.setBounds(104, 10, 424, 28);
		add(nickNameLabel);
		
		JLabel timeLabel = new JLabel("4일차 13:20");
		timeLabel.setBorder(eborder);
		timeLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setBackground(Color.WHITE);
		timeLabel.setOpaque(true);
		timeLabel.setBounds(258, 48, 114, 42);
		add(timeLabel);
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL URLCigaImage = classLoader.getResource("rank_image/ciga.png");
		ImageIcon cigaImageIcon = new ImageIcon(URLCigaImage);
		
		JLabel scoreLabel = new JLabel("4444점");
		scoreLabel.setBorder(eborder);
		scoreLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		scoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		scoreLabel.setForeground(Color.BLACK);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setOpaque(true);
		scoreLabel.setBounds(155, 48, 91, 42);
		add(scoreLabel);
		
		JLabel scoreTextLabel = new JLabel("점수");
		scoreTextLabel.setBorder(eborder);
		scoreTextLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		scoreTextLabel.setOpaque(true);
		scoreTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreTextLabel.setForeground(Color.BLACK);
		scoreTextLabel.setBackground(Color.WHITE);
		scoreTextLabel.setBounds(104, 48, 39, 42);
		add(scoreTextLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(eborder);
		panel.setBounds(384, 48, 144, 42);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel cigaImageLabel = new JLabel();
		cigaImageLabel.setBackground(new Color(255, 0, 0, 0));
		panel.add(cigaImageLabel, BorderLayout.WEST);
		cigaImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cigaImageLabel.setIcon(cigaImageIcon);
		
		JLabel usedCigaLabel = new JLabel("444개");
		panel.add(usedCigaLabel);
		usedCigaLabel.setBorder(null);
		usedCigaLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		usedCigaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usedCigaLabel.setForeground(Color.BLACK);
		usedCigaLabel.setBackground(Color.WHITE);
		usedCigaLabel.setOpaque(true);
		
	}

	@Override
	public Dimension preferredSize() {
		return new Dimension(540, 100);
	}
}
