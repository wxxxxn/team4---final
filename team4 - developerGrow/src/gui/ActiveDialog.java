package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import main.CoupangEventImpl;
import main.GameEventImpl;
import main.PlayGameEventImpl;
import main.SleepEventImpl;

public class ActiveDialog extends JDialog {
	private JButton[] btn = new JButton[7];
	private ClassLoader classLoader;
	private GameEventImpl gameEventImpl;
	private SleepEventImpl sleepEventImpl;
	private PlayGameEventImpl playGameEventImpl;
	private CoupangEventImpl coupangEventImpl;
	
	public ActiveDialog(int x, int y, GameEventImpl gameEventImpl, SleepEventImpl sleepEventImpl, PlayGameEventImpl playGameEventImpl, CoupangEventImpl coupangEventImpl) {
		setUndecorated(true);
		setModal(true);
		setBounds(x + 7, y + 30, 1185, 762);
		
		this.gameEventImpl = gameEventImpl;
		this.sleepEventImpl = sleepEventImpl;
		this.playGameEventImpl = playGameEventImpl;
		this.coupangEventImpl = coupangEventImpl;
		
		setBackground(new Color(0, 0, 0, 80));
		setLayout(null);
		
		classLoader = getClass().getClassLoader();
		
		// 상하차(0), 밥먹기, 게임하기, 잠자기, 담배피기, 이력서 작성, 뒤로(6)
		for (int i = 0; i < 7; i++) {
			btn[i] = new JButton(imageIcon(i));
			btn[i].setPressedIcon(imageIconPush(i));
			add(btn[i]);
			btn[i].setBorderPainted(false);
			btn[i].setFocusPainted(false);
			btn[i].setContentAreaFilled(false);
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Object command = e.getSource();
					for (int i = 0; i < 7; i++) {
						if (command == btn[i]) {
							active(i); // 버튼 입력값 -> 작동
						}
					}
					dispose();
				}
			});
		}
		btn[0].setBounds(470, 200, 100, 50);
		btn[1].setBounds(630, 200, 100, 50);
		btn[2].setBounds(400, 300, 100, 50);
		btn[3].setBounds(700, 300, 100, 50);
		btn[4].setBounds(400, 400, 100, 50);
		btn[5].setBounds(700, 400, 100, 50);
		btn[6].setBounds(500, 550, 200, 50);
		
		
		// +8 +30 -16 -38
//		setBounds(108, 130, 1184, 762);
	}
	
	public void showGUI() {
		setVisible(true);
	}
	
	// 추가
	public void active (int num) {
		switch (num) {
			case 0:
				coupangEventImpl.timerController();
				break;
			case 1:
				break;
			case 2:
				playGameEventImpl.timerController();
				break;
			case 3:
				sleepEventImpl.sleepTimer();
				break;
			case 4:
				gameEventImpl.timerController();
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				break;
		}
	}
	public ImageIcon imageIcon (int num) {
		switch (num) {
			case 0:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeCouPang.png"));
			case 1:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeEat.png"));
			case 2:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeGame.png"));
			case 3:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeSleep.png"));
			case 4:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeSmokeing.png"));
			case 5:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeWrite.png"));
			case 6:
				return new ImageIcon(classLoader.getResource("btn_image/closeBtnImage.png"));
			default:
				return null;
		}
	}
	public ImageIcon imageIconPush (int num) {
		switch (num) {
			case 0:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeCouPangPush.png"));
			case 1:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeEatPush.png"));
			case 2:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeGamePush.png"));
			case 3:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeSleepPush.png"));
			case 4:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeSmokeingPush.png"));
			case 5:
				return new ImageIcon(classLoader.getResource("activeBtn_image/activeWritePush.png"));
			case 6:
				return new ImageIcon(classLoader.getResource("btn_image/closeBtnPushImage.png"));
			default:
				return null;
		}
	}
}
