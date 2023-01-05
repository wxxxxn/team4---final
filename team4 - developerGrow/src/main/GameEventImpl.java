package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Timer;
import java.util.TimerTask;

public class GameEventImpl implements GameEvent {
	// 버튼클릭시 라벨 기존캐릭터 라벨이 덮어씌우기
	// 담배피는 캐릭터 라벨이 추가
	// 일정 시간을 줘야함
	// 일정 시간이후 담배가 사라지게
	MainFrame mainFrame;
	
	public GameEventImpl(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}

	@Override
	public void timerController() {

		Timer time = new Timer();
		TimerTask task = new TimerTask() {
			int count = 0;
			@Override
			public void run() {
				if(count < 30) {
					System.out.println("s");
				}
			}
		};

		time.schedule(task, 30000);
		
		
	}
	
	
}