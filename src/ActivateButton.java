import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivateButton extends javax.swing.JButton{
	private DrawingPanel _dp;
	
	public ActivateButton(DrawingPanel dp){
		super("Activate");
		_dp = dp;
		addActionListener(new ActivateListener());
	}
	
	private class ActivateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	}
}
