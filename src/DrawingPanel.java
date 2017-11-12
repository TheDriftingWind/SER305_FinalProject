
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DrawingPanel extends javax.swing.JPanel {
	
	private MainPanel _main;
	//inputs
	private JTextField _waitTime;
	private JTextField _keyword;
	//loop variables
	private ActionTimer _timer;
	
	
	public DrawingPanel(MainPanel main){
		super();
		this.setBackground(java.awt.Color.white);
		this.setPreferredSize(new java.awt.Dimension(300, 100));
		this.setSize(new java.awt.Dimension(500, 500));
		this.setFocusable(true);
		_main = main;
		
		//looping variables
		_timer = new ActionTimer(this, _main);
		
		//TextFields
		_waitTime = new JTextField("0", 5);
		_keyword = new JTextField("0", 5);
		
		this.setLayout(new GridLayout(3,2));
		
		//waitTime row
		this.add(new JLabel("Checking Time(s)"));
		this.add(_waitTime);
		
		//keyword row
		this.add(new JLabel("Enter Keyword:"));
		this.add(_keyword);
	}
	
	/**
	 * Wait time for the loop to sleep between actions.
	 * @return User's input of waitTime as an Integer
	 */
	public int getWaitTime() {
		int rawTime = Integer.parseInt(_waitTime.getText());
		//multiply input to scale milliseconds to seconds
		return rawTime * 1000;
	}
	
	/**
	 * Get the keyword for the search
	 * @return User's input of keyword to search as String
	 */
	public String getKeyword() {
		return _keyword.getText();
	}
	
	/**
	 * starts timer to begin loop
	 */
	public void startTimer(){
		_timer.start();
	}
	/**
	 * stops timer to stop loop
	 */
	public void stopTimer(){
		_timer.stop();
	}
	
	public void setTimerDelay(int wait){
		_timer.setDelay(wait);
	}
	
}
