import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DragAndDrop {

public static AppiumDriver driver;
	
	
	public static void main(String[] args) throws MalformedURLException {


		
		DesiredCapabilities capabilites = new DesiredCapabilities();
		
		capabilites.setCapability("device", "Android");
		capabilites.setCapability("deviceName", "Android Emulator");
		capabilites.setCapability("platformVersion", "7.1.1");
		capabilites.setCapability("platformName", "Android");
		
		capabilites.setCapability("appPackage", "com.mobeta.android.demodslv");
		capabilites.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		
		List<WebElement> menu =driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title"));
		
		menu.get(0).click();
	
		List<WebElement> element = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));

		new TouchAction((MobileDriver)driver).longPress(element.get(0)).moveTo(element.get(3)).release().perform();
	
	}

}

