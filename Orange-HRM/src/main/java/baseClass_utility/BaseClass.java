package baseClass_utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

import freemarker.core.ParseException;
import generic_utility.FileUtility;

public class BaseClass {
	
	public WebDriver driver;
	private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
	public ExtentReports report;
	
	/**
	 * Initializes the browser instance for the current TestNG test thread.
	 * The browser value is supplied from the suite XML and defaults to Chrome.
	 */
	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser)
			throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
		String BROWSER = browser.toLowerCase();

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
		
		threadDriver.set(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * Returns the WebDriver assigned to the current execution thread.
	 */
	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	/**
	 * Clicks an element only after transient OrangeHRM overlays have gone away.
	 * A retry is useful when the page is still finishing an animation.
	 */
	protected void clickWhenReady(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By loadingSpinner = By.cssSelector(".oxd-loading-spinner");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingSpinner));
		} catch (NoSuchElementException ignored) {
			// No loading overlay is present.
		}

		for (int attempt = 0; attempt < 2; attempt++) {
			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
				element.click();
				return;
			} catch (ElementClickInterceptedException exception) {
				if (attempt == 1) {
					throw exception;
				}
				driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingSpinner));
			}
		}
	}

	/**
	 * Logs in to the VTiger CRM application before each test method.
	 */
	@BeforeMethod
	public void login()
			throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
		FileUtility fUtil = new FileUtility();
		String URL = fUtil.getDataFromJsonFile("url");
		String USERNAME = fUtil.getDataFromJsonFile("un");
		String PASSWORD = fUtil.getDataFromJsonFile("pwd");

		driver.get(URL);
		pom_pages.LoginPom lp = new pom_pages.LoginPom(driver);
		lp.Login(USERNAME, PASSWORD);

		System.out.println("Login successful");
	}

	/**
	 * Logs out from the application after each test method.
	 * @throws InterruptedException 
	 */
	@AfterMethod
	public void logout() throws InterruptedException {
		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		System.out.println("Browser logOut successfully");
	}
	

	/**
	 * Closes the browser and clears the thread-local driver after each class.
	 */
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		threadDriver.remove();
		System.out.println("Browser closed successfully");
	}

}
