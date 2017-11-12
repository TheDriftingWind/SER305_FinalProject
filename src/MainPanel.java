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
		activate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				display.setTimerDelay(display.getWaitTime());
				display.startTimer();
			}
			
		});
		JButton deactivate = new JButton("Deactivate");
		deactivate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				display.stopTimer();
				
			}
			
		});
		
		buttonPanel.add(activate);
		buttonPanel.add(deactivate);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
	}

}
