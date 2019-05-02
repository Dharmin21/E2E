package tests;
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
 
public class NewTest {
 

public WebDriver driver=null;

 
  @Test(priority=1)
  public void openMyBlog() {
	  System.out.println("test-1");
 driver.get("https://prod.nestle-collect.com/nestleadmin/login");
 WebDriverWait wait = new WebDriverWait (driver, 20);
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//input[@placeholder='Email / Username']")));
 
 //Send Email ID
 WebElement email=driver.findElement(By.xpath("//input[@placeholder='Email / Username']"));
 email.sendKeys("admin");
 
 //Send Password
 WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
password.sendKeys("123456");
Date d = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
	// Now you can do whatever you need to do with it, for example copy somewhere
try {
	FileUtils.copyFile(scrFile,  new File("C:\\Users\\Rupika\\Desktop\\screenshot\\"+sdf.format(d)+".png"));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//Click Login Button
driver.findElement(By.xpath("//button[@id='m_login_signin_submit']")).click();


String b= driver.getTitle();
System.out.println(b);
String currentURL =   driver.getCurrentUrl();
String ExpectedURL = "https://prod.nestle-collect.com/nestleadmin/dashboard"; 
Assert.assertEquals(currentURL,ExpectedURL);
Date d1 = new Date();
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
	// Now you can do whatever you need to do with it, for example copy somewhere
try {
	FileUtils.copyFile(scrFile1,  new File("C:\\Users\\Rupika\\Desktop\\screenshot\\"+sdf1.format(d1)+".png"));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


  }
  
  @Test(priority=2)
  public void openMyBlog1() {
	  System.out.println("test-2");
 driver.get("https://prod.nestle-collect.com/nestleadmin/dashboard");

WebDriverWait wait = new WebDriverWait (driver, 20);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[8]/a[1]/span[1]")));

driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[8]/a[1]/span[1]")).click();


driver.findElement(By.xpath("//span[contains(text(),'List Consumers')]")).click();

WebElement name=driver.findElement(By.xpath("//input[@name='filter_name']"));
name.sendKeys("test");

driver.findElement(By.xpath("//button[@id='m_search']")).click();


WebElement item=driver.findElement(By.xpath("//td[contains(text(),'1234567w')]"));
String text=item.getText();
String actualtext = "1234567w";
Assert.assertEquals(text,actualtext);
Date d = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
	// Now you can do whatever you need to do with it, for example copy somewhere
try {
	FileUtils.copyFile(scrFile,  new File("C:\\Users\\Rupika\\Desktop\\screenshot\\"+sdf.format(d)+".png"));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

  }




@BeforeClass
  public void beforeClass() {
   System.out.println("before");
   System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\geckodriver.exe");
   driver = new FirefoxDriver();
   File dir1 = new File("ABZ");  //Specify the Folder name here

   dir1.mkdir( );  //Creates the folder with the above specified name
   
  }
 
  @AfterClass
  public void afterClass() {
	  System.out.println("after");
   driver.quit();
  }
}
