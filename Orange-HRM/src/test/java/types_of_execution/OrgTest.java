package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrgTest {
	WebDriver driver;

	@Parameters("bro")
	@Test
	public void createOrgTest(String browser) throws InterruptedException {

//		String browser = "chrome";

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		Thread.sleep(2000);
		System.out.println("org created");
		driver.quit();
	}
	
	
	
/*
/	@Parameters("bro")
//	@Test
//	public void modifyOrgTest(String browser) throws InterruptedException {
////		String browser = "edge";
//
//		if (browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (browser.equals("edge")) {
//			driver = new EdgeDriver();
//		} else if (browser.equals("firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//
//		Thread.sleep(2000);
//		System.out.println("org modified");
//		driver.quit();
//	}
//
//	
//	@Parameters("bro")
//	@Test
//	public void deleteOrgTest(String browser) throws InterruptedException {
//
////		String browser = "firefox";
//
//		if (browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (browser.equals("edge")) {
//			driver = new EdgeDriver();
//		} else if (browser.equals("firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//
//		Thread.sleep(2000);
//		System.out.println("org deleted");
//		driver.quit();
//	}
}


*/
}
