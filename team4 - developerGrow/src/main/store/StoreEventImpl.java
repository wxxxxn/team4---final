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

import custom_panel.SkillPanel;
import dbutil.ConnectionProvider;

public class StoreEventImpl implements StoreEvent{
	
	private SkillInfos skillInfos = new SkillInfos();
	private List<SkillInfo> skillLists = skillInfos.getSkillInfo();

	@Override
	public void inputSkillInfo(int index, SkillPanel skill) {
		
		SkillInfo skillInfo = skillLists.get(index);
		
		skill.setLevel(skillInfo.getSkillLevel());
		skill.getLevelLabel().setText("LV." + skillInfo.getSkillLevel());
		skill.getImageLabel().setIcon(new ImageIcon(skillInfo.getSkillImage()));
		skill.getSkillNameLabel().setText(skillInfo.getSkillName());
		skill.getPriceLabel().setText(String.valueOf(skillInfo.getPrice()) + "개");
		skill.getSkillDescriptionLabel().setText(skillInfo.getDescription());
	}

	@Override
	public void updateLevelToDB(SkillPanel[] skills) {
		
		String sql = "UPDATE skilllist SET skilllevel = ? WHERE skillname = ?";

		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			for (SkillPanel skillPanel : skills) {
				String skillName = skillPanel.getSkillNameLabel().getText();
				System.out.println(skillPanel.getLevel());
				int level = skillPanel.getLevel();
				
				pstmt.setInt(1, level);
				pstmt.setString(2, skillName);
				
				pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
