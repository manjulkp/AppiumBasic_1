import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class MakeCall {
	
	public static AppiumDriver driver;
	
	
	public static void main(String[] args) throws Exception{

	
	DesiredCapabilities capabilities=new DesiredCapabilities();

	capabilities.setCapability("automationName", "Appium");

	capabilities.setCapability("platformName", "Android");

	capabilities.setCapability("platformVersion","7.1.1");

	capabilities.setCapability("deviceName","Android Emulator");

	capabilities.setCapability("appPackage", "com.android.dialer");
	
	capabilities.setCapability("appActivity", "com.android.dialer/.DialtactsActivity");
	

	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

	Thread.sleep(3000);
	
	WebElement frameLayout = driver.findElement(By.className("android.widget.FrameLayout"));
	WebElement HorizontalScrollView =  frameLayout.findElement(By.className("android.widget.HorizontalScrollView"));
	List<WebElement> actionTab = HorizontalScrollView.findElements(By.className("android.app.ActionBar$Tab"));
	actionTab.get(0).click();
	
	WebElement linearLayout = driver.findElement(By.id("com.android.contacts:id/dialpad"));
	
	//9711191558
			linearLayout.findElement(By.id("com.android.contacts:id/nine")).click();
			linearLayout.findElement(By.id("com.android.contacts:id/seven")).click();
			linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
			linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
			linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
			linearLayout.findElement(By.id("com.android.contacts:id/nine")).click();
			linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
			linearLayout.findElement(By.id("com.android.contacts:id/five")).click();
			linearLayout.findElement(By.id("com.android.contacts:id/five")).click();
			linearLayout.findElement(By.id("com.android.contacts:id/eight")).click();
			
			driver.findElement(By.id("com.android.contacts:id/callbutton")).click();

}

	
}