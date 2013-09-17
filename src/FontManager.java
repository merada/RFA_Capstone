/**
 * FontManager class to load and initialize a custom font.
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.09.17
 */

import java.awt.Font;
import java.io.FileInputStream;

public class FontManager {
	private Font font;
	private String fontFile = "./font/andyb.ttf";
	
	public FontManager() {
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(fontFile));
			font = font.deriveFont(28f);
		} catch (Exception e) {
			System.out.println("Error: fontFile not found.\n" +
					"       " + e.getMessage());
			System.exit(0);
		}
	}
	
	public Font getFont() {
		return font;
	}
}
