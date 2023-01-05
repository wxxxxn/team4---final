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
			
			minutes++;
			updateTime(minutes);
		}
	};
	
	private void updateTime(long minutes) {
		
		mainFrame.getHourlbl().setText(String.format("%02d", minutes / 60));
		mainFrame.getMinutelbl().setText(String.format("%02d", minutes % 60));
		
		mainFrame.getHourlbl().revalidate();
		mainFrame.getHourlbl().repaint();
		mainFrame.getMinutelbl().revalidate();
		mainFrame.getMinutelbl().repaint();
    }
}
