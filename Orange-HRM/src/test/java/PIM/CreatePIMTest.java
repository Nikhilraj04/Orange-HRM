package PIM;

import java.time.Duration;

import javax.lang.model.util.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass_utility.BaseClass;
import pom_pages.PimPOM;


public class CreatePIMTest extends BaseClass{
	@Test
	public void getPim() {
	//========================== we are optimising this code we will all this in pom login 
//public static void main(String[] args) throws InterruptedException {
//	WebDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//	
//	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	
//	Thread.sleep(2000);
//	WebElement username = driver.findElement(By.name("username"));
//	username.sendKeys("Admin");
//	WebElement pwd = driver.findElement(By.name("password"));
//	pwd.sendKeys("admin123");
//	
//	
//	
////	driver.findElement(By.cssSelector("button[type='submit']")).click(); 
//	driver.findElement(By.xpath("//button[text()=' Login ']")).click();

	PimPOM pim = new PimPOM(driver);
//	driver.findElement(By.xpath("//span[text()='PIM']")).click(); //tagname[text()='visible text']
	pim.getAddemp(); //step - 1 Add employee
	
	pim.getfirstname(); //step 2- write the firstname
	
	pim.getlastname(); // step 3 - write the lastname
	
	pim.getEmpid(); //step - 4 - write the empID
	
	pim.getProfPic(); //step-5 click on add Profile pic
	
	pim.getSubmitbtn(); // step-6 Click on the submit button 
	
//	pim.getDate(); // step-7 click on the add date 
	
//	pim.getnation();//step 8 - click on the add nationality
 
	pim.getSubmitbtn();//step-9 - click on the submit button


	
//=============add employee====================
/*

     WebElement addEmp = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Add Employee']"))));
     addEmp.click();
 
     
     WebElement firstName = driver.findElement(By.name("firstName"));
     firstName.sendKeys("Nikhil Raj ");
//     firstName.sendKeys("Singhaniy");
    
     WebElement lastName = driver.findElement(By.name("lastName"));
     lastName.sendKeys("Singhaniya");
 //    lastName.sendKeys("Kumar");     
     
     
 //===========EMP ID==========================    
     WebElement empID =  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[text()='Employee Id']/../..//input"))));
     empID.sendKeys("0421");
   //  empID.sendKeys("6397");
     
     
     WebElement pfPic = driver.findElement(By.cssSelector("img[alt='profile picture']"));
     pfPic.click();
     
 
     WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));   
     submit.click();
     
   
     
     
//===========================handling dropdown dob======================  
  
     WebElement date = driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]"));
     date.sendKeys("2001-08-04");
    
     
 
    WebElement nation = driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[2]"));
    nation.sendKeys("Indian");
 
//	search emp 	
//	driver.findElement(By.xpath("//label[text()='Employee Name']/../..//input"));
	
    
	WebElement save = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
	save.click();
	
	//=======locating nationality================
	

	driver.findElement(By.xpath("//label[text()='Nationality']")).click();
	Actions act = new Actions(driver);
	act.sendKeys(Keys.TAB + "i" + Keys.DOWN + Keys.DOWN + Keys.ENTER).build().perform();

	
	
//other ways to access the but giving 1 of 3
	driver.findElement(By.xpath("//label[text()='Nationality']/../..//div[contains(@class,'oxd-select-text')]"));
	
//label[text()='Employee Id']/../..//input
	*/
//	driver.quit();
	
//	driver.quit();
	
}}

