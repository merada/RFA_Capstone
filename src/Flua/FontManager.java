package Flua;
/**
 * FontManager class to load and initialize a custom font
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */

import java.awt.Font;
import java.io.FileInputStream;

public class FontManager {
	/**
	 * Font for the GUI
	 */
	private Font font;
	
	/**
	 * Path pointing to TrueType Font file from which to load GUI font
	 */
	private String fontFile = "./font/andyb.ttf";
	
	/**
	 * Constructor initializing GUI font to font specified in fontFile
	 */
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
	
	/**
	 * Accessor for GUI font
	 * @return Derived Font for the GUI
	 */
	public Font getFont() {
		return font;
	}
}
