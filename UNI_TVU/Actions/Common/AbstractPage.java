package Common;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.KeHoachHocTapMonAction;
import PageObject.LopHocPageAction;
import PageObject.PageHDSDAction;
import PageObject.PageManageDriver;
import TVU.AbstractPageUI;
import TVU.HomeUI;
import TVU.LopHocUI;

public class AbstractPage {

	private static final String LINK_KE_HOACH_HOC_TAP = null;
	//ham mo url
	public void openUrl(WebDriver driver, String URL) {
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	// ham getTitle
	public String getTitle(WebDriver driver) {
		
		return driver.getTitle();
	}
	//ham get url hien tai
	public String getcurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	//Ham back
	public void back(WebDriver driver) {
		 driver.navigate().back();
		
	}
	// ham forward
	public void forward(WebDriver driver) {
		 driver.navigate().forward();
	}
	// ham refresh
	public void refresh(WebDriver driver) {
				 driver.navigate().refresh();
	}
	/*
	 * Ham thao tac voi Element
	 */
	// ham click
	public void clicktoElement(WebDriver driver, String locator) {
		WebElement element= driver.findElement(By.xpath(locator));
		element.click();	
	}
	// ham click vao dynamic locator
	public void clicktoElement(WebDriver driver, String locator, String...value) {
		locator=String.format(locator, (Object[]) value);
		WebElement element=driver.findElement(By.xpath(locator));
		element.click();	
	}
	// ham senkey
	public void senkeytoElement(WebDriver driver, String locator, String value) {
		WebElement element= driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);	
	}
	//ham xu ly dropdown
	public void selectItemInDropDown(WebDriver driver,String locator, String textitem ) {
		WebElement element= driver.findElement(By.xpath(locator));
		Select select= new Select(element);
		select.selectByVisibleText(textitem);
	}
	//Ham xem da get gia tri trong dropdown thanh cong chua
	public String setFristItemSelected(WebDriver driver, String locator ) {
		WebElement element= driver.findElement(By.xpath(locator));
		Select select= new Select(element);
		return select.getFirstSelectedOption().getText();
		
	}
	// ham get gia tri attribute
	
	public String getAttributeValue(WebDriver driver, String locator, String attribute ) {
		WebElement element= driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}
	//get text element
	public String getTextElement(WebDriver driver, String locator) {
		WebElement element= driver.findElement(By.xpath(locator));
		return element.getText();
	}
	//ham get size element
	public int getSizeElement(WebDriver driver, String locator, String value) {
		List <WebElement> elements= driver.findElements(By.xpath(locator));
		return elements.size();	
	}
	//check vao checkbox
	public void checkToCheckBox(WebDriver driver, String locator) {
		WebElement element= driver.findElement(By.xpath(locator));
		if(!element.isSelected()) {
			element.click();
		}
	}
	//un check vao checkbox
	public void unCheckToCheckBox(WebDriver driver, String locator) {
		WebElement element= driver.findElement(By.xpath(locator));
		if(element.isSelected()) {
			element.click();
		}
	}
	//check hien thi
	public boolean isControlDisplay(WebDriver driver, String locator, String... value) {
		locator=String.format(locator, (Object[]) value);
		WebElement element= driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	// kiem tra duoc chon
	
	public boolean isSelected(WebDriver driver, String locator) {
		WebElement element= driver.findElement(By.xpath(locator));
		return element.isSelected();
	}
	//ham enable
	public boolean isEnable(WebDriver driver, String locator) {
		WebElement element= driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	/*
	 *  ham voi alert
	 */
	//accept alert
	public void acceptAlert(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
	}
	// cancel alert
	public void canceltAlert(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		
	}
	// get text alert
		public String getTexttAlert(WebDriver driver) {
			Alert alert=driver.switchTo().alert();
			return alert.getText();
			
		}
	/*
	 *  cac ham ve wait
	 */
		
// wait nhung cai ko nhin thay duoc, nguoi dung khong the thao tac duoc
		public void waitForControlPresence(WebDriver driver, String locator, String...value) {
			locator=String.format(locator, (Object[]) value);
			By by=By.xpath(locator);
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		// wait visible
		public void waitForVisible(WebDriver driver, String locator, String...value) {
			locator=String.format(locator, (Object[]) value);
			WebElement element=driver.findElement(By.xpath(locator));
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		//wait element for click able
		public void waitForClickable(WebDriver driver, String locator) {
			WebElement element=driver.findElement(By.xpath(locator));
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		// wait for invisiable
		public void waitForInVisible(WebDriver driver, String locator, String...value) {
			locator=String.format(locator, (Object[]) value);
			By by=By.xpath(locator);
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		}
		// 
		public void waitForAlertPresence(WebDriver driver) {

			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.alertIsPresent());
		}
		public LopHocPageAction openLophocpage(WebDriver driver, String locator, String btn_vaolophoc) {
			//waitForInVisible(driver, HomeUI.BTN_VAO_LOP);
			clicktoElement(driver, AbstractPageUI.BTN_VAO_LOP, btn_vaolophoc);
			return PageManageDriver.getLopHocPage(driver);
		} 
		public PageHDSDAction openPageHDSD(WebDriver driver, String locator, String page) {
			//	waitForInVisible(driver, LopHocUI.LINK_KE_HOACH_HOC_TAP);
				clicktoElement(driver, AbstractPageUI.DYNAMIC_LINK_TAILIEU,page);
				//PageManageDriver.getpageHDSD(driver).back(driver);
				return PageManageDriver.getpageHDSD(driver);
			}
		public PageHDSDAction openPageTaiLieu(WebDriver driver, String locator, String page) {
			//	waitForInVisible(driver, LopHocUI.LINK_KE_HOACH_HOC_TAP);
				clicktoElement(driver, AbstractPageUI.DYNAMIC_LINK_HDSD, page);
				//PageManageDriver.getpageHDSD(driver).back(driver);
				return PageManageDriver.getpageHDSD(driver);
			}
}
