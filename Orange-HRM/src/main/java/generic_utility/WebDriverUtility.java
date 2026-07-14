package generic_utility;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	WebDriver driver;
	
	public void getPressKeys(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB, Keys.DOWN).build().perform();
	}
	
	public void getImplicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	public void select(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}}


