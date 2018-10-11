import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AddContact {
	
public static AppiumDriver driver;
	
	
	public static void main(String[] args) throws Exception{

	
	DesiredCapabilities capabilities=new DesiredCapabilities();

	capabilities.setCapability("automationName", "Appium");

	capabilities.setCapability("platformName", "Android");

	capabilities.setCapability("platformVersion","7.1.1");

	capabilities.setCapability("deviceName","Android Emulator");
	capabilities.setCapability("appPackage", "com.android.contacts");
	capabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
	

	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

	Thread.sleep(3000);
	
	WebElement frameLayout = driver.findElement(By.id("android:id/action_bar_container"));
	
	List<WebElement> actionBarTabs = frameLayout.findElements(By.className("android.app.ActionBar$Tab"));
	
	actionBarTabs.get(3).click();
	
	driver.findElement(By.id("com.android.contacts:id/create_button")).click();
	
	
	List<WebElement> editTxt = driver.findElements(By.className("android.widget.EditText"));
	
	editTxt.get(0).sendKeys("TestAppium1");
	editTxt.get(1).sendKeys("971111155");
	
	driver.findElement(By.id("com.android.contacts:id/menu_done")).click();
	

}
	
}


