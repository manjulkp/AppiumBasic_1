
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AndroidKeyAction {
public static AndroidDriver<WebElement> driver;
	
	
	public static void main(String[] args) throws MalformedURLException {


		
		DesiredCapabilities capabilites = new DesiredCapabilities();
		
		capabilites.setCapability("device", "Android");
		capabilites.setCapability("deviceName", "GT-N7100");
		capabilites.setCapability("platformVersion", "4.4.3");
		capabilites.setCapability("platformName", "Android");
		
		capabilites.setCapability("appPackage", "com.android.mms");
		capabilites.setCapability("appActivity", "com.android.mms.ui.ConversationComposer");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		WebElement actionBar = driver.findElement(By.id("android:id/action_bar"));
		
		List<WebElement> textView = actionBar.findElements(By.className("android.widget.TextView"));
		
		System.out.println(textView.size());
		
		textView.get(1).click();
		
		driver.findElement(By.id("com.android.mms:id/recipients_editor_to")).sendKeys("9711111558");
		
		WebElement ele = driver.findElement(By.id("com.android.mms:id/mms_rich_composer_linear"));
		ele.sendKeys("Sending message through Appium");
			
		
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		driver.pressKeyCode(AndroidKeyCode.BACKSPACE);
		driver.pressKeyCode(AndroidKeyCode.BACKSPACE);
		driver.pressKeyCode(AndroidKeyCode.BACKSPACE);
		driver.pressKeyCode(AndroidKeyCode.HOME);
		
	}

}

