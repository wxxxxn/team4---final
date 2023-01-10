package progressbar;

import java.util.Timer;
import java.util.TimerTask;

import gui.DeathDialog;
import main.MainFrame;

public class ProgressbarEvent {
	
	MainFrame mainFrame;
	Timer timeHp = null;
	Timer timeStress = null;
	Timer timeHealth = null;
	
	private int hp;
	private int stress;
	private int health;

	public ProgressbarEvent(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public void controllPB_default() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
				
		int index = -1;
		int project = 0;
		
		for (int i = 0; i < mainFrame.getUserProjectList().size(); i++) {
			if (mainFrame.getUserProjectList().get(i).isProceeding() && !mainFrame.getUserProjectList().get(i).isComplete()) {
				index =  i;
			}
		}
		if (index != -1) {
			project = mainFrame.getUserProjectList().get(index).getProjectId();
		}
		
		int speedHp = 1000 + (level *1000) + (energydrink * 50) - (project * 500);
		int speedStress = 250 + (level * 1000) + (elecciga * 50) - (project * 500);
		int speedHealth = 500 + (level * 1000) + (bed * 50) - (project * 500);
		
		hpbarDecreas(speedHp);
		stressbarIncrease(speedStress);
		healthbarDecreas(speedHealth);
	}
	
	public void controllPB_ciga() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
				
		int index = -1;
		int project = 0;
		
		for (int i = 0; i < mainFrame.getUserProjectList().size(); i++) {
			if (mainFrame.getUserProjectList().get(i).isProceeding() && !mainFrame.getUserProjectList().get(i).isComplete()) {
				index =  i;
			}
		}
		if (index != -1) {
			project = mainFrame.getUserProjectList().get(index).getProjectId();
		}
		
		int speedHp = 1000 + (level *1000) + (energydrink * 50) - (project * 500) - 500;
		int speedStress = (3000 + (250 - (level * 500) - (elecciga * 100) + (project * 500)));
		int speedHealth = 500 + (level * 1000) + (bed * 50) - (project * 500) - 500;;
		
		hpbarDecreas(speedHp);
		stressbarDecreas(speedStress);
		healthbarDecreas(speedHealth);
	}
	
	public void controllPB_coupang() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
						
		int speedHp = 10000 + (level *1000) + (energydrink * 50);
		int speedStress = 2500 + (level * 1000) + (elecciga * 50);
		int speedHealth = 5000 + (level * 1000) + (bed * 50);
		
		hpbarDecreas(speedHp);
		stressbarIncrease(speedStress);
		healthbarDecreas(speedHealth);
	}
	
	public void controllPB_game() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
					
		int speedHp = 1500 + (level *1000) + (energydrink * 50);
		int speedStress = (3000 + (250 - (level * 1000) - (elecciga * 50)))/3;
		int speedHealth = 1000 + (level * 1000) + (bed * 50);
		
		hpbarDecreas(speedHp);
		stressbarDecreas(speedStress);
		healthbarDecreas(speedHealth);
	}
	
	public void controllPB_sleep() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
					
		int speedHp = 1500 + (level *1000) + (energydrink * 50);
		int speedStress = (3000 + (250 - (level * 1000) - (elecciga * 50)))/3;
		int speedHealth = 5000 - ((level * 500) + (bed * 800));
		
		hpbarIncrease(speedHp);
		stressbarDecreas(speedStress);
		healthbarIncrease(speedHealth);
	}
	
	public void controllPB_eat() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
					
		int speedHp = 1500 + (level *1000) + (energydrink * 50);
		int speedStress = (3000 + (250 - (level * 1000) - (elecciga * 50)))/3;
		int speedHealth = 5000 - ((level * 500) + (bed * 800));
		
		hpbarIncrease(speedHp);
		stressbarDecreas(speedStress);
		healthbarIncrease(speedHealth);
	}
	
	public void controllPB_resume() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
						
		int speedHp = 10000 + (level *1000) + (energydrink * 50);
		int speedStress = 2500 + (level * 1000) + (elecciga * 50);
		int speedHealth = 5000 + (level * 1000) + (bed * 50);
		
		hpbarDecreas(speedHp);
		stressbarIncrease(speedStress);
		healthbarDecreas(speedHealth);
	}
	

	private void hpbarDecreas(int speed) {
		if (timeHp != null) {
			timeHp.cancel();
		}
		timeHp = new Timer();
		hp = mainFrame.getHpbar().getValue();
		TimerTask hpTask = new TimerTask() {
			@Override
			public void run() {
				if (hp <= 0) {
					System.out.println("you die");
					DeathDialog deathDialog = new DeathDialog(mainFrame.getX(), mainFrame.getY());
					deathDialog.showGUI();
				} else if (hp > 0) {
					hp--;
				}
				mainFrame.getHpbar().setValue(hp);
			}
		};
		timeHp.scheduleAtFixedRate(hpTask, 0, speed);		
	}
	
	private void hpbarIncrease(int speed) {
		if (timeHp != null) {
			timeHp.cancel();
		}
		timeHp = new Timer();
		hp = mainFrame.getHpbar().getValue();
		TimerTask hpTask = new TimerTask() {
			@Override
			public void run() {
				if (hp == 0) {
					System.out.println("you die");
					DeathDialog deathDialog = new DeathDialog(mainFrame.getX(), mainFrame.getY());
					deathDialog.showGUI();
				}
				if (hp < 100){
					hp++;
				}
				mainFrame.getHpbar().setValue(hp);
			}
		};
		timeHp.scheduleAtFixedRate(hpTask, 0, speed);		
	}	
	
	private void stressbarDecreas(int speed) {
		if (timeStress != null) {
			timeStress.cancel();
		}
		timeStress = new Timer();
		stress = mainFrame.getStessbar().getValue();
		TimerTask stressTask = new TimerTask() {
			@Override
			public void run() {
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
	
	private void stressbarIncrease(int speed) {
		if (timeStress != null) {
			timeStress.cancel();
		}
		timeStress = new Timer();
		stress = mainFrame.getStessbar().getValue();
		TimerTask stressTask = new TimerTask() {
			@Override
			public void run() {
				if (stress < 100) {
					stress++;
				}
				mainFrame.getStessbar().setValue(stress);
			}
		};
		timeStress.scheduleAtFixedRate(stressTask, 0, speed);		
	}		
	
	private void healthbarDecreas(int speed) {
		if (timeHealth != null) {
			timeHealth.cancel();
		}
		timeHealth = new Timer();
		health = mainFrame.getHealthbar().getValue();
		TimerTask healthTask = new TimerTask() {
			@Override
			public void run() {
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
	
	private void healthbarIncrease(int speed) {
		if (timeHealth != null) {
			timeHealth.cancel();
		}
		timeHealth = new Timer();
		health = mainFrame.getHealthbar().getValue();
		TimerTask healthTask = new TimerTask() {
			@Override
			public void run() {
				if (health < 100) {
					health++;
				}
				mainFrame.getHealthbar().setValue(health);
			}
		};
		timeHealth.scheduleAtFixedRate(healthTask, 0, speed);		
	}	
}