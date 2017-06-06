/**
 * 
 */
package hu.guci.froccsfm.pi;

import java.awt.image.BufferedImage;
import java.io.IOException;

import de.pi3g.pi.oled.Font;
import de.pi3g.pi.oled.OLEDDisplay;
import hu.areus.terminus.base.BaseClass;

/**
 * @author adam.katona
 *
 */
public class EmulatedOledDisplay extends BaseClass implements OLEDDisplay 
{

	/* (non-Javadoc)
	 * @see de.pi3g.pi.oled.OLEDDisplay#clear()
	 */
	@Override
	public void clear() {
		// 

	}

	/* (non-Javadoc)
	 * @see de.pi3g.pi.oled.OLEDDisplay#getWidth()
	 */
	@Override
	public int getWidth() {
		// 
		return 0;
	}

	/* (non-Javadoc)
	 * @see de.pi3g.pi.oled.OLEDDisplay#getHeight()
	 */
	@Override
	public int getHeight() {
		// 
		return 0;
	}

	/* (non-Javadoc)
	 * @see de.pi3g.pi.oled.OLEDDisplay#setPixel(int, int, boolean)
	 */
	@Override
	public void setPixel(int x, int y, boolean on) {
		// 

	}

	/* (non-Javadoc)
	 * @see de.pi3g.pi.oled.OLEDDisplay#drawChar(char, de.pi3g.pi.oled.Font, int, int, boolean)
	 */
	@Override
	public void drawChar(char c, Font font, int x, int y, boolean on) {
		// 

	}

	/* (non-Javadoc)
	 * @see de.pi3g.pi.oled.OLEDDisplay#drawString(java.lang.String, de.pi3g.pi.oled.Font, int, int, boolean)
	 */
	@Override
	public void drawString(String string, Font font, int x, int y, boolean on) {
		// 

	}

	/* (non-Javadoc)
	 * @see de.pi3g.pi.oled.OLEDDisplay#drawStringCentered(java.lang.String, de.pi3g.pi.oled.Font, int, boolean)
	 */
	@Override
	public void drawStringCentered(String string, Font font, int y, boolean on) {
		// 

	}

	/* (non-Javadoc)
	 * @see de.pi3g.pi.oled.OLEDDisplay#clearRect(int, int, int, int, boolean)
	 */
	@Override
	public void clearRect(int x, int y, int width, int height, boolean on) {
		// 

	}

	/* (non-Javadoc)
	 * @see de.pi3g.pi.oled.OLEDDisplay#drawImage(java.awt.image.BufferedImage, int, int)
	 */
	@Override
	public void drawImage(BufferedImage image, int x, int y) {
		// 

	}

	/* (non-Javadoc)
	 * @see de.pi3g.pi.oled.OLEDDisplay#update()
	 */
	@Override
	public void update() throws IOException {
		// 

	}

}
