package main.project;

import java.util.Timer;
import java.util.TimerTask;

import main.MainFrame;

public class ProjectEventImpl implements ProjectEvent {
	
	private MainFrame mainFrame;
	private int minutes;
	private int hours;
	private double rate;
	
	public ProjectEventImpl(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void timeController(int time) {
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
		countdown.scheduleAtFixedRate(timerTask, 0, 250);
	}
	
	private void updateTime(int minutes, int hours, double rate) {
		mainFrame.getProjectHour().setText(String.format("%02d", hours));
		mainFrame.getProjectMinute().setText(String.format("%02d", minutes));
		mainFrame.getNowRatinglbl().setText(String.format("%.02f", rate));
		mainFrame.revalidate();
		mainFrame.repaint();		
    }
	
//	private void saveProjectData() {
//		
//	}
}
