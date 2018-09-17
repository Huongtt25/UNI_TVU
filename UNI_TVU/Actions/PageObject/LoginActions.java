package PageObject;

import org.openqa.selenium.WebDriver;
import TVU.LoginUI;
import Common.AbstractPage;
import PageObject.PageManageDriver;


public class LoginActions extends AbstractPage{
	
	WebDriver driver;
	// de map cac driver giua cac page (ham khoi tao)
	public LoginActions(WebDriver mapdriver) {
		driver=mapdriver;
	}
	// ham get url 
    public String getLoginUrl() {
    	return getcurrentUrl(driver);
    }
    //input ten dang nhap
   public void inputTenDangNhap(String tenDangNhap) {
	   waitForVisible(driver,LoginUI.TXT_TEN_DANG_NHAP);
	   clicktoElement(driver, LoginUI.TXT_TEN_DANG_NHAP);
	   senkeytoElement(driver, LoginUI.TXT_TEN_DANG_NHAP, tenDangNhap);
   }
   //input Mat khau
   public void inputMatKhau(String matKhau) {
	   waitForVisible(driver,LoginUI.TXT_MAT_KHAU);
	   clicktoElement(driver, LoginUI.TXT_MAT_KHAU);
	   senkeytoElement(driver, LoginUI.TXT_MAT_KHAU, matKhau);
   }
   public HomeAtions clickBtnLogin() {
	   waitForVisible(driver,LoginUI.BTN_DANG_NHAP);
	   clicktoElement(driver, LoginUI.BTN_DANG_NHAP);
	   return PageManageDriver.getHomePage(driver);
   }
}
