package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom {
	public LoginPom(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	
	
	@FindBy(name = "username")
	private WebElement username;
	
	public WebElement getUsername() {
		return username;
	}
	
	@FindBy(name= "password")
	private WebElement password;
	
	public WebElement getPassword() {
	return password;
	}
	
	@FindBy(xpath ="//button[text()=' Login ']")
	private WebElement login;
	
	public WebElement getLogin() {
	return login;
	}	
	
	
	public void Login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
	}
		
}
