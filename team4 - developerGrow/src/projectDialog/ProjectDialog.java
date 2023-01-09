package projectDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import custom_panel.ProjectPanel;
import database.dblist.Project;
import database.dblist.UserProject;
import main.MainFrame;

public class ProjectDialog extends JDialog implements MouseListener {

	private JPanel contentPane;
	private MainFrame mainFrame;
	private ProjectPanel[] pjs;
	private int minutes;
	private int hours;
	private double rate;
	private List<Project> projectList;
	private int time;
	private List<UserProject> userProjectList;

	public ProjectDialog(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		projectList = mainFrame.getProjectList();
		userProjectList = mainFrame.getUserProjectList();
		
		setUndecorated(true);
		setModal(true);
		setBackground(new Color(0, 0, 0, 100));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setOpaque(false);
		contentPane.setBackground(new Color(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel rankTextPanel = new JLabel("프로젝트");
		rankTextPanel.setBackground(Color.WHITE);
		rankTextPanel.setHorizontalAlignment(SwingConstants.CENTER);
		rankTextPanel.setFont(new Font("HY목각파임B", Font.BOLD, 40));
		rankTextPanel.setBounds(12, 10, 1161, 50);
		contentPane.add(rankTextPanel);

		JPanel projectsPanel = new JPanel();
		projectsPanel.setOpaque(false);
		projectsPanel.setBackground(new Color(0, true));
		projectsPanel.setLayout(new BoxLayout(projectsPanel, BoxLayout.Y_AXIS));

		pjs = new ProjectPanel[17];
	
		for (int i = 0; i < pjs.length; i++) {
			ProjectPanel project = new ProjectPanel();
			project.getRankLabel().setText(String.valueOf((i + 1) + "주차"));
			project.getProjectName().setText(projectList.get(i).getProjectName());
			project.getTimeTakenlbl().setText(String.valueOf(projectList.get(i).getTime()));
			if (userProjectList.get(i).isComplete()) {
				project.setComplete(userProjectList.get(i).isComplete());
				project.getCompletepnl().setVisible(true);
			}
			pjs[i] = project;
			projectsPanel.add(pjs[i]);
			projectsPanel.add(Box.createVerticalStrut(25));
			pjs[i].addMouseListener(this);
		}

		JScrollPane scrollPane = new JScrollPane(projectsPanel);
		scrollPane.setOpaque(false);
		scrollPane.setBackground(new Color(0, true));
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(312, 72, 560, 619);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		contentPane.add(scrollPane);

		ClassLoader classLoader = getClass().getClassLoader();

		URL URLCloseButtonImage = classLoader.getResource("btn_image/closeBtnImage.png");
		ImageIcon CloseButtonIcon = new ImageIcon(URLCloseButtonImage);

		URL URLCloseButtonPushImage = classLoader.getResource("btn_image/closeBtnPushImage.png");
		ImageIcon CloseButtonPushIcon = new ImageIcon(URLCloseButtonPushImage);

		JButton closeButton = new JButton();
		closeButton.setBounds(488, 701, 200, 50);
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
	
	public void timeController() {
		minutes = Integer.valueOf(mainFrame.getProjectMinute().getText());
		hours = Integer.valueOf(mainFrame.getProjectHour().getText());
		rate = Double.valueOf(mainFrame.getNowRatinglbl().getText());
		Timer countdown = new Timer();
	    TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				
				if (hours == 0 && minutes == 0) {
					countdown.cancel();
				} else if (minutes == 0) {
					hours--;
					minutes = 59;
				} else {
					minutes--;
				}
				rate = 100 - ((double)(hours * 60 + minutes) / (time * 60)) * 100;
				updateTime(minutes, hours, rate);
			}
	    };
		countdown.scheduleAtFixedRate(timerTask, 10, 10);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object command = e.getSource();
		for (int i = 0; i < projectList.size(); i++) {
			if (command == pjs[i] && !pjs[i].isComplete()) {
				pjs[i].setComplete(true);
				String str = projectList.get(i).getProjectName();
				time = projectList.get(i).getTime();
				mainFrame.getNowProjectlbl().setText(str);
				mainFrame.getProjectHour().setText(String.valueOf(time));
				mainFrame.revalidate();
				mainFrame.repaint();
				dispose();
				timeController();
			}
		}	
	}
	
	private void updateTime(int minutes, int hours, double rate) {
		mainFrame.getProjectHour().setText(String.format("%02d", hours));
		mainFrame.getProjectMinute().setText(String.format("%02d", minutes));
		mainFrame.getNowRatinglbl().setText(String.format("%.02f", rate));
		mainFrame.revalidate();
		mainFrame.repaint();		
    }

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
