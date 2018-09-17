package LoginLMS;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Login_TC01_stepbystep {
	WebDriver driver;
	
	
  @BeforeClass
	  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver",".\\Resources\\chromedriver.exe" );
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://elearning.tvu.topica.vn/login/index.php");
	  }
  /*
   * 1. Dang nhap vao he thong voi role la hoc vien
   * 2. Kiem tra xem co da dang nhap vao dung vo                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
   */
  @Test
  public void TC_01_Login_HV() {
	  //b1: tim txtbox user
	  WebElement txt_tendangnhap= driver.findElement(By.xpath("//input[@id='username']"));
	  //b2:click textbox user
	  txt_tendangnhap.click();
	  //b3: nhap user
	  txt_tendangnhap.sendKeys("poso.test");
	  
	  WebElement txt_matkhau=driver.findElement(By.xpath("//input[@id='password']"));
	  txt_matkhau.click();
	  txt_matkhau.sendKeys("topica@123");
	  WebElement btn_Dangnhap = driver.findElement(By.xpath("//button[@id='loginbtn']"));
	  btn_Dangnhap.click();
	  String message_Role_HV=driver.findElement(By.xpath("//span[contains(text(),'QUẢN LÝ HỌC TẬP')]")).getText();
      Assert.assertEquals("QUẢN LÝ HỌC TẬP",message_Role_HV );
      
  }
  @Test
  public void TC_02_Vaolop_Kehoachhoctap(){
	  
	 WebElement btn_Vaolop=driver.findElement(By.xpath("//a[@ href='/course/view.php?id=6413' and contains(text(),'VÀO LỚP')]"));
	 btn_Vaolop.click();
	 WebElement linktext_kehoachhoctapmon=driver.findElement(By.xpath("//a[contains(text(),'Kế hoạch học tập môn')]"));
	 linktext_kehoachhoctapmon.click();
	 String url_kehoachhoctap=driver.getCurrentUrl();
	 System.out.print(url_kehoachhoctap);
	 
	 // Thread.sleep(50000);
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
