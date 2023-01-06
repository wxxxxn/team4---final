package progressbar;

import java.util.Timer;
import java.util.TimerTask;

import main.MainFrame;

public class ProgressbarEvent {
	MainFrame mainFrame;
	

	public ProgressbarEvent(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}

	public ProgressbarEvent() {
		super();
	}

	Timer time = new Timer();

	public void ProgressBarTime() {
		time.scheduleAtFixedRate(task, 0, 10);
	}

	private boolean bb = true;
	private static int ii = 100;
	TimerTask task = new TimerTask() {
		@Override
		public void run() {
			if (ii == 0) {
				ii = 0;
			}
			for (int i = ii; i >= 0; i--) {
				if (!bb)
					break;
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {}
				mainFrame.getHpbar().setValue(i);
				ii = i;
			}
		}
	};

//   private void showTime() {
//      for(int i = 100; i >= 0; i--) {
//    	  if (!bb) break;
//    	  try {
//			Thread.sleep(1500);
//		} catch (InterruptedException e) {		}
//         mainFrame.getHpbar().setValue(i);
//         
//         
//      }
//   }

}
//      for (int i = 1; i < 100; i++) {
//         ProgressBarTime();