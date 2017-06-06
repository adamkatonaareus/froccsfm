/**
 * 
 */
package hu.guci.froccsfm.api;

/**
 * Response class for all services.
 * @author adam.katona
 *
 */
public class Response 
{
	private boolean success;
	private int orderNo;
	private String displayMessage;
	
	/**
	 * Default constructor
	 */
	public Response()
	{
		//--- Default constructor.
	}
	
	/**
	 * Constructor with success flag.
	 * @param success
	 */
	public Response(boolean success)
	{
		this.success = success;
	}
	
	/**
	 * Constructor with success flag.
	 * @param success
	 */
	public Response(boolean success, int orderNo)
	{
		this.success = success;
		this.orderNo = orderNo;
	}
	
	/**
	 * Constructor.
	 * @param success
	 * @param displayMessage
	 */
	public Response(boolean success, String displayMessage)
	{
		this.success = success;
		this.displayMessage = displayMessage;
	}
	
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the orderNo
	 */
	public int getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the displayMessage
	 */
	public String getDisplayMessage() {
		return displayMessage;
	}
	/**
	 * @param displayMessage the displayMessage to set
	 */
	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}
	
	
	/**
	 * Return a success response.
	 * @return
	 */
	public static Response success()
	{
		return new Response(true);
	}
	
	/**
	 * Return a success response.
	 * @return
	 */
	public static Response success(int orderNo)
	{
		return new Response(true, orderNo);
	}
	
	/**
	 * Return a success response.
	 * @return
	 */
	public static Response success(String displayMessage)
	{
		return new Response(true, displayMessage);
	}	
	
	/**
	 * Return a failure message.
	 * @param displayMessage
	 * @return
	 */
	public static Response failure(String displayMessage)
	{
		return new Response(false, displayMessage);
	}
}
