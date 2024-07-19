
import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class HelloSelenium {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();



        driver.get("https://www.nsw.gov.au/media-releases");
        
        WebElement elementsLabel = driver.findElement(By.xpath("//div[@class='nsw-form__group']//label[contains(text(),'The Premier')]"));
        
        System.out.println(elementsLabel.getAttribute("for"));
        
        System.out.println(elementsLabel.getText());



        List<WebElement> elements = driver.findElements(By.className("nsw-form__group"));
      //div[@class='expandable-field__container expandable-field__container--expanded']/fieldset[@id='filter-ministers']/button
        WebElement element = driver.findElement(By.xpath("//div[@class='expandable-field__container expandable-field__container--expanded']/fieldset[@id='filter-ministers']/button"));
        System.out.println(element.isDisplayed()+"enabled"+element.isEnabled()+"Text"+element.getText());
        
        Actions actionsshow = new Actions(driver);

     	actionsshow.moveToElement(element).click(element).build().perform();
        

    	System.out.println(elements.size());
    	
    	/* for (WebElement egrp:elements)

         {

         	System.out.println("Inside elements getAttribute"+egrp.getAttribute("id"));

         	System.out.println("Inside elements class"+egrp.getClass());

         	System.out.println("location"+egrp.getLocation());
         	System.out.println("Text"+egrp.getText());

         	Actions actions = new Actions(driver);

         	actions.moveToElement(egrp).click(egrp).build().perform();

         	//e.click();

         	//e.getAttribute("id").click();

         }*/


       // List<WebElement> elementsPath = driver.findElements(By.xpath("//div[@class='nsw-form__group']//label[contains(text(),'The Premier')]"));

        List<WebElement> elementsPath = driver.findElements(By.xpath("//div[@class='nsw-form__group']//*[@id=\"ministers-the-premier\"]"));
        

       WebElement elementsPathOne = driver.findElement(By.xpath("//div[@class='nsw-form__group']//*[@id='"+elementsLabel.getAttribute("for")+"']"));
       
       Actions actionOne = new Actions(driver);

       actionOne.moveToElement(elementsPathOne).click(elementsPathOne).build().perform();
       

        //List<WebElement> elementsPathDeputy = driver.findElements(By.xpath("//div[@class='nsw-form__group']//*[@id="+elementsLabel.getAttribute("for")+"]"));
        List<WebElement> elementsPathYouth = driver.findElements(By.xpath("//div[@class='nsw-form__group']//*[@id=\"ministers-minister-for-youth\"]"));
        
        System.out.println(" Text is ::"+elementsPathOne);
        
        //List<WebElement> elementsPathMore = driver.findElements(By.xpath("//div[@class='nsw-filters__more']"));

        //nsw-filters__more

      //*[@id="element_id"]

    	//System.out.println("elementsPath"+elementsPathMore.size());

//    	WebDriverWait wait = new WebDriverWait(driver, 10);

//    	WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("Login")));

//    	loginBtn.click();

    	

//    	for (int i = 0; i < elementsPath.size(); i++) {

//    		WebElement element = elementsPath.get(i);

//        	System.out.println("location"+element.getLocation());

//        	System.out.println("class"+element.getClass());

//

//    		//element.click();

//        	System.out.println("id");

//

//        	System.out.println("id"+element.getLocation());

//        	System.out.println("getAccessibleName"+element.getAccessibleName());

//        	System.out.println("getText"+element.getText());

//

//        	System.out.println("id after");

//

//

//    	    // 1 - can call methods of element

//    	    // 2 - can use 'i' to make index-based calls to methods of list

//

//    	    // ...

//    	}

        /*for (WebElement e: elementsPath)

        {

        	System.out.println("Inside elements getAttribute"+e.getAttribute("id"));

        	System.out.println("Inside elements class"+e.getClass());

        	System.out.println("location"+e.getLocation());

        	Actions actions = new Actions(driver);

        	actions.moveToElement(e).click(e).build().perform();

        	//e.click();

        	//e.getAttribute("id").click();

        }*/

        /*for (WebElement eDep: elementsPathDeputy)

        {

        	System.out.println("Inside elements getAttribute"+eDep.getAttribute("id"));

        	System.out.println("Inside elements class"+eDep.getClass());

        	System.out.println("location"+eDep.getLocation());

        	Actions actions = new Actions(driver);

        	actions.moveToElement(eDep).click(eDep).build().perform();

        	//e.click();

        	//e.getAttribute("id").click();

        }*/
        
        for (WebElement eYouth: elementsPathYouth)

        {

        	System.out.println("Inside elements getAttribute"+eYouth.getAttribute("id"));

        	System.out.println("Inside elements class"+eYouth.getClass());

        	System.out.println("location"+eYouth.getLocation());

        	Actions actions = new Actions(driver);

        	actions.moveToElement(eYouth).click(eYouth).build().perform();

        	//e.click();

        	//e.getAttribute("id").click();

        }

        //driver.quit();

        System.out.println("Quit");

    }

}

