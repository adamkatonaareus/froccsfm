/**
 * 
 */
package hu.guci.froccsfm.pi.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import hu.areus.terminus.base.BaseClass;
import hu.guci.froccsfm.pi.FroccsController;

/**
 * Emulated controls.
 * @author adam.katona
 *
 */
public final class ControlForm extends BaseClass 
{
	 private JFrame mainFrame;
	 private JLabel displayLabel;
	 private boolean isActive;
	 private JSpinner spinner1;
	 private JSpinner spinner2;
	 private JButton okButton;
	 private FroccsController froccsController;
	 private String[] lines = new String[] {"", "", "", "", "", "", "", "", "", ""};

	 /**
	  * Constructor.
	  * @param controller
	  */
	 public ControlForm(FroccsController controller)
	 {
		 this.froccsController = controller;
	 }
	 
	 
	 /**
	  * Init form.
	  */
	 public void init()
	 {
	 	mainFrame = new JFrame("FröccsFM");
	 	mainFrame.setSize(300, 200);
	 	mainFrame.setLayout(new GridLayout(0, 1));
	 	
	 	//--- Add controls
	 	SpinnerModel spinnerModel1 = new SpinnerNumberModel(
	 			(int)(FroccsController.DEFAULT_WINE_AMOUNT / FroccsController.MAX_WINE_AMOUNT * 100), //initial value
	 	         0, //min
	 	         100, //max
	 	         1);//step
	 	      
	 	spinner1 = new JSpinner(spinnerModel1);
	 	mainFrame.add(spinner1);
	 	spinner1.addChangeListener(new ChangeListener() 
	 	{
	         public void stateChanged(ChangeEvent e) 
	         {
	            froccsController.valueChanged(0, (int)spinner1.getValue());
	         }
	 	});
	 	
	 	SpinnerModel spinnerModel2 = new SpinnerNumberModel(
	 			(int)(FroccsController.DEFAULT_SODA_AMOUNT / FroccsController.MAX_SODA_AMOUNT * 100),
	 			0, 100, 1);
	 	spinner2 = new JSpinner(spinnerModel2);
	 	mainFrame.add(spinner2);
	 	spinner2.addChangeListener(new ChangeListener() 
	 	{
	         public void stateChanged(ChangeEvent e) 
	         {
	        	 froccsController.valueChanged(1, (int)spinner2.getValue());
	         }
	 	});
	 	
	 	//--- Add button
	 	okButton = new JButton("OK");  
	 	mainFrame.add(okButton);
	 	okButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) 
	         {
	            try 
	            {
					froccsController.buttonPushed();
				} catch (IOException e1) 
	            {
					getLogger().error(e1);
				}
	         }          
	      });

	 	//--- Add display
	 	displayLabel = new JLabel("Display", JLabel.CENTER);
	 	mainFrame.add(displayLabel);
	 }
	 
	 /**
	  * Show form.
	  */
	 public void show()
	 {
	 	//-- Show form
	 	mainFrame.setVisible(true);
	 	mainFrame.addWindowListener(new WindowAdapter() 
	 	{
	 		@Override
	        public void windowClosing(WindowEvent windowEvent)
	        {
	           close();
	        }        
	 	});
	 	
	 	update();
	 }
	 
	 /**
	  * Close the form.
	  */
	 public void close()
	 {
		 mainFrame.setVisible(false);
		 isActive = false;
		 froccsController.shutdown();
	 }
	 
	 /**
	  * Show blocking.
	  */
	 public void showDialog()
	 {
		 show();
		 isActive = true;
		 
		 while (isActive)
		 {
			 try
			 {
				 Thread.sleep(1000);
			 }
			 catch (InterruptedException ex)
			 {
				 break;
			 }
		 }
		 
		 close();
	 }


	/**
	 * Write to display.
	 * @param message
	 */
	public void drawStringCentered(String message, int line) 
	{
		if (line >= lines.length)
		{
			getLogger().error("Can't write to display, line no > array length " + line);
			return;
		}
		
		lines[line] = message;
	}

	/**
	 * Update display.
	 */
	public void update()
	{
		StringBuilder sb = new StringBuilder();
		for(String s : lines)
		{
			sb.append(s);
			sb.append(" ");
		}
		
		displayLabel.setText(sb.toString());
	}

	/**
	 * Change displayed values.
	 * @param id
	 * @param value
	 */
	public void changeValue(int id, int value)
	{
		switch (id)
		{
			case 0: spinner1.setValue(value);
			break;
			
			case 1: spinner2.setValue(value);
			break;
		}
	}
	
	/**
	 * Clear the display.
	 */
	public void clear()
	{
		for(int i=0; i<lines.length; i++)
		{
			lines[i] = "";
		}
	}
}
