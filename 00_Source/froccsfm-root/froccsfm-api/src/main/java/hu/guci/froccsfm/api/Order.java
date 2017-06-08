/**
 * 
 */
package hu.guci.froccsfm.api;

/**
 * Order details.
 * @author adam.katona
 *
 */
public class Order 
{
	private long id;
	private double wineAmount;
	private double sodaAmount;
	private int no;
	private String created;
	private boolean isFulfilled;
	private String token;
	private String name;
	
	/**
	 * @return the wineAmount
	 */
	public double getWineAmount() {
		return wineAmount;
	}
	/**
	 * @param wineAmount the wineAmount to set
	 */
	public void setWineAmount(double wineAmount) {
		this.wineAmount = wineAmount;
	}
	/**
	 * @return the sodaAmount
	 */
	public double getSodaAmount() {
		return sodaAmount;
	}
	/**
	 * @param sodaAmount the sodaAmount to set
	 */
	public void setSodaAmount(double sodaAmount) {
		this.sodaAmount = sodaAmount;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}
	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}
	/**
	 * @return the isFulfilled
	 */
	public boolean isFulfilled() {
		return isFulfilled;
	}
	/**
	 * @param isFulfilled the isFulfilled to set
	 */
	public void setFulfilled(boolean isFulfilled) {
		this.isFulfilled = isFulfilled;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
