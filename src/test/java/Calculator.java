import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Calculator {
	
	public static AppiumDriver driver;
	public WebElement frameLayout;
	
	
	@BeforeMethod
	public void setUp() throws MalformedURLException{
		
        DesiredCapabilities capabilites = new DesiredCapabilities();		
		capabilites.setCapability("device", "Android");
		capabilites.setCapability("deviceName", "Android Emulator");
		capabilites.setCapability("platformVersion", "7.1.1");
		capabilites.setCapability("platformName", "Android");		
		capabilites.setCapability("appPackage", "com.android.calculator2");
		capabilites.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		frameLayout = driver.findElement(By.className("android.widget.FrameLayout"));
		
		
			
	}
	
	@Test(priority = 1)
	public void add(){
		
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/op_add")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/eq")).click();
		String text = frameLayout.findElement(By.id("com.android.calculator2:id/result")).getText();
		//System.out.println(text);
		
		//String calc[] = text.split(". Editing.");
		//System.out.println(calc[0]);
		
			//String actual_num[] = calc[0].split("=");
			//System.out.println(actual_num[1]);
			
			Assert.assertEquals(text, "12");
			//Assert.assertEquals(actual_num[1], "12");
	
	}
	
	
	@Test(priority = 2)
	public void sub(){
		
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/op_sub")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/eq")).click();
		String text = frameLayout.findElement(By.id("com.android.calculator2:id/result")).getText();

//		String calc[] = text.split(". Editing.");
//		//System.out.println(calc[0]);
//		
//			String actual_num[] = calc[0].split("=");
//			System.out.println(actual_num[1]);
//			Assert.assertEquals(actual_num[1], "2");
		Assert.assertEquals(text, "2");
	}
	
	@Test(priority = 3)
	public void mult(){
		
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/op_mul")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/eq")).click();
		String text = frameLayout.findElement(By.id("com.android.calculator2:id/result")).getText();

//		String calc[] = text.split(". Editing.");
//		//System.out.println(calc[0]);
//		
//			String actual_num[] = calc[0].split("=");
//			System.out.println(actual_num[1]);
//	
//			Assert.assertEquals(actual_num[1], "12");
		
		Assert.assertEquals(text, "35");
		
	}
	
	@Test(priority = 4)
	public void div(){
		
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/op_div")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		frameLayout.findElement(By.id("com.android.calculator2:id/eq")).click();
		String text = frameLayout.findElement(By.id("com.android.calculator2:id/result")).getText();

//		String calc[] = text.split(". Editing.");
//		//System.out.println(calc[0]);
//	
//		String actual_num[] = calc[0].split("=");
//		System.out.println(actual_num[1]);
//		Assert.assertEquals(actual_num[1], "1");
		Assert.assertEquals(text, "1");
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}

}

