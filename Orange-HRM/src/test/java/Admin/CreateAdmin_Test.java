package Admin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass_utility.BaseClass;
import generic_utility.WebDriverUtility;
import pom_pages.AdminPom;

@Listeners(listeners_utility.listeners.class)
public class CreateAdmin_Test extends BaseClass {
	
	@Test
	public void getAdminCreate() {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//
//		WebElement username = driver.findElement(By.name("username"));
//		username.sendKeys("Admin");
//		WebElement pwd = driver.findElement(By.name("password"));
//		pwd.sendKeys("admin123");

		// step-1 - Click Login Button
//		driver.findElement(By.cssSelector("button[type='submit']")).click(); 
//		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		
//		 step-2 Click on the Admin button
//		WebElement admin = driver.findElement(By.xpath("//span[text()='Admin']"));
//		admin.click();
		AdminPom adminP = new AdminPom(driver); //creating the object of the admin pom class
		adminP.getClickAdminbtn().click();  //		Step 1 - click on admin button

		adminP.getAddUsrNam().click(); //		Step 2-click on add icon 
		
		if(adminP.getVerifyUser().isDisplayed()){
			System.out.println("navigated to add user page");
		}// Step 3 - click on the add user in the user manangement

		adminP.getUserrole().click();; //step-4 click on the user role in the um======
		WebDriverUtility wdu = new WebDriverUtility();
		wdu.getPressKeys(driver);
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.TAB, Keys.DOWN).build().perform();
		
		adminP.getStatus().click();
		wdu.getPressKeys(driver);
//		act.sendKeys(Keys.TAB, Keys.DOWN).build().perform();
		 
		
		//==========this was a bit tough to navigate so pls let it be
//		WebElement userRole = driver.findElement(By.xpath("//label[text()='User Role']"));
//		userRole.click();
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.TAB, Keys.DOWN).build().perform();

		
		adminP.getEmpName().sendKeys("nikhil");; //step-5 click on the empolyee name 
		adminP.getUsernmae().sendKeys("nikhil_raj");
		adminP.getpasswordemp().sendKeys("Nikhil@123");; //step 6 - click on the password
		adminP.getconfirmPass().sendKeys("Nikhil@123");; //step 7 - click on the confirm password
		adminP.getsubmit().click();;//Step 8 - click on the submit button
		
		// Step-5 Type the Employee Name
//		WebElement empName = driver.findElement(By.xpath("//label[text()='Employee Name']/../..//input"));
//		empName.sendKeys("Nikhil123");

		// Step-6 Type the password
//		WebElement password = driver.findElement(By.xpath("//label[text()='Password']/../..//input"));
//		password.sendKeys("Nikhil@123");
		
		// Step-7 Type the confirm password
//		WebElement confirmPassword = driver.findElement(By.xpath("//label[text()='Confirm Password']/../..//input"));
//		confirmPassword.sendKeys("Nikhil@123");

		// Step-8 click on the submit
		
//		WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
//		submit.click();
		// driver.findElement(By.)

		
//		driver.quit();
	}
}
