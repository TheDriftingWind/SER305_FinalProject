import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	private DrawingPanel display = new DrawingPanel(this);
	
	public MainPanel(){
		super();
		this.setLayout(new BorderLayout());
		//create the drawing panel and add it to the center
		this.add(display, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		
		//buttons
		JButton activate = new JButton("Activate");
		JButton deactivate = new JButton("Deactivate");
		
		//button listeners
		activate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//**TODO
				if(display.getWaitTime() > 0){
				display.setTimerDelay(display.getWaitTime());
				display.startTimer();
				deactivate.setEnabled(true);
				activate.setEnabled(false);
				display.setStatus("Active");
				} else {
					display.setStatus("Invalid Time Interval");
				}
			}
			
		});
		
		deactivate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				display.stopTimer();
				activate.setEnabled(true);
				deactivate.setEnabled(false);
				display.setStatus("Stopped");
			}
			
		});
		
		//Panel and Layout
		buttonPanel.add(activate);
		buttonPanel.add(deactivate);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
	}

}
