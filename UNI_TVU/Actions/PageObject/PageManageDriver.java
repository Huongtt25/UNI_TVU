package PageObject;

import org.openqa.selenium.WebDriver;

public class PageManageDriver {
	private static LoginActions loginpage;
	private static HomeAtions homepage;
	private static LopHocPageAction lophocpage;
	private static PageHDSDAction pageHDSD;
	private static NopBaiKyNangAction pageNopBaiKyNang;
	//private static Page

	public static LoginActions getLoginPage(WebDriver driver) {
		if (loginpage == null) {
			return new LoginActions(driver);
		}
		return loginpage;

	}

	public static HomeAtions getHomePage(WebDriver driver) {
		if (homepage == null) {
			return new HomeAtions(driver);
		}
		return homepage;
	}

	public static LopHocPageAction getLopHocPage(WebDriver driver) {
		if (lophocpage == null) {
			return new LopHocPageAction(driver);
		}
		return lophocpage;
	}

	public static PageHDSDAction getpageHDSD(WebDriver driver) {
		if (pageHDSD == null) {
			return new PageHDSDAction(driver);
		}
		return pageHDSD;
	}
	public static NopBaiKyNangAction getpageNopBaiKyNang(WebDriver driver) {
		if (pageNopBaiKyNang == null) {
			return new NopBaiKyNangAction(driver);
		}
		return pageNopBaiKyNang;
	}
}
