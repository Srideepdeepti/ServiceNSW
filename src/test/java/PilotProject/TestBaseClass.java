package PilotProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseClass {

	WebDriver driver = null;
	
	// Create an object of Properties file for Data Driven Testing
	
	  public static Properties prop = null;

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "D://Selenium//chromedriver_win32//chromedriver.exe");
		// Creating an object of ChromeDriver
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		
		
		// Reading through properties file
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\hospital.properties");
			prop.load(fis);
		    
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void finish() {

		driver.quit();
	}
	
	
	public void waitforWebPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int i = 0;

		while (i != 10) {
			String state = (String) js.executeScript("return document.readyState;");
			System.out.println(state);

			if (state.equals("complete"))
				break;
			else
				wait(2);

			i++;
		}

		// check for jQuery status
		i = 0;
		while (i != 10) {

			Long d = (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);
			if (d.longValue() == 0)
				break;
			else
				wait(2);
			i++;

		}
	}

	public void wait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectfromDropDown(WebElement element, String selecatble) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(selecatble);
	}
	
	public void selectDatefromDropDownCalender(String calender_id, String supplied_date) throws InterruptedException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		//Parse supplied_date into Date format
		
		try {
			Date supplied_dob = (Date) dateFormat.parse(supplied_date);
			
			///Extract year
			
			String year = new SimpleDateFormat("yyyy").format(supplied_dob);
			System.out.println("Year is :::"+year);
			//click on year
			driver.findElement(By.id(prop.getProperty(calender_id))).click();
			
			
			WebElement calenderYear = driver.findElement(By.xpath(prop.getProperty("dobCalendarYear_xpath")));
			selectfromDropDown(calenderYear, year);
			Thread.sleep(3000);
            ///Extract month
			
			String month = new SimpleDateFormat("MMM").format(supplied_dob);
			System.out.println("month is :::"+month);
			WebElement calenderMonth = driver.findElement(By.xpath(prop.getProperty("dobCalenderMonth_xpath")));
			selectfromDropDown(calenderMonth, month);
		
			
			
            ///Extract day
			
			String day = new SimpleDateFormat("d").format(supplied_dob);
			System.out.println("day is :::"+day);
			WebElement calenderDay = driver.findElement(By.xpath("//a[text()='"+day+"']"));
			calenderDay.click();                         
		
		
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
