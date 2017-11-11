import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner scan = new Scanner(System.in);
		//enter wait time
		System.out.println("Enter wait:");
		int wait = scan.nextInt();
		System.out.println(wait);
		//enter keyword
		System.out.println("Enter keyword:");
		String keyword = scan.nextLine();
		System.out.println(keyword);
		
		//loop
		boolean loop = true;
		String stop = scan.nextLine();
		
		//Document page = Jsoup.connect("https://dealsea.com/").timeout(6000).get();
		//Elements div = page.select("div");
		while(loop){
			System.out.println(stop);
			if(stop == "stop"){
				loop = false;
			}
			
			Thread.sleep(wait);
		}
		

	}

}
