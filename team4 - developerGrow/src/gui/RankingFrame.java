package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import custompanel.RankPanel;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class RankingFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingFrame frame = new RankingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RankingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel rankTextPanel = new JPanel();
		contentPane.add(rankTextPanel, BorderLayout.NORTH);
		
		JLabel rankTextLabel = new JLabel("랭킹");
		rankTextLabel.setFont(new Font("굴림", Font.BOLD, 25));
		rankTextPanel.add(rankTextLabel);
		
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
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel closeButtonPanel = new JPanel();
		contentPane.add(closeButtonPanel, BorderLayout.SOUTH);
		
		JButton closeButton = new JButton("닫기");
		closeButtonPanel.add(closeButton);
	}

}
