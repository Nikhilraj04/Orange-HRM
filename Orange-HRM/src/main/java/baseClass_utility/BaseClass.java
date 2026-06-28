package baseClass_utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;

import generic_utility.FileUtility;
import pom_pages.LoginPom;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public ExtentReports report;
//	public WebDriverWait wait;
	
	@BeforeClass
	public void setUp()
			throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
		// ==============================
		// Browser Setup
		// ==============================

//		get data from json file
		FileUtility fUtil = new FileUtility();
		String BROWSER = fUtil.getDataFromJsonFile("url");


		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("safari")) {
			driver = new SafariDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		sdriver = driver;
//		driver = new ChromeDriver();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}

	@BeforeMethod
	public void login()
			throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
		// ==============================
		// Login to HRM Application
		// ==============================
		FileUtility fUtil = new FileUtility();
		String URL = fUtil.getDataFromJsonFile("url");
		String USERNAME = fUtil.getDataFromJsonFile("un");
		String PASSWORD = fUtil.getDataFromJsonFile("pwd");

		driver.get(URL);
		LoginPom lp = new LoginPom(driver); //creating login Pom object
		lp.Login(USERNAME, PASSWORD);  //accessing data through json file 

		System.out.println("Login successful");
	}
//===========================
	@AfterMethod
	public void logout() throws InterruptedException {
		// ==============================
		// Logout from HRM Application
		// ==============================

		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(2000);
		System.out.println("Logout successful");
	}

	@AfterClass
	public void tearDown() {
		// ==============================
		// Close Browser
		// ==============================
      
		driver.quit();
		System.out.println("Browser closed successfully");
	}
}
