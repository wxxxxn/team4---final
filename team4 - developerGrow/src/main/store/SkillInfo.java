package main.store;

import java.awt.Image;
import java.sql.Blob;

public class SkillInfo {
	
	private int skillId;
	private String skillName;
	private int price;
	private String description;
	private Image skillImage;
	
	public SkillInfo(int skillId, String skillName, int price, String description, Image skillImage) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.price = price;
		this.description = description;
		this.skillImage = skillImage;
	}

	public String getSkillName() {
		return skillName;
	}

	public int getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}

	public Image getSkillImage() {
		return skillImage;
	}
}
