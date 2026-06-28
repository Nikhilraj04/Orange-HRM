package generic_utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	 
	public void getPressKeys(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB, Keys.DOWN).build().perform();
	}
	
	}


