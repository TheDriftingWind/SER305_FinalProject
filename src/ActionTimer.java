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
			//_dp.getKeyword();
			System.out.println("test");
			
		}
		
	}

}
