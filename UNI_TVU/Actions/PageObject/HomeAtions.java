package PageObject;
import TVU.HomeUI;

import org.openqa.selenium.WebDriver;

import Common.AbstractPage;

public class HomeAtions extends AbstractPage{
	WebDriver driver;
	public HomeAtions(WebDriver mapdriver) {
		driver=mapdriver;
	}
 // ham verify xem da dung dang nhap voi user voi role tuong ung chua
	public boolean verifyMessageDisplayed() {
		return isControlDisplay(driver, HomeUI.TEXT_MESSAGE_ROLE_HV);
	}

	

}
