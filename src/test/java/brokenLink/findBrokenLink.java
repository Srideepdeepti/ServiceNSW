package brokenLink;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class findBrokenLink {
   
	WebDriver driver = null;
	
	@BeforeMethod
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D://Selenium//chromedriver_win32//chromedriver.exe");
		//Creating an object of ChromeDriver
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.22.0");
	}
	
	@Test
	public void allLinksPresent() throws IOException {
	
	 List <WebElement> allLinks = driver.findElements(By.tagName("a"));
	 System.out.println(" All links present on page :: "+ allLinks.size());
	 
	 
	 for(WebElement link : allLinks) {
		 
		if(link.isDisplayed()) {
			System.out.println("Link Text is ::"+ link.getText());
			 Links.verifyBrokenLink(link.getAttribute("href"));
			
		}
	 }
	 System.out.println(" Invalid link or Broken links are ::");
	 Links.invalidLinkCount();
	 
	
	}
	
	
	@AfterMethod
	public void tearDown() {
	
	 driver.quit();
         }  
	}
