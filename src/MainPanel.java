import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	private DrawingPanel display = new DrawingPanel(this);
	
	public MainPanel(){
		super();
		this.setLayout(new BorderLayout());
		//create the drawing panel and add it to the center
		this.add(display, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		ActivateButton activate = new ActivateButton(display);
		
		buttonPanel.add(activate);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
	}

}
