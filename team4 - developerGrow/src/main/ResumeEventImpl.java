package main;

import java.util.Timer;
import java.util.TimerTask;

public class ResumeEventImpl {
	MainFrame mainFrame;

	public ResumeEventImpl(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}
	
	public ResumeEventImpl() {
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
	         mainFrame.getResumeimg().setVisible(true);
	      } else if (seconds >= 5){
	         mainFrame.getResumeimg().setVisible(false);
	         seconds = 0;
	        
	      }

	   }
}
