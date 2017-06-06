/**
*	Logger class
*   @author adam.katona
*/

var log = new Logger();

function Logger()
{
	/**
	 * Debug log
	 */
	this.debug = function(message, exception)
	{
		this.log("DEBUG", message, exception);
	};

	/**
	 * Info log
	 */
	this.info = function(message, exception)
	{
		this.log("INFO", message, exception);
	};
	
	/**
	 * Warning log
	 */
	this.warn = function(message, exception)
	{
		this.log("WARN", message, exception);
	};
	
	/**
	 * Error log
	 */
	this.error = function(message, exception)
	{
		this.log("ERROR", message, exception);
	};
	
	/**
	 * Do the logging dance.
	 */
	this.log = function(level, message, exception)
	{
		//--- Use console div
		var consoleDiv = jQuery("#consoleLog");
		
		if (consoleDiv && consoleDiv[0])
		{
			consoleDiv.append("<p class=\"" + level + "\">" + level + ": " + message + "</p>\n");
			consoleDiv[0].scrollTop = consoleDiv[0].scrollHeight;
		}
		
		//--- Use firebug if available
		try	
		{
			if (typeof console != 'undefined')
			{
				//--- De bena...
				switch (level)
				{
					case "DEBUG":	console.debug(message); break;
					case "INFO":	console.info(message); break;
					case "WARN":	console.warn(message); break;
					case "ERROR":	console.error(message); break;
					default: console.log(message); break;
				}
			}
		}
		catch (ex)
		{
			
		}
	};
}
