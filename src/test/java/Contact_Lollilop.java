import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Contact_Lollilop {


public static AndroidDriver driver;

public static void main(String[] args) throws MalformedURLException {
	

DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
capabilities.setCapability("device", "Android");
capabilities.setCapability("deviceName", "Galaxy Note3");
capabilities.setCapability("platformVersion", "5.0");
capabilities.setCapability("platformName","Android");

capabilities.setCapability("appPackage",
		"com.android.contacts");
capabilities.setCapability("appActivity",
		"com.android.contacts.activities.PeopleActivity");
driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

List<WebElement> ele = driver.findElements(By.id("com.android.contacts:id/tab_custom_layout"));
ele.get(3).click();

//driver.scrollTo("alan").click();

String str="alan";
driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+str+"\").instance(0))").click();

/*
int i=0;

boolean firstTime=true;



while (true)
{
	
	WebElement frameLayout = driver.findElement(By.id("android:id/list"));
	List<WebElement> contacts = frameLayout.findElements(By.className("android.widget.TextView"));
	System.out.println(contacts.get(i).getText());
    if (contacts.get(i).getText().equalsIgnoreCase("amoolya"))
    {
    	
    	swipe(generateY(contacts.get(i).getLocation()));
        break;
    }
   
    if(i==8)
    {
   	if (firstTime)
   	{ i=0;
      horizontalswipe();
   	}
    }
    i++;
    
}
*/

}


public static void swipe(double y)
{  
	
	
JavascriptExecutor js = (JavascriptExecutor) driver;
HashMap<String, Double> swipeObject = new HashMap<String, Double>();
swipeObject.put("startX", 164.00);
swipeObject.put("startY", y);
swipeObject.put("endX", 500.00);
swipeObject.put("endY", y);
swipeObject.put("duration", 1.0);
js.executeScript("mobile: swipe", swipeObject);
 }

public static void horizontalswipe()
{  
	JavascriptExecutor js = (JavascriptExecutor) driver;
HashMap<String, Double> swipeObject = new HashMap<String, Double>();
swipeObject.put("startX", 116.00);
swipeObject.put("startY", 1268.00);
swipeObject.put("endX", 164.00);
swipeObject.put("endY", 1118.00);
swipeObject.put("duration", 2.0);
js.executeScript("mobile: swipe", swipeObject);
 }

public int generateX(Point point)
{
	int x=point.getX();
	return x;

}
public static int generateY(Point point)
{
	int y=point.getY();
	return y;

}


}



