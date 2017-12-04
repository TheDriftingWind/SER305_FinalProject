import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.IOException;
import java.util.logging.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.util.ArrayList;

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
		ArrayList<String> itemList = new ArrayList<String>();

		@Override
		public void actionPerformed(ActionEvent arg0) { //START OF ACTION LOOP
			// Add JSoup Code here
			String keyword = _dp.getKeyword();
			System.out.println(keyword);
			
			//1.) Pull elements from web-page 
			//2.) get an array of results to check the keyword against
			//3.) return the matching results
			try {
			      String url = "https://dealsea.com/";
			      Document doc = Jsoup.connect(url).get();
			      Elements paragraphs = doc.select("div.dealbox");
			      for(Element p : paragraphs)
			    	  
			    	  //check if keyword matches text
			    	  if ( p.select("div.posttext").text().toLowerCase().indexOf(keyword.toLowerCase()) != -1 && p.text().indexOf("$") != -1) {
			    		  p.select("a").attr("href", "https://dealsea.com" + p.select("a").attr("href"));
			    		  itemList.add(p.outerHtml());
			    	  }
			      
			    
			}
			    catch (IOException ex) {
			      Logger.getLogger(ActionTimer.class.getName())
			            .log(Level.SEVERE, null, ex);
			    }
			String popup_html = "";
			  for(int i = 0; i < itemList.size(); i++) {   
		    	    System.out.print(itemList.get(i));
		    	    popup_html += "<div class=\"well well-sm\">";
		    	    popup_html += itemList.get(i);
		    	    popup_html += "</div>";
		    	}
			  if(itemList.size() == 0){
				  System.out.print("No items found");
				  popup_html += "<p>No deals were found</p>";
			  }
			
			//4.) open a new pop-up with the results
			//get the desktop directory
			File home = FileSystemView.getFileSystemView().getHomeDirectory();
			//make the url where the html document will be created
			String url = home.getAbsolutePath(); //Change to set the destination of where the popup is saved
			url = url + "/popup.html";
			
			//For testing purposes
			System.out.println(url); 
			String html = "<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<title>Available Deals</title>"
					+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">"
					+ "</head>"
					+ "<body>"
					+ "<h1 style=\"text-align:center\"><a href=\"https://dealsea.com\" >Deals on " + keyword 
					+ "</a></h1>"
					+ "<div class=\"container\">";
			html += popup_html;
			html += "</body></div></html>";
			
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
			
			itemList.clear();
		}//END OF ACTION LOOP//
	}
}


