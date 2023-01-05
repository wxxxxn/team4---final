package main.store;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import dbutil.ConnectionProvider;

public class SkillInfos {

	public List<SkillInfo> getSkillInfo() {

		String sql = "SELECT * FROM team4.skilllist";
		List<SkillInfo> skillInfos = new ArrayList<>();

		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			try (ResultSet rs = pstmt.executeQuery()) {
				
				while (rs.next()) {
					int skillId = rs.getInt("skillid");
					String skillName = rs.getString("skillname");
					int price = rs.getInt("price");
					String description = rs.getString("description");
					
//					String encode = rs.getString("image");
//					byte[] decode = decodeBase64(encode);
					byte[] encode = rs.getBytes("image");
					ByteArrayInputStream bais = new ByteArrayInputStream(encode);
					BufferedImage image = ImageIO.read(bais);
					
					skillInfos.add(new SkillInfo(skillId, skillName, price, description, image));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return skillInfos;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static byte[] decodeBase64(String encode) {
		return Base64.getDecoder().decode(encode);
	}
}
