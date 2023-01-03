package custompanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RankPanel extends JPanel {

	public RankPanel() {
		setBackground(Color.GRAY);
		setBounds(100, 100, 560, 100);
		setLayout(null);
		
		JLabel rankLabel = new JLabel("1등");
		rankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel.setForeground(Color.BLACK);
		rankLabel.setBackground(Color.WHITE);
		rankLabel.setOpaque(true);
		rankLabel.setBounds(12, 10, 80, 80);
		add(rankLabel);
		
		JLabel nickNameLabel = new JLabel("닉네임");
		nickNameLabel.setForeground(Color.BLACK);
		nickNameLabel.setBackground(Color.WHITE);
		nickNameLabel.setOpaque(true);
		nickNameLabel.setBounds(104, 10, 444, 28);
		add(nickNameLabel);
		
		JLabel timeLabel = new JLabel("4일차 13:20");
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setBackground(Color.WHITE);
		timeLabel.setOpaque(true);
		timeLabel.setBounds(272, 48, 100, 42);
		add(timeLabel);
		
		JLabel usedCigaLabel = new JLabel("444개");
		usedCigaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usedCigaLabel.setForeground(Color.BLACK);
		usedCigaLabel.setBackground(Color.WHITE);
		usedCigaLabel.setOpaque(true);
		usedCigaLabel.setBounds(448, 48, 100, 42);
		add(usedCigaLabel);
		
		JLabel cigaImageLabel = new JLabel("담배 이미지");
		cigaImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cigaImageLabel.setForeground(Color.BLACK);
		cigaImageLabel.setBackground(Color.WHITE);
		cigaImageLabel.setOpaque(true);
		cigaImageLabel.setBounds(384, 48, 52, 42);
		add(cigaImageLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(104, 75, 155, -24);
		add(label);
		
		JLabel scoreLabel = new JLabel("4444점");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setForeground(Color.BLACK);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setOpaque(true);
		scoreLabel.setBounds(168, 48, 91, 42);
		add(scoreLabel);
		
		JLabel scoreTextLabel = new JLabel("점수");
		scoreTextLabel.setOpaque(true);
		scoreTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreTextLabel.setForeground(Color.BLACK);
		scoreTextLabel.setBackground(Color.WHITE);
		scoreTextLabel.setBounds(104, 48, 52, 42);
		add(scoreTextLabel);
		
	}

	@Override
	public Dimension preferredSize() {
		return new Dimension(560, 100);
	}
}
