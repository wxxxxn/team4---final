package main.minigame.different;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

import different.ToryMain.CustomMouseAdapter;

public class Hide extends JFrame {

	final Hidee center = new Hidee("");

	// 틀린그림부분의 좌표값 배열
	static int[] imageX = { 240, 500, 368, 568, 430, 220, 580 };
	static int[] imageY = { 408, 350, 143, 340, 405, 350, 520 };
	// 틀린부분의 범위 기본 설정값
	static final int range = 40;

	/**
	 * 기본 프레임 설정
	 * 
	 * @param string
	 */
	public Hide(String string) {
		super(string);
		center.setBounds(10, 36, 672, 915);
		// imga 이미지가 저장된 JPanel a 객체에 감지기 설정
		CustomMouseAdapter cma = new CustomMouseAdapter();
		center.addMouseListener(cma);
		getContentPane().setLayout(null);

		// 프레임에 판넬a,b부착, 각각 위치설정
		getContentPane().add(center);
		center.setLayout(null);

		JLabel leftimg = new JLabel("");
		ClassLoader classLoader = getClass().getClassLoader();
		URL hiding = classLoader.getResource("images.dif_img/1234.PNG");
		leftimg.setIcon(new ImageIcon(hiding));
		leftimg.setBounds(29, 22, 631, 883);
		center.add(leftimg);

		// 프레임 온,오프를 위한 기본설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 0, 700, 1000);
		setVisible(true);
	}// ThigauEEx()

	/**
	 * 배열 순번과 포인트값(x,y좌표)를 갖고 틀린부분을 마우스로 클릭 시 해당하는 범위좌표를 반환한다.
	 * 
	 * @param index
	 * @param p
	 * @return
	 */
	public boolean isRangeof(int index, Point p) {
		// 포인트 X좌표를 입력받아 pointX로 저장
		int pointX = p.x;
		// 포인트 Y좌표를 입력받아 pointX로 저장
		int pointY = p.y;
		// 배열순번과 해당좌표를 입력해 반환
		return (pointX >= imageX[index] - range) && (pointX <= imageX[index] + range)
				&& (pointY >= imageY[index] - range) && (pointY <= imageY[index] + range);
	}// isRangeof()

	class CustomMouseAdapter extends MouseAdapter {
		public void mouseReleased(MouseEvent e) {
			Point p = e.getPoint();
			if (isRangeof(0, p)) {
				Hidee.f1 = true; //
				center.repaint();
//				right.repaint();

			} else if (isRangeof(1, p)) {
				Hidee.f2 = true;
				center.repaint();
//				right.repaint();

			} else if (isRangeof(2, p)) {
				Hidee.f3 = true;
				center.repaint();
//				right.repaint();

			} else if (isRangeof(3, p)) {
				Hidee.f4 = true;
				center.repaint();
//				right.repaint();

			} else if (isRangeof(4, p)) {
				Hidee.f5 = true;
				center.repaint();
//				right.repaint();
			} else if (isRangeof(5, p)) {
				Hidee.f6 = true;
				center.repaint();
			} else if (isRangeof(6, p)) {
				Hidee.f7 = true;
				center.repaint();

//			} else if (p.x >= 40 && p.x <= 100 && p.y >= 450 && p.y <= 500) {
//				JOptionPane.showMessageDialog(null, "거 없다");
//				center.repaint();
//				right.repaint();
//
//			} else if (p.x >= 250 && p.x <= 500 && p.y >= 400 && p.y <= 550) {
//				JOptionPane.showMessageDialog(null, "틀맀따 갈기지마라");
//				left.repaint();
////				right.repaint();
			}

			if (Hidee.f1 == true && Hidee.f2 == true && Hidee.f3 == true && Hidee.f4 == true && Hidee.f5 == true && Hidee.f6 == true && Hidee.f7 == true) {
				JOptionPane.showMessageDialog(null, "축하합니다.");
				Hidee.f1 = false;
				Hidee.f2 = false;
				Hidee.f3 = false;
				Hidee.f4 = false;
				Hidee.f5 = false;
				Hidee.f6 = false;
				Hidee.f7 = false;
				center.repaint();
//				right.repaint();
			}
		}
	}

	public static void main(String[] args) {
		new Hide("숨은그림찾기");
	}// main
}// end