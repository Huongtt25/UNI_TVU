package LoginLMS;

import org.testng.annotations.Test;

import Common.AbstractTest;
import PageObject.HomeAtions;
import PageObject.LoginActions;
import PageObject.LopHocPageAction;
import PageObject.LuyenTapTracNghiemAction;
import PageObject.NopBaiKyNangAction;
import PageObject.PageManageDriver;
import TVU.AbstractPageUI;
import TVU.LopHocUI;
import TVU.NopBaiKyNangUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class NopBaiTapKyNang extends AbstractTest {
	WebDriver driver;
	String loginUrl, tendangnhap = "poso.test", matKhau = "topica@123";
	private LoginActions loginAction;
	private HomeAtions homeAction;
	private LopHocPageAction lopHocAction;
	private PageManageDriver pageManagerDriver;
	private NopBaiKyNangAction NopBaiKyNang;
	String workingDirectory= System.getProperty("user.dir");
	String filePath= workingDirectory + "\\FileUpload\\checklist.xlsx";
	String url = "http://elearning.tvu.topica.vn/login/index.php";

  @Test
  public void TC_01_Login_HV() {
		// loginAction.openUrl(driver, url);
				log.info("Login_02- mo link url");
				loginUrl = loginAction.getLoginUrl();
				// b1: input user
				log.info("nhap du lieu vao user");
				loginAction.inputTenDangNhap(tendangnhap);
				// b2: input mat khau
				loginAction.inputMatKhau(matKhau);
				// b3: click button login
				homeAction = loginAction.clickBtnLogin();
				// b4: verify message
				log.info("kiem tra message thong bao");
				// homeAction.verifyMessageDisplayed();
				//Assert.assertTrue(homeAction.verifyMessageDisplayed(),"QUẢN LÝ HỌC TẬP!");
	  
  }
	  public void TC_02_NopBaiKyNang() throws InterruptedException {
	 
	 lopHocAction = homeAction.openLophocpage(driver,AbstractPageUI.BTN_VAO_LOP,"/course/view.php?id=4364");
	 lopHocAction.clicktoElement(driver, LopHocUI.LINK_NOP_BAI_KY_NANG);
	// NopBaiKyNang.UploadFile();
	 
 }	
 @Test
 public void TC_03_NopBaiKyNang() throws InterruptedException, IOException {

lopHocAction = homeAction.openLophocpage(driver,AbstractPageUI.BTN_VAO_LOP,"/course/view.php?id=4364");
lopHocAction.clicktoElement(driver, LopHocUI.LINK_NOP_BAI_KY_NANG);
Thread.sleep(3000);
WebElement element=driver.findElement(By.cssSelector(".table_list>tbody>tr>td>input"));
element.click();
Thread.sleep(3000);
Runtime.getRuntime().exec(new String[] { ".\\AutoIT\\chrome.exe", filePath });


}	
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	// tra ve gia tri browser
			driver = openMutilBrowser(browserName);
			// khoi tao doi tuong la trang loginpage
			// pageManagerDriver=new PageManageDriver();
			loginAction = pageManagerDriver.getLoginPage(driver);  
  }

  @AfterClass
  public void afterClass() {
	  closeBrowser(driver);
  }

}
