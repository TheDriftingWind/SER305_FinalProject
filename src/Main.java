import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.JPanel;
//backup1
public class Main extends javax.swing.JFrame{
	
	DrawingPanel _dp;
	
	public Main(String title){
		super(title);
		this.setSize(550, 550);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.add(new MainPanel());
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args){
		Main app = new Main("Deal Finder");
		

	}

}
