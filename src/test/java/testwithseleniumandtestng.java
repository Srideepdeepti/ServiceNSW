import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testwithseleniumandtestng {
           
	@Test(enabled=false)
	public void FirstTest() throws InterruptedException {
		
		
        
		System.setProperty("webdriver.chrome.driver", "D://Selenium//chromedriver_win32//chromedriver.exe");
		//Creating an object of ChromeDriver
		WebDriver driver = new ChromeDriver();
		//driver.get("www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.22.0");
		driver.quit();
		
	}
	
	@Test(dataProvider="getData")
	public void printData(String userName,String password) {
		System.out.println( "UserName: "+userName+" Password: "+password);
		
	}
	@DataProvider(name="getData")
	public Object testData(){
		
		return new Object[][] {{"Deepti","deepti123"},{"Rahul","rahul23"},{"Anvika","anvika@123"}};
	}
}
