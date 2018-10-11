import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Swipe {
	
	public static AppiumDriver driver;

public static void main(String[] args) throws MalformedURLException {
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	capabilities.setCapability("deviceName","Android");
	capabilities.setCapability("platformVersion", "4.4.2");
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("appPackage", "flipboard.app");
	capabilities.setCapability("appActivity", "flipboard.activities.LaunchActivity");
	
	driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	
	List <WebElement> ele =driver.findElements(By.id("flipboard.app:id/coverStoryContainer"));
	ele.get(0).click();
	
	clickLayout(0);
	swipeFromUpToBottom();  
	
	
}

//Code to Swipe UP
public static boolean swipeFromUpToBottom()
{
try {
JavascriptExecutor js = (JavascriptExecutor) driver;
HashMap<String, String> scrollObject = new HashMap<String, String>();
scrollObject.put("direction", "up");
js.executeScript("mobile: scroll", scrollObject);
System.out.println("Swipe up was Successfully done.");
}
catch (Exception e)
{
System.out.println("swipe up was not successfull");
}
return false;
}
//Code to Swipe DOWN
public static boolean swipeFromBottomToUp()
{
try {
JavascriptExecutor js = (JavascriptExecutor) driver;
HashMap<String, String> scrollObject = new HashMap<String, String>();
scrollObject.put("direction", "down");
js.executeScript("mobile: scroll", scrollObject);
System.out.println("Swipe down was Successfully done");
}
catch (Exception e)
{
System.out.println("swipe down was not successfull");
}
return false;
}
//Code for carousel images swipe

public static boolean swipeImages()
{
try {
WebElement pageIndicator = driver.findElementByClassName("page_indicator");
String pageString= pageIndicator.getAttribute("value");
int length = pageString.length();
String count_string= pageString.substring(length-2, length).trim();
int count = Integer.parseInt(count_string);
System.out.println("Number of Image available to Swipe: "+count);
for (int i=0; i<=count; i++){
JavascriptExecutor js = (JavascriptExecutor) driver;
HashMap<String, String> scrollObject = new HashMap<String, String>();
scrollObject.put("direction", "right");
js.executeScript("mobile: scroll", scrollObject);
}
System.out.println("Swipe Successfully");
}
catch (Exception e)
{
System.out.println("Image swipe was not successfull");
}
return false;
}



public static void clickLayout(int x){	
	WebElement flipboard =driver.findElement(By.id("flipboard.app:id/tilesContainer"));
	List<WebElement> frameLayout = flipboard.findElements(By.className("android.widget.FrameLayout"));
	frameLayout.get(x).click();	
}

}