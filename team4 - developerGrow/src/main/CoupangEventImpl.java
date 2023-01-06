package main;

import java.util.Timer;
import java.util.TimerTask;

public class CoupangEventImpl implements CoupangEvent {
	MainFrame mainFrame;

	public CoupangEventImpl(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}
	
	public CoupangEventImpl() {
	      super();
	   }
	
	Timer time = new Timer();

	   private int seconds = 0;

	   @Override
	   public void timerController() {
	      time.scheduleAtFixedRate(task, 0, 100);
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
	         mainFrame.getCoupangimg().setVisible(true);
	      } else if (seconds >= 5){
//	         mainFrame.getCoupangimg().setVisible(false);
	         mainFrame.remove(mainFrame.getCoupangimg());
	         seconds = 0;
	        
	      }
	      mainFrame.revalidate();
	      mainFrame.repaint();

	   }
	
}
