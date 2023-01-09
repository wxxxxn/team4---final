package main.store;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import custom_panel.SkillPanel;
import database.controllDB.UpdateDB;
import database.dblist.SkillList;
import database.dblist.UserSkill;
import database.util.ConnectionProvider;
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
