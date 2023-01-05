package main;

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

   public GameEventImpl() {
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
         mainFrame.getCharacter().setVisible(false);
         mainFrame.getSmokecharacter().setVisible(true);
      } else if (seconds >= 5){
         mainFrame.getCharacter().setVisible(true);
         mainFrame.getSmokecharacter().setVisible(false);
         seconds = 0;
      }

   }

}