package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPOM {

	public PimPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
		;
	}

	@FindBy(xpath = "//a[text()='Add Employee']") // step - 1 Add employee name
	private WebElement addEmp;

	public WebElement getAddemp() {
		return addEmp;
	}

	@FindBy(name = "firstName") // step 2- write the firstname
	private WebElement name;

	public WebElement getfirstname() {
		return name;
	}

	@FindBy(name = "lastName") // step 3 - write the lastname
	private WebElement name1;

	public WebElement getlastname() {
		return name1;
	}

	@FindBy(xpath = "empID") //step - 4 - write the empID
	private WebElement empid;

	public WebElement getEmpid() {
		return empid;
	}

	@FindBy(css = "img[alt='profile picture']") //step-5 click on add Profile pic
	private WebElement clickonPf;

	public WebElement getProfPic() {
		return clickonPf;
	}

	@FindBy(css = "button[type='submit']") //step-6 Click on the submit button 
	private WebElement submit;

	public WebElement getSubmitbtn() {
		return submit;
	}

	@FindBy(xpath = "//input[@placeholder='yyyy-dd-mm'])[1]") //step-7 click on the add date 
	private WebElement clickDate;

	public WebElement getDate() {
		return clickDate;
	}

	@FindBy(xpath = "//label[text()='Nationality']/../..//div[contains(@class,'oxd-select-text')]\"")
	private WebElement nation;    //click 8 - click on the add nationality

	public WebElement getnation() {
		return nation;
	}

	@FindBy(xpath = "(//button[@type='submit'])[1]") //click on the submit button
	private WebElement clickSave;

	public WebElement getSave() {
		return clickSave;
	}

}
