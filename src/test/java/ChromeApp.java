import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChromeApp {
public static AndroidDriver driver;
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		File app = new File("C:\\Users\\nnjppp\\appium\\AppiumBasic_1\\src\\test\\resources\\com\\appium\\applocation\\bk-mobile-native.apk");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setCapability("automationName","Selendroid");

		 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android Emulator");
		 capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		 capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		  
	  
	       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	       
	      driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
	       
	      waitForElementPresent(By.id("button1"), 40);
	    	driver.findElement(By.id("button1")).click();
	    	
	       Thread.sleep(30000);
	       
	      Set<String> contextNames = driver.getContextHandles();
	        for (String contextName : contextNames) {
	          System.out.println(contextName);
	          if (contextName.contains("WEBVIEW")){
	            driver.context(contextName);
	          }
	        }
	        
	        
	        
	         
	        System.out.println(driver.getPageSource());
	        waitForElementPresent(By.id("ext-comp-1024"), 40);
	        driver.findElement(By.id("ext-comp-1024")).click();
	        
	        
	        
	    	Thread.sleep(10000);
	    	
	    	
	    	waitForElementPresent(By.cssSelector("div[data-index='1']"), 40);
	        driver.findElement(By.cssSelector("div[data-index='1']")).click();	      


	        contextNames = driver.getContextHandles();
	        for (String contextName : contextNames) {
	          System.out.println(contextName);
	          if (contextName.contains("NATIVEVIEW")){
	            driver.context(contextName);
	          }
	        }
	        

	}
	
	  public static void waitForElementPresent(final By by, int timeOutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	        
	        wait.until(new ExpectedCondition<Boolean>() {

	        
			@Override
			public Boolean apply(WebDriver d) {
				// TODO Auto-generated method stub
				return d.findElement(by).isDisplayed();
			}
	        });
	     }


}
