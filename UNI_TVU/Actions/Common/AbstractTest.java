package Common;

import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AbstractTest {
	WebDriver driver;
	/*
	 * hàm ghi log, class nao ke thua abstract test thi moi dung dc log
	 */
	protected final Log log;

	// ham khoi tao log dau tien moi khi co ham nao goi den AbstractTest
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	/*
	 * public WebDriver openMutilBrowser(String browserName, String browserVersion)
	 * { if(browserName.equals("Chrome")) {
	 * ChromeDriverManager.getInstance().version(browserVersion).setup(); //
	 * System.setProperty("webdriver.chrome.driver",
	 * ".\\Resources\\chromedriver.exe"); driver= new ChromeDriver(); }else
	 * if(browserName.equals("Firefox")) {
	 * FirefoxDriverManager.getInstance().setup(); driver= new FirefoxDriver();
	 * }else { System.out.println("khong tim thay browser"); }
	 * 
	 * driver.get("http://elearning.tvu.topica.vn/login/index.php");
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * driver.manage().window().maximize(); return driver; }
	 */

	/*
	 * viet ko theo
	 */

	public WebDriver openMutilBrowser(String browserName) {
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("khong tim thay browser");
		}

		driver.get("http://elearning.tvu.topica.vn/login/index.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	protected boolean verifyTrue(boolean condition) {
		return verifyPassed(condition, false);

	}

	private boolean verifyPassed(boolean condition, boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

	// ham close browser
	protected void closeBrowser(WebDriver driver) {
		try {
			// xac dinh duoc os dang chay
			String osName = System.getProperty("os.name").toLowerCase();
			String cmd = "";
			driver.quit();
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else {
					// cau lenh command line de dong process chrome dang chay
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				Process process = Runtime.getRuntime().exec(cmd);
			}
			if (driver.toString().toLowerCase().contains("firefox")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				Process process = Runtime.getRuntime().exec(cmd);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
