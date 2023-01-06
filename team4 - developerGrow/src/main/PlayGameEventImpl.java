package main;

import java.util.Timer;
import java.util.TimerTask;

public class PlayGameEventImpl implements PlayGameEvent{

	MainFrame mainFrame;
	
	public PlayGameEventImpl(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}
	
	public PlayGameEventImpl() {
		super();
	}
	
	Timer time = new Timer();
	
	 private int seconds = 0;
	
	@Override
	public void timerController() {
		// TODO Auto-generated method stub
		time.scheduleAtFixedRate(task, 0, 5000);
		
	}
	
	TimerTask task = new TimerTask() {
		@Override
		public void run() {
			showTime(seconds);
			seconds++;
		}
	};
	
	private void showTime(int seconds) {
		if (seconds == 0) {
			mainFrame.getGameImg().setVisible(true);
		} else if (seconds >= 5) {
			mainFrame.getGameImg().setVisible(false);
			seconds = 0;
		}
	}
	
}