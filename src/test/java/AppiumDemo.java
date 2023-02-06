

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumDemo {

	AndroidDriver driver;
	AppiumDriverLocalService service;

	@BeforeMethod
	@Parameters({"deviceName","platformVersion","portNumber"})
	public void initiateDriver(String deviceName, String platformVersion, String portNumber) throws MalformedURLException {
		startAppiumService(portNumber);
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", deviceName);
		desiredCapabilities.setCapability("platformVersion", platformVersion);
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appiumJS",new File("C:\\Users\\Madhusudan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));
		desiredCapabilities.setCapability("ipAddress", "127.0.0.1");
		desiredCapabilities.setCapability("port", portNumber);
		driver = new AndroidDriver(new URL("http://127.0.0.1:"+portNumber), desiredCapabilities);
		
	}

	public void startAppiumService(String portNumber) {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Madhusudan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(Integer.parseInt(portNumber)).build();
		service.start();
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Stop the server");
		service.stop();
	}

	@Test(enabled = true)
	public void methodOne() throws MalformedURLException, InterruptedException {
		System.out.println("Start Method 1");
	
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
		Thread.sleep(3000);
		// driver.quit();

		System.out.println("Done test 1");
	}
	
	@Test(enabled = true)
	public void methodTwo() throws MalformedURLException, InterruptedException {
		System.out.println("Start Method 2");
	
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
		Thread.sleep(3000);
		// driver.quit();

		System.out.println("Done test 2");
	}

}