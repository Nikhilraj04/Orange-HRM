package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPom {

	public AdminPom(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(xpath ="//span[text()='Admin']")
	private WebElement Admin;
	
	public WebElement getClickAdminbtn() {      //step-1 click on the admin button
		return Admin;
		}	
		
	@FindBy(css = "i[class='oxd-icon bi-plus oxd-button-icon']")
	private WebElement AddUsrNam;
	
	public WebElement getAddUsrNam() {   //step-2 click on get admin username
		return AddUsrNam;
		}	
		
	
	@FindBy(xpath = "//h6[text()='Add User']")  //step - 3 click on the add user in the user manangement
	private WebElement VerifyUser;
	
	public WebElement getVerifyUser() {
		return VerifyUser ;
		}	
		
	
	@FindBy(xpath = "//label[text()='User Role']") //step-4 click on the user role in the um
	private WebElement Userrole;
	
	public WebElement getUserrole() {
		return Userrole ;
		}
	
	@FindBy(xpath = "//label[text()='Status']") //step-4 click on the user role in the um
	private WebElement status;
	
	public WebElement getStatus() {
		return status ;
		}
	
	
	@FindBy(xpath = "//label[text()='Employee Name']/../..//input") //step-5 click on the empolyee name 
	private WebElement empName;
	
	public WebElement getEmpName() {
		return empName ;
		}
	
	@FindBy(xpath ="//label[text()='Password']/../..//input") //step-6 click on the password 
	private WebElement passwordemp;
	
	public WebElement getpasswordemp() {
		return passwordemp ;
		}
	
	
	@FindBy(xpath ="//label[text()='Username']/../..//input") //step-6 click on the password 
	private WebElement username;
	
	public WebElement getUsernmae() {
		return username ;
		}
	
	@FindBy(xpath ="//label[text()='Confirm Password']/../..//input") //step-7 click on the confirm password
	private WebElement confirmPass;
	
	public WebElement getconfirmPass() {
		return confirmPass ;
		}
	
	@FindBy(css="button[type='submit']") //step-8 click on the submit btn
	private WebElement submit;
	

	public WebElement getsubmit() {
		return submit ;
		}
	
}
