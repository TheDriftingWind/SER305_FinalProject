import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ActionTimer extends Timer{
	
	private DrawingPanel _dp;
	private MainPanel _main;
	
	public ActionTimer(DrawingPanel dp, MainPanel main) {
		super(25, null);
		_dp = dp;
		_main = main;
		
		this.addActionListener(new ActionLoopListener());
	}
	
	private class ActionLoopListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Add JSoup Code here
			String keyword = _dp.getKeyword();
			System.out.println(keyword);
			
			//1.) Pull elements from web-page tests s
			
			//2.) get an array of results to check the keyword against
			
			//3.) return the matching results
			
			//4.) open a new pop-up with the results
			
		}
		
	}

}
