import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

	public static void main(String[] args) throws IOException {
		//init
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter wait:");
		int wait = scan.nextInt();
		System.out.println("Enter keyword:");
		String keyword = scan.nextLine();
		
		
		Document page = Jsoup.connect("https://dealsea.com/").timeout(6000).get();
		
		

	}

}
