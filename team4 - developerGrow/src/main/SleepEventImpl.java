package main;

import java.util.Timer;
import java.util.TimerTask;

public class SleepEventImpl implements SleepEvent {
	MainFrame mainFrame;

	public SleepEventImpl(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}

	public SleepEventImpl() {
		super();
	}

	Timer time = new Timer();

	private int seconds = 0;

	@Override
	public void sleepTimer() {
		time.scheduleAtFixedRate(task, 0, 5000);
	}

	TimerTask task = new TimerTask() {
		@Override
		public void run() {
			showTime(seconds);
			seconds++;
		}
	};

	private void showTime(int second) {
		if (seconds == 0) {
			mainFrame.getSleeplbl().setVisible(true);
			mainFrame.getBedlbl().setVisible(false);
		} else if (seconds >= 5) {
			mainFrame.getSleeplbl().setVisible(false);
			mainFrame.getBedlbl().setVisible(true);
			seconds = 0;
		}
	}
}
