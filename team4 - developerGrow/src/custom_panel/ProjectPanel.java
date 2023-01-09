package custom_panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 * @author GGG
 *
 */
public class ProjectPanel extends JPanel implements MouseListener {
	
	private JLabel rankLabel;
	private JLabel projectName;
	private JLabel timeTakenlbl;
	private JLabel completelbl;
	private boolean complete = false;
	private JPanel completepnl;
	
	public ProjectPanel() {
		
		EtchedBorder eborder = new EtchedBorder(EtchedBorder.RAISED);
		setBorder(eborder);
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 540, 100);
		setLayout(null);
		
		completepnl = new JPanel();
		completepnl.setBounds(0, 0, 540, 100);
		completepnl.setBackground(new Color(100, 0, 0, 100));
		add(completepnl);
		completepnl.setVisible(false);
		completepnl.setLayout(null);
		
		completelbl = new JLabel("완료");
		completelbl.setForeground(Color.RED);
		completelbl.setFont(new Font("HY목각파임B", Font.BOLD, 40));
		completelbl.setHorizontalAlignment(SwingConstants.CENTER);
		completelbl.setBounds(236, 24, 84, 47);
		completepnl.add(completelbl);
		
		rankLabel = new JLabel("1주차");
		rankLabel.setBorder(eborder);
		rankLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		rankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel.setForeground(Color.BLACK);
		rankLabel.setBackground(Color.WHITE);
		rankLabel.setOpaque(true);
		rankLabel.setBounds(12, 10, 80, 80);
		add(rankLabel);
		
		projectName = new JLabel("업무이름");
		projectName.setBorder(eborder);
		projectName.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		projectName.setForeground(Color.BLACK);
		projectName.setBackground(Color.WHITE);
		projectName.setOpaque(true);
		projectName.setBounds(104, 10, 424, 28);
		add(projectName);
		
		JLabel timeLabel = new JLabel("소요시간");
		timeLabel.setBorder(eborder);
		timeLabel.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setBackground(Color.WHITE);
		timeLabel.setOpaque(true);
		timeLabel.setBounds(281, 48, 91, 42);
		add(timeLabel);
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL URLCigaImage = classLoader.getResource("rank_image/ciga.png");
		ImageIcon cigaImageIcon = new ImageIcon(URLCigaImage);
		
		JLabel rewardlbl = new JLabel("경험치 10000");
		rewardlbl.setBorder(eborder);
		rewardlbl.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		rewardlbl.setHorizontalAlignment(SwingConstants.LEFT);
		rewardlbl.setForeground(Color.BLACK);
		rewardlbl.setBackground(Color.WHITE);
		rewardlbl.setOpaque(true);
		rewardlbl.setBounds(155, 48, 114, 42);
		add(rewardlbl);
		
		JLabel scoreTextLabel = new JLabel("보상");
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
		
		timeTakenlbl = new JLabel("24");
		timeTakenlbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(timeTakenlbl);
		timeTakenlbl.setBorder(null);
		timeTakenlbl.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		timeTakenlbl.setForeground(Color.BLACK);
		timeTakenlbl.setBackground(Color.WHITE);
		timeTakenlbl.setOpaque(true);
		
		addMouseListener(this);
	}

	@Override
	public Dimension preferredSize() {
		return new Dimension(540, 100);
	}
	
	public JLabel getRankLabel() {
		return rankLabel;
	}
	
	public JLabel getProjectName() {
		return projectName;
	}
	
	public JLabel getTimeTakenlbl() {
		return timeTakenlbl;
	}
	
	public JPanel getCompletepnl() {
		return completepnl;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		completepnl.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (!complete) {
			setBackground(Color.pink);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (!complete) {
			setBackground(Color.LIGHT_GRAY);
		}
	}
	
	
}
