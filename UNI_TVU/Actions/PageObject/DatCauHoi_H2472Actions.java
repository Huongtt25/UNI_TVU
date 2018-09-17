package PageObject;

import org.openqa.selenium.WebDriver;

import Common.AbstractPage;
import TVU.DatCauHoi_H2472UI;

public class DatCauHoi_H2472Actions extends AbstractPage {
	WebDriver driver;
	public DatCauHoi_H2472Actions(WebDriver mapdriver) {
		driver=mapdriver;
	}
	// ham verify message loi
	public void isDynamicErrorMessageDisplayed(String dynamicName, String dynamicErrorMessage) {
		waitForVisible(driver,DatCauHoi_H2472UI.DYNAMIC_ERROR_MESSAGE, dynamicName, dynamicErrorMessage);
		isControlDisplay(driver,DatCauHoi_H2472UI.DYNAMIC_ERROR_MESSAGE, dynamicName, dynamicErrorMessage);
	}

}
