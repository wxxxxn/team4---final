package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import custom_panel.RankPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class RankingFrame extends JFrame {

	private JPanel contentPane;

	public RankingFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//		JPanel rankTextPanel = new JPanel();
//		contentPane.add(rankTextPanel, BorderLayout.NORTH);
//		
//		JLabel rankTextLabel = new JLabel("랭킹");
//		rankTextLabel.setFont(new Font("굴림", Font.BOLD, 25));
//		rankTextPanel.add(rankTextLabel);

		JLabel rankTextPanel = new JLabel("랭킹");
		rankTextPanel.setHorizontalAlignment(SwingConstants.CENTER);
		rankTextPanel.setFont(new Font("HY목각파임B", Font.BOLD, 40));
		rankTextPanel.setBounds(12, 10, 560, 50);
		contentPane.add(rankTextPanel);

		JPanel rankersPanel = new JPanel();
		rankersPanel.setLayout(new BoxLayout(rankersPanel, BoxLayout.Y_AXIS));

		RankPanel[] rp = new RankPanel[10];
		for (int i = 0; i < rp.length; i++) {
			RankPanel ranker = new RankPanel();
			rp[i] = ranker;
			rankersPanel.add(rp[i]);
			rankersPanel.add(Box.createVerticalStrut(25));
		}

		JScrollPane scrollPane = new JScrollPane(rankersPanel);
		scrollPane.setBackground(new Color(255, 0, 0, 0));
		scrollPane.setBounds(12, 72, 560, 619);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);

		ClassLoader classLoader = getClass().getClassLoader();

		URL URLCloseButtonImage = classLoader.getResource("btn_image/closeBtnImage.png");
		ImageIcon CloseButtonIcon = new ImageIcon(URLCloseButtonImage);

		URL URLCloseButtonPushImage = classLoader.getResource("btn_image/closeBtnPushImage.png");
		ImageIcon CloseButtonPushIcon = new ImageIcon(URLCloseButtonPushImage);

		JButton closeButton = new JButton();
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
