package PilotProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BookAppointment extends TestBaseClass {
	
	
	@Test
	public void bookAppointmentTest() throws InterruptedException {
		// Read Data and Locators from Properties file.
				driver.get(prop.getProperty("url"));
				waitforWebPageToLoad();

				// Open Consultation Pop-Up
				driver.findElement(By.linkText(prop.getProperty("doctor_name"))).click();
				waitforWebPageToLoad();
				
				System.out.println("Displaying status : "+driver.findElement(By.xpath(prop.getProperty("Consultation_btn"))).isDisplayed());
				driver.findElement(By.xpath(prop.getProperty("Consultation_btn"))).click();
				
				// Validate presence and visibility of Name and any other field
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(prop.getProperty("name_id"))));
				wait.until(ExpectedConditions.elementToBeClickable(By.id(prop.getProperty("email_id"))));

				// Enter Name, Email, Mobile
				driver.findElement(By.id(prop.getProperty("name_id"))).sendKeys(prop.getProperty("patient_name"));
				driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys(prop.getProperty("patient_email"));
				driver.findElement(By.id(prop.getProperty("mobile_id"))).sendKeys(prop.getProperty("patient_mobile"));

				
				selectfromDropDown(driver.findElement(By.id(prop.getProperty("gender_id"))),"Male");
				
				
			     selectDatefromDropDownCalender("dobCalendar_id",prop.getProperty("dob"));
				//Enter Patient Details
				
				Thread.sleep(3000);
				
	}

}
