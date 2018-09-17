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
public class LamBaiTracNghiem extends AbstractTest {

	WebDriver driver;
	String loginUrl, tendangnhap = "poso.test", matKhau = "topica@123";
	private LoginActions loginAction;
	private HomeAtions homeAction;
	private LopHocPageAction lopHocAction;
	private PageManageDriver pageManagerDriver;
	private PageHDSDAction pageHDSD;

	String url = "http://elearning.tvu.topica.vn/login/index.php";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		// tra ve gia tri browser
		driver = openMutilBrowser(browserName);
		// khoi tao doi tuong la trang loginpage
		// pageManagerDriver=new PageManageDriver();
		loginAction = pageManagerDriver.getLoginPage(driver);
	}

	/*
	 * 1. Dang nhap vao he thong voi role la hoc vien 2. Kiem tra xem co da dang
	 * nhap vao dung vo
	 */
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
		Assert.assertTrue(homeAction.verifyMessageDisplayed(),"QUẢN LÝ HỌC TẬP!");
	}

	@Test
	public void TC_02_Vaolop_MoGiaoTrinh_kehoachhoctapmon() {
		/*
		 * open home Lop hoc lay bien lopHocAction để hứng giá trị khi click button
		 * LopHoc tren trang home ham openLophocpage: được viết ở HomeActions
		 */
		lopHocAction = homeAction.openLophocpage(driver);
		/*
		 * open home Lop hoc lay bien lopHocAction để hứng giá trị khi click button
		 * LopHoc tren trang home ham openLophocpage: được viết ở HomeActions
		 */
		pageHDSD = lopHocAction.openPageTaiLieu(driver,AbstractPageUI.DYNAMIC_LINK_HDSD,"Kế hoạch học tập môn");
		pageHDSD.back(driver);
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
