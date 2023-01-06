package main.store;

import java.awt.Image;
import java.sql.Blob;

public class SkillInfo {
	
	private int skillLevel;
	private String skillName;
	private int price;
	private String description;
	private Image skillImage;
	
	public SkillInfo(int skillLevel, String skillName, int price, String description, Image skillImage) {
		super();
		this.skillLevel = skillLevel;
		this.skillName = skillName;
		this.price = price;
		this.description = description;
		this.skillImage = skillImage;
	}
	
	public int getSkillLevel() {
		return skillLevel;
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
