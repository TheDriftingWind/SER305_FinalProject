import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.logging.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.util.ArrayList;

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
		ArrayList<String> itemList = new ArrayList<String>();

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Add JSoup Code here
			String keyword = _dp.getKeyword();
			System.out.println(keyword);
			
			//1.) Pull elements from web-page 
			//2.) get an array of results to check the keyword against
			//3.) return the matching results
			try {
			      String url = "https://dealsea.com/";
			      Document doc = Jsoup.connect(url).get();
			      Elements paragraphs = doc.select("p");
			      for(Element p : paragraphs)
			    	  
			    	  //check if keyword matches text
			    	  if ( p.text().toLowerCase().indexOf(keyword.toLowerCase()) != -1 && p.text().indexOf("$") != -1) {
			    		  itemList.add(p.text());
			    	  }
			      
			    
			}
			    catch (IOException ex) {
			      Logger.getLogger(ActionTimer.class.getName())
			            .log(Level.SEVERE, null, ex);
			    }
			
			  for(int i = 0; i < itemList.size(); i++) {   
		    	    System.out.print(itemList.get(i));
		    	}  
			  }
			
			
		
			
			
			
			
			
			//4.) open a new pop-up with the results
			
		}
		
	}


