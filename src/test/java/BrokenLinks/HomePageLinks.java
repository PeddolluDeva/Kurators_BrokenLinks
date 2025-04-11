package BrokenLinks;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageLinks {

	public static void main(String[] args) {
//		public static void main(String[] args) {
			
			WebDriver dri = new ChromeDriver();
			
			dri.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			dri.get("http://34.225.116.122/home-page");
			
			dri.manage().window().maximize();
			
			List<WebElement> link = dri.findElements(By.tagName("a"));
			
			int nobrok =0;
			
			System.out.println(" Number of Element is :- "+link.size());
			
			for(WebElement linkelement : link) {
				
				String herfele = linkelement.getAttribute("href");
				
				if(herfele == null || herfele.isEmpty()) {
					
					System.out.println(" herf attribute ");
					
					continue;
					
				}try {
//					String hefele = null;
					URL linksurl = new URL(herfele);
					
					HttpURLConnection con = (HttpURLConnection) linksurl.openConnection();
					
					con.connect();
					
					if (con.getResponseCode() >=400) {
						
						System.out.println(" herfele Links of Elements is  ----->>> ((   HomePage Links )) <<----  Broken Links  <<<---- :- "+herfele);
						nobrok++;
						
					} else {
						
						System.out.println(" Herfele Not links of Elementis is ----->>> ((   HomePage Links )) <<---- Not Brken links <<<----  "+herfele);
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		System.out.println(" No of Broken links :- "+nobrok);	 
		}
	}
//}
