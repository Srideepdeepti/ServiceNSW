package PilotProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class TestHandsOn {
	
	@Test
	public void calendarTest() throws ParseException {
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		 
		Date currentDate =new Date();
		
		String dob = "28-09-1983";
		Date SuppliedDate = dateFormat.parse(dob);
		
		if(currentDate.compareTo(SuppliedDate)==1)
		{
			System.out.println(currentDate.compareTo(SuppliedDate));
		}else
		{
			System.out.println(currentDate.compareTo(SuppliedDate));
		}
		
		String CurrentFormatteddate = dateFormat.format(currentDate);
		
		System.out.println(" Current formatted date : "+ CurrentFormatteddate);
		System.out.println(" Current Date is : "+ currentDate);
		
		//Extracting value from current Formatted Date
		
		String day = new SimpleDateFormat("dd").format(currentDate);
		
		System.out.println("Current Day is : "+ day);
		
		// Extracting value of current Month in -mm-
		
        String month = new SimpleDateFormat("MMM").format(currentDate);
		
		System.out.println("Current Month is : "+ month);
		
// Extracting value of current Month in -mm-
		
        String month1 = new SimpleDateFormat("MMMM").format(currentDate);
		
		System.out.println("Current Month Full Name is : "+ month1);
		
		
// Extracting value of current Month in -mm-
		
        String month2 = new SimpleDateFormat("MM").format(currentDate);
		
		System.out.println("Current Month is : "+ month2);
		
		
// Extracting value of current Year 
		
        String year = new SimpleDateFormat("yyyy").format(currentDate);
		
		System.out.println("Current Year  is : "+ year);
		
		
	}

}
