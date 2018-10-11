import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class TestWebApp {

	//Appium Launch on Windows
	private static Process process;
	
	public static void startAppiumServer() throws IOException, InterruptedException {

		Runtime runtime = Runtime.getRuntime();
		try {
			process = runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 \" ");
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	

	Thread.sleep(7000);

	if (process != null) {

	System.out.println("Appium server started");

	}

	}

	
	//Stopping the Appium Server
	
	public static void stopAppiumServer() throws IOException {

	if (process != null) {

	process.destroy();

	}

	System.out.println("Appium server stopped");

	}

	public static void main(String[] args) throws Exception{

	stopAppiumServer();

	startAppiumServer();

	DesiredCapabilities capabilities=new DesiredCapabilities();

	capabilities.setCapability("automationName", "Appium");

	capabilities.setCapability("platformName", "Android");

	capabilities.setCapability("platformVersion","7.1.1");

	capabilities.setCapability("deviceName","Android Emulator");

	capabilities.setCapability("appPackage","io.selendroid.testapp");

	capabilities.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");

	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

	driver.findElementById("io.selendroid.testapp:id/startUserRegistration").click();

	Thread.sleep(3000);

	driver.quit();

	stopAppiumServer();

	}
}
