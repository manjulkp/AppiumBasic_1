import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
 
public class AppiumServerJava {
	
	public void startServer() {
		CommandLine cmd = new CommandLine("C:\\Program Files\\nodejs\\node.exe");
		cmd.addArgument("C:\\Users\\nnjppp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		cmd.addArgument("--address");
		cmd.addArgument("127.0.0.1");
		cmd.addArgument("--port");
		cmd.addArgument("4723");
		
		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(cmd, handler);
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		AppiumServerJava appiumServer = new AppiumServerJava();
		appiumServer.startServer();
		
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
 
		appiumServer.stopServer();
	}
}
