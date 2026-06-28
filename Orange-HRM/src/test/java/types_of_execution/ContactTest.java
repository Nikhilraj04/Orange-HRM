package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ContactTest {
	WebDriver driver;

	public void ContactTest(String browser) throws InterruptedException {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equals("Edge")) {
		 driver = new EdgeDriver();
		 
	     }else if(browser.equals("Firefox")) {
	    	 driver= new FirefoxDriver();
	    	 
	     } else {
	    	 driver = new ChromeDriver();
	     }

	Thread.sleep(2000);
	System.out.println("contact created");
	driver.quit();
}
	
//	@Test
//	public void modifyContactTest() throws InterruptedException {
//		driver = new ChromeDriver();
//		Thread.sleep(2000);
//		System.out.println("Contact modified");
//		driver.quit();
//	}
//	@Test
//	public void deleteContactTest() throws InterruptedException {
//		driver = new ChromeDriver();
//		Thread.sleep(2000);
//		System.out.println("Contact deleted");
//		driver.quit();
//	}
//
//



}
