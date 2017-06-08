/**
 * 
 */
package hu.guci.froccsfm.api;

import org.apache.commons.lang3.StringUtils;

/**
 * Froccs name identifier.
 * @author adam.katona
 *
 */
public class Names 
{
	private static int[] wine = new int[] {2, 1, 1, 4, 3, 2, 1, 9, 7, 6, 5, 4, 1};
	private static int[] soda = new int[] {1, 1, 2, 1, 2, 3, 4, 1, 3, 4, 5, 6, 9};
	private static String[] name = new String[] {"nagyfröccs", "kisfröccs", "hosszúlépés", "háziúr", "házmester",
			"viceházmester", "sportfröccs", "Krúdy-fröccs", "Avasi fröccs", "polgármester", "maflás", "alpolgármester", "sóherfröccs"};

	private Names()
	{
		//--- Default constructor.
	}
	
	/**
	 * Get name of the froccs.
	 * @param wineAmound
	 * @param sodaAmound
	 * @return
	 */
	public static String getName(double wineAmount, double sodaAmount)
	{
		long wineAmount2 = Math.round(wineAmount);
		long sodaAmount2 = Math.round(sodaAmount);
		
		for(int i=0; i<wine.length; i++)
		{
			if (wine[i] == wineAmount2 && soda[i] == sodaAmount2)
			{
				return name[i];
			}
		}
		
		return "";
	}
	
	/**
	 * Return displayable name.
	 * @param wineAmount
	 * @param sodaAmount
	 * @return
	 */
	public static String getNameForDisplay(double wineAmount, double sodaAmount)
	{
		return StringUtils.stripAccents(getName(wineAmount, sodaAmount)).toUpperCase();
	}
}
