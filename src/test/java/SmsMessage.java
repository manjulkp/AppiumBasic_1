import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SmsMessage {
public static AppiumDriver driver;
	
	
	public static void main(String[] args) throws Exception{

	
	DesiredCapabilities capabilities=new DesiredCapabilities();

	capabilities.setCapability("automationName", "Appium");

	capabilities.setCapability("platformName", "Android");

	capabilities.setCapability("platformVersion","7.1.1");

	capabilities.setCapability("deviceName","Android Emulator");

	capabilities.setCapability("appPackage", "com.android.mms");
	capabilities.setCapability("appActivity", "com.android.mms.ui.ConversationComposer");
	
	driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	
	WebElement actionBar = driver.findElement(By.id("android:id/action_bar"));
	
	List<WebElement> textView = actionBar.findElements(By.className("android.widget.TextView"));
	
	System.out.println(textView.size());
	
	textView.get(1).click();
	
	driver.findElement(By.id("com.android.mms:id/recipients_editor_to")).sendKeys("9711111558");
	
	driver.findElement(By.id("com.android.mms:id/mms_rich_composer_linear")).sendKeys("Sending message through Appium");
	
	driver.findElement(By.id("com.android.mms:id/send_button")).click();			
	

}

}

	



