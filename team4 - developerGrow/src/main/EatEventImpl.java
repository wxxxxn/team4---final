package main;

import java.util.Timer;
import java.util.TimerTask;

public class EatEventImpl {
	MainFrame mainFrame;

	public EatEventImpl(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}
	
	public EatEventImpl() {
	      super();
	   }
	
	Timer time = new Timer();

	   private int seconds = 0;

	   @Override
	   public void timerController() {
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
	         mainFrame.getEatimg().setVisible(true);
	      } else if (seconds >= 5){
	         mainFrame.getEatimg().setVisible(false);
	         seconds = 0;
	        
	      }

	   }
	
}
