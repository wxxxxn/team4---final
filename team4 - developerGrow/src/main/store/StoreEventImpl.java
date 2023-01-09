package main.store;

import java.util.List;

import javax.swing.ImageIcon;

import database.controllDB.UpdateDB;
import database.dblist.SkillList;
import database.dblist.UserSkill;
import main.MainFrame;

public class StoreEventImpl implements StoreEvent {

	private MainFrame mainFrame;
	private List<SkillList> skillList;
	private List<UserSkill> userSkillList;

	public StoreEventImpl(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		skillList = mainFrame.getSkillList();
		userSkillList = mainFrame.getUserSkillList();
	}

	@Override
	public void inputSkillInfo(int index, SkillPanel skill) {

		skill.getLevelLabel().setText("LV." + userSkillList.get(index).getSkillLevel());
		skill.getImageLabel().setIcon(new ImageIcon(skillList.get(index).getImage()));
		skill.getSkillNameLabel().setText(skillList.get(index).getSkillName());
		skill.getPriceLabel().setText(skillList.get(index).getPrice() + "개");
		skill.getSkillDescriptionLabel().setText(skillList.get(index).getDescription());
		skill.setLevel(userSkillList.get(index).getSkillLevel());
	}

	@Override
	public void updateLevelToDB() {

		new UpdateDB().updateUserSkill(userSkillList);
	}
}
