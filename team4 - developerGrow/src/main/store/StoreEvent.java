package main.store;

import custom_panel.SkillPanel;

public interface StoreEvent {
	
	void inputSkillInfo(int index, SkillPanel skill);
	void updateLevelToDB(SkillPanel[] skills);
}
