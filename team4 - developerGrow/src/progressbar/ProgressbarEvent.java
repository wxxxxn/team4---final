package progressbar;

import java.util.Timer;
import java.util.TimerTask;

import main.MainFrame;

public class ProgressbarEvent {
	MainFrame mainFrame;
	Timer timeHp = null;
	Timer timeStress = null;
	Timer timeHealth = null;
	private int countHp;
	private int countStress;
	private int countHealth;
	private int hp;
	private int stress;
	private int health;

	public ProgressbarEvent(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void hpbarDecreas(int count, int speed) {
		countHp = 0;
		if (timeHp != null) {
			timeHp.cancel();
		}
		timeHp = new Timer();
		hp = mainFrame.getHpbar().getValue();
		TimerTask hpTask = new TimerTask() {
			@Override
			public void run() {
				countHp++;
				if (hp <= 0) {
					System.out.println("you die");
				} else if (hp > 0) {
					hp--;
				}
				mainFrame.getHpbar().setValue(hp);
			}
		};
		timeHp.scheduleAtFixedRate(hpTask, 0, speed);		
	}
	
	public void hpbarIncrease(int count, int speed) {
		countHp = 0;
		if (timeHp != null) {
			timeHp.cancel();
		}
		timeHp = new Timer();
		hp = mainFrame.getHpbar().getValue();
		TimerTask hpTask = new TimerTask() {
			@Override
			public void run() {
				countHp++;
				if (hp == 0) {
					System.out.println("you die");
				}
				if (hp < 100){
					hp++;
				}
				mainFrame.getHpbar().setValue(hp);
			}
		};
		timeHp.scheduleAtFixedRate(hpTask, 0, speed);		
	}	
	
	public void stressbarDecreas(int count, int speed) {
		countStress = 0;
		if (timeStress != null) {
			timeStress.cancel();
		}
		timeStress = new Timer();
		stress = mainFrame.getStessbar().getValue();
		TimerTask stressTask = new TimerTask() {
			@Override
			public void run() {
				countStress++;
				if (stress == 0) {
					System.out.println("you are happy");
				} else if (stress > 0) {
					stress--;
				}
				mainFrame.getStessbar().setValue(stress);
			}
		};
		timeStress.scheduleAtFixedRate(stressTask, 0, speed);		
	}
	
	public void stressbarIncrease(int count, int speed) {
		countStress = 0;
		if (timeStress != null) {
			timeStress.cancel();
		}
		timeStress = new Timer();
		stress = mainFrame.getStessbar().getValue();
		TimerTask stressTask = new TimerTask() {
			@Override
			public void run() {
				countStress++;
				if (stress < 100) {
					stress++;
				}
				mainFrame.getStessbar().setValue(stress);
			}
		};
		timeStress.scheduleAtFixedRate(stressTask, 0, speed);		
	}		
	
	public void healthbarDecreas(int count, int speed) {
		countHealth = 0;
		if (timeHealth != null) {
			timeHealth.cancel();
		}
		timeHealth = new Timer();
		health = mainFrame.getHealthbar().getValue();
		TimerTask healthTask = new TimerTask() {
			@Override
			public void run() {
				countHealth++;
				if (health == 0) {
					System.out.println("you are ill");
				} else if (health > 0) {
					health--;
				}
				mainFrame.getHealthbar().setValue(health);
			}
		};
		timeHealth.scheduleAtFixedRate(healthTask, 0, speed);		
	}
	
	public void healthbarIncrease(int count, int speed) {
		countHealth = 0;
		if (timeHealth != null) {
			timeHealth.cancel();
		}
		timeHealth = new Timer();
		health = mainFrame.getHealthbar().getValue();
		TimerTask healthTask = new TimerTask() {
			@Override
			public void run() {
				countHealth++;
				if (health < 100) {
					health++;
				}
				mainFrame.getHealthbar().setValue(health);
			}
		};
		timeHealth.scheduleAtFixedRate(healthTask, 0, speed);		
	}	
}