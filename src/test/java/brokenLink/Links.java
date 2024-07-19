package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Links {
	
	
	public static int invalidlinkCount=0;
	
	public static void verifyBrokenLink(String link) throws IOException {
		
		if(link!=null && !link.isEmpty()) {
		
			URL url= new URL(link);
			//Open HTTP Connection
		
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			//set Timeout
			connection.setConnectTimeout(3000);
			
			// set request method to HEAD only to check headers not the entire content
			
			connection.setRequestMethod("HEAD");
			
			//connect to URL
			
			connection.connect();
			
			//verify the status code
			
			if(connection.getResponseCode()==200) {}
			else 
			{invalidlinkCount++;}
				
		
		
		}
		
	}
	
	public static void invalidLinkCount() {
	
		System.out.println(invalidlinkCount);
	}
	

}
