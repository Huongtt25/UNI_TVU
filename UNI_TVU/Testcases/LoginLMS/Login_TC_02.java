package LoginLMS;

import org.testng.annotations.Test;

import Common.AbstractTest;
import PageObject.HomeAtions;
import PageObject.KeHoachHocTapMonAction;
import PageObject.LoginActions;
import PageObject.LopHocPageAction;
import PageObject.PageHDSDAction;
import TVU.AbstractPageUI;
import TVU.LoginUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import PageObject.PageManageDriver;
//extend: ke thua
public class Login_TC_02 extends AbstractTest{
	
	WebDriver driver;
	String loginUrl, tendangnhap="poso.test", matKhau="topica@123";
	private LoginActions loginAction;
	private HomeAtions homeAction;
	private LopHocPageAction lopHocAction;
	private PageHDSDAction pageHDSD;
	private PageManageDriver pageManager;
	
	
	
     String url="http://elearning.tvu.topica.vn/login/index.php";
  /*   @Parameters({"browser", "version"})
     
     @BeforeClass
	  public void beforeClass(String browserName, String browserVersion) {
	// tra ve gia tri browser
	    pageManager= new PageManageDriver();
		driver= openMutilBrowser(browserName,browserVersion );
		// khoi tao doi tuong la trang loginpage
	//	pageManagerDriver=new PageManageDriver();
		loginAction= pageManager.getLoginPage(driver);
}
*/
@Parameters("browser")

@BeforeClass
	  public void beforeClass(String browserName) {
	// tra ve gia tri browser
	    pageManager= new PageManageDriver();
		driver= openMutilBrowser(browserName);
		// khoi tao doi tuong la trang loginpage
	//	pageManagerDriver=new PageManageDriver();
		loginAction= pageManager.getLoginPage(driver);
}
/*
 * 1. Dang nhap vao he thong voi role la hoc vien
 * 2. Kiem tra xem co da dang nhap vao dung vo                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
 */
@Test
public void TC_01_Login_HV() { 
	 // loginAction.openUrl(driver, url);
	  log.info("Login_02- mo link url");
   	  loginUrl= loginAction.getLoginUrl();
	  //b1: input user
   	  log.info("nhap du lieu vao user");
	  loginAction.inputTenDangNhap(tendangnhap);
	  //b2: input mat khau
	  loginAction.inputMatKhau(matKhau);
	  //b3: click button login
	  homeAction=  loginAction.clickBtnLogin();
	  //b4: verify message
	  log.info("kiem tra message thong bao");
	  homeAction.verifyMessageDisplayed();
	  Assert.assertTrue(homeAction.verifyMessageDisplayed(), "QUẢN LÝ HỌC TẬP!");
    
}
@Test
public void TC_02_Vaolop_kehoachhoctap(){
	/*
	 *  open home Lop hoc
	 *  lay bien lopHocAction để hứng giá trị khi click button LopHoc tren trang home
	 *  ham openLophocpage: được viết ở HomeActions 
	 */ 
	lopHocAction = homeAction.openLophocpage(driver);
	/*
	 *  open home Lop hoc
	 *  lay bien lopHocAction để hứng giá trị khi click button LopHoc tren trang home
	 *  ham openLophocpage: được viết ở HomeActions 
	 */ 
		pageHDSD = lopHocAction.openPageHDSD(driver,AbstractPageUI.DYNAMIC_LINK_HDSD, "kế hoạch học tập môn");
		
}
@Test
public void TC_03_Vaolop_HDSD_C5(){
	/*
	 *  open home Lop hoc
	 *  lay bien lopHocAction để hứng giá trị khi click button LopHoc tren trang home
	 *  ham openLophocpage: được viết ở HomeActions 
	 */ 
	//	pageHDSD.back(driver);
	/*
	 *  open home Lop hoc
	 *  lay bien lopHocAction để hứng giá trị khi click button LopHoc tren trang home
	 *  ham openLophocpage: được viết ở HomeActions 
	 */ 
	//   lopHocAction = homeAction.openLophocpage(driver);
	   pageHDSD = lopHocAction.openPageHDSD(driver,AbstractPageUI.DYNAMIC_LINK_HDSD, "Hướng dẫn sinh viên sử dụng C5");
}
@Test
public void TC_04_Vaolop_HDSD_chupmanhinh(){
	/*
	 *  open home Lop hoc
	 *  lay bien lopHocAction để hứng giá trị khi click button LopHoc tren trang home
	 *  ham openLophocpage: được viết ở HomeActions 
	 */ 
	lopHocAction = homeAction.openLophocpage(driver);
	/*
	 *  open home Lop hoc
	 *  lay bien lopHocAction để hứng giá trị khi click button LopHoc tren trang home
	 *  ham openLophocpage: được viết ở HomeActions 
	 */ 
	//pageHDSD = lopHocAction.openPageHDSD(driver, "Hướng dẫn sinh viên chụp ảnh màn hình");
}
@Test
public void TC_05_Vaolop_HDSD_giainen(){
	/*
	 *  open home Lop hoc
	 *  lay bien lopHocAction để hứng giá trị khi click button LopHoc tren trang home
	 *  ham openLophocpage: được viết ở HomeActions 
	 */ 
	lopHocAction = homeAction.openLophocpage(driver);
	/*
	 *  open home Lop hoc
	 *  lay bien lopHocAction để hứng giá trị khi click button LopHoc tren trang home
	 *  ham openLophocpage: được viết ở HomeActions 
	 */ 
	//pageHDSD = lopHocAction.openPageHDSD(driver, "Hướng dẫn nén File .rar");
}

@AfterClass
public void afterClass() {
closeBrowser(driver);
}



}
