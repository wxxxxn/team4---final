package main.store;

import java.util.List;

import javax.swing.ImageIcon;

import custom_panel.skillPanel;

public class StoreEventImpl implements StoreEvent{
	
	private SkillInfos skillInfos = new SkillInfos();
	private List<SkillInfo> skillLists = skillInfos.getSkillInfo();
	
	@Override
	public void inputSkillInfo(int index, skillPanel skill) {
		
		SkillInfo skillInfo = skillLists.get(index);
		
		skill.getImageLabel().setIcon(new ImageIcon(skillInfo.getSkillImage()));
		skill.getSkillNameLabel().setText(skillInfo.getSkillName());
		skill.getPriceLabel().setText(String.valueOf(skillInfo.getPrice()) + "개");
		skill.getSkillDescriptionLabel().setText(skillInfo.getDescription());
	}
}
