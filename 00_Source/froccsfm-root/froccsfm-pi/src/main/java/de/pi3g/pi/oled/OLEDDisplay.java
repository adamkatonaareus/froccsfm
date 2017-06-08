/**
 * 
 */
package de.pi3g.pi.oled;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author adam.katona
 *
 */
public interface OLEDDisplay 
{
	public static final int LINE_HEIGHT = 10;
	public static final int MARGIN_TOP = 5;
	
	void clear();

	int getWidth();

	int getHeight();

	void setPixel(int x, int y, boolean on);

	void drawChar(char c, Font font, int x, int y, boolean on);

	void drawString(String string, Font font, int x, int y, boolean on);

	void drawStringCentered(String string, Font font, int y, boolean on);

	void clearRect(int x, int y, int width, int height, boolean on);

	/**
	 * draws the given image over the current image buffer. The image
	 * is automatically converted to a binary image (if it not already
	 * is).
	 * <p/>
	 * Note that the current buffer is not cleared before, so if you
	 * want the image to completely overwrite the current display
	 * content you need to call clear() before.
	 *
	 * @param image
	 * @param x
	 * @param y
	 */
	void drawImage(BufferedImage image, int x, int y);

	/**
	 * sends the current buffer to the display
	 * @throws IOException
	 */
	void update() throws IOException;

}