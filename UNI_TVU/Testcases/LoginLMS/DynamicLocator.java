package LoginLMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicLocator {
	WebDriver driver;

	public static void main(String[] args) {
		String DYNAMIC_PAGES_INTERACTION="//td[@id='yui_3_17_2_1_1536727490059_25']//img[@title='%s']";
	//	String DYNAMIC_PAGES_LECTURE="";
		
		clickToElement(DYNAMIC_PAGES_INTERACTION, "h2472");
		
		clickToElement(DYNAMIC_PAGES_INTERACTION, "forum");
		
	}
	/*
	 * ham co 1 locator dong
	 */
	public static void clickToElement(String locator, String value) {
		locator=String.format(locator, value);
		System.out.println(locator);	}

	/*
	 * Ham viet de truyen nhieu tham so
	 */
	public static void clickToElement(String locator, String ... value) {
		locator=String.format(locator, (Object[]) value);
		System.out.println(locator);	}
	
}
