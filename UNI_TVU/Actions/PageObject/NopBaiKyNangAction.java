package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Common.AbstractPage;
import TVU.NopBaiKyNangUI;

public class NopBaiKyNangAction extends AbstractPage{
	WebDriver driver;
	String workingDirectory= System.getProperty("user.dir");
	String filePath= workingDirectory + "\\FileUpload\\checklist.xlsx";
	
	public NopBaiKyNangAction(WebDriver mapdriver) {
		driver=mapdriver;
	}
/*
 * 	public LoginActions(WebDriver mapdriver) {
 * 	driver=mapdriver;
	}
 */
  public void UploadFile() throws InterruptedException {
      System.out.println(filePath);
    //  clicktoElement(driver,NopBaiKyNangUI.BTN_UPLOAD_FILE);
	 senkeytoElement(driver, NopBaiKyNangUI.BTN_UPLOAD_FILE, filePath);
	 Thread.sleep(3000);
	 clicktoElement(driver, NopBaiKyNangUI.BTN_LUU);
  }
 //public void verify_UploadFile() {
//	 Assert.assertTrue(NopBaiKyNangUI.LABEL_MESSAGE.isDisplayed());
// }

}
