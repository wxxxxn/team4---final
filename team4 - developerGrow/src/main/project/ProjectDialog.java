package main.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.List;

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

import database.dblist.Project;
import database.dblist.UserProject;
import main.MainFrame;

public class ProjectDialog extends JDialog implements MouseListener {

	private JPanel contentPane;
	private MainFrame mainFrame;
	private ProjectPanel[] pjs;
	private List<Project> projectList;
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
				project.setComplete(true);
				project.getCompletepnl().setVisible(true);
			}
			if (userProjectList.get(i).isProceeding()) {
				project.setProceeding(true);
				project.getProceedingpnl().setVisible(true);
			}
			pjs[i] = project;
			pjs[i].addMouseListener(this);
		}
		
		for (int i = 0; i < pjs.length; i++) {
			if (!userProjectList.get(i).isComplete()) {
				projectsPanel.add(pjs[i]);
				projectsPanel.add(Box.createVerticalStrut(25));
			}
		}
		for (int i = 0; i < pjs.length; i++) {
			if (userProjectList.get(i).isComplete()) {
				projectsPanel.add(pjs[i]);
				projectsPanel.add(Box.createVerticalStrut(25));
			}
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

		URL URLCloseButtonImage = classLoader.getResource("images/btn_img/closeBtnImage.png");
		ImageIcon CloseButtonIcon = new ImageIcon(URLCloseButtonImage);

		URL URLCloseButtonPushImage = classLoader.getResource("images/btn_img/closeBtnPushImage.png");
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
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object command = e.getSource();
		for (int i = 0; i < projectList.size(); i++) {
			if (command == pjs[i] && !pjs[i].isComplete() && !pjs[i].isProceeding()) {
				pjs[i].setProceeding(true);
				pjs[i].getProceedingpnl().setVisible(true);
				String str = projectList.get(i).getProjectName();
				mainFrame.getNowProjectlbl().setText(str);
				int time = projectList.get(i).getTime();
				mainFrame.getProjectHour().setText(String.valueOf(time));
				mainFrame.revalidate();
				mainFrame.repaint();
				userProjectList.get(i).setProceeding(true);
				mainFrame.getProjectEventImpl().projectTimeControll(time);
				dispose();
			}
		}	
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
