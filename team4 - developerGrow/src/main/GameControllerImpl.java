package main;

import java.util.Timer;
import java.util.TimerTask;

public class GameControllerImpl implements GameController{

	private MainFrame mainFrame;
	
	public GameControllerImpl(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	private long minutes = 0;
	
	@Override
	public void timeController() {
		
		Timer currentTime = new Timer();
		currentTime.scheduleAtFixedRate(timerTask, 250, 250);
	}

	private TimerTask timerTask = new TimerTask() {
		
		@Override
		public void run() {
			
			if (minutes == 1440) {
				minutes = 0;
				updateDate();
				updateTime(minutes);
			} else {
				minutes++;
				updateTime(minutes);
			}
		}
	};
	
	private void updateTime(long minutes) {
		
		mainFrame.getHourlbl().setText(String.format("%02d", minutes / 60));
		mainFrame.getMinutelbl().setText(String.format("%02d", minutes % 60));
    }
	
	private void updateDate() {
		
		int day = 0;
		
		day++;
		mainFrame.getDatelbl().setText(String.format("%02d", day) + "일차");
	}
}
