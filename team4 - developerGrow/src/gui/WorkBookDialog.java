package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MainFrame;

public class WorkBookDialog extends JDialog {
	public WorkBookDialog (int num) {
		setBounds(300, 300, 750, 400);
		setUndecorated(true);
		setModal(true);
		setLayout(null);
		
		JPanel pnlU = new JPanel();
		pnlU.setBounds(0, 0, 750, 300);
		add(pnlU);
		
		JLabel lbl = new JLabel();
		lbl.setIcon(new ImageIcon(WorkBookDialog.class.getResource("/workBook/q" + String.valueOf(num) + ".png")));
		pnlU.add(lbl);
		
		JPanel pnlD = new JPanel();
		pnlD.setLayout(null);
		pnlD.setBounds(0, 300, 750, 100);
		add(pnlD);
		
		JTextField inputTxt = new JTextField();
		inputTxt.setBounds(320, 0, 70, 40);
		pnlD.add(inputTxt);
		
		JButton btn = new JButton("확인");
		btn.setBounds(400, 0, 70, 40);
		pnlD.add(btn);
		
		JLabel lbl_ = new JLabel("답을 입력하세요. ");
		lbl_.setBounds(480, 0, 250, 40);
		pnlD.add(lbl_);

		int[] list = {1, 5, 4, 3, 3, 3, 4, 3, 2, 2, 1, 4, 4, 3, 3, 3};
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (list[num - 1] == Integer.valueOf(inputTxt.getText())) {
						lbl_.setText("답: " + list[num - 1] + " / 정답입니다. ");
					} else {
						lbl_.setText("답: " + list[num - 1] + " / 오답입니다. ");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btn_ = new JButton("닫기");
		btn_.setBounds(600, 0, 70, 40);
		pnlD.add(btn_);
		
		btn_.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	public void showGUI() {
		setVisible(true);
	}
}
