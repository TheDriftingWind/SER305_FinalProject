import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Timer;
import javax.swing.filechooser.FileSystemView;

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
			
			//1.) Pull elements from web-page
			
			//2.) get an array of results to check the keyword against
			
			//3.) return the matching results
			
			//4.) open a new pop-up with the results
			//get the desktop directory
			File home = FileSystemView.getFileSystemView().getHomeDirectory();
			//make the url where the html document will be created
			String url = home.getAbsolutePath();
			url = url + "/test.html";
			
			//For testing purposes
			System.out.println(url); 
			String html = "<!DOCTYPE html><html><head><title>Test</title></head><body><a href='https://www.google.com'>Link</a></body></html>";
			
			//create new file
			File f = new File(url);
			//write to the html file
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(html);
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//open the file for the user to see
			try {
				Desktop.getDesktop().browse(f.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
