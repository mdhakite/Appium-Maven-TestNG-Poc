
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

public class AppiumDemo2 {

	AndroidDriver driver;
	AppiumDriverLocalService service;

	public void startAppiumService(String portNumber) {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Madhusudan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(Integer.parseInt(portNumber)).build();
		service.start();
	}

	@Test(enabled = true)
	public void methodOne() throws MalformedURLException, InterruptedException {
		System.out.println("Start Method 1 with Device Pixel 5 API 31");
		String PORT = "4724";

		startAppiumService(PORT);
		System.out.println("Started Server at PORT " + PORT);

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "Pixel 5 API 31");
		desiredCapabilities.setCapability("platformVersion", "12");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		
	
		desiredCapabilities.setCapability("noReset", "true");
		desiredCapabilities.setCapability("avd", "Pixel_5_API_31");
		desiredCapabilities.setCapability("avdArgs", "-no-window");
		
		desiredCapabilities.setCapability("udid", "emulator-5554");
		desiredCapabilities.setCapability("port", Integer.parseInt(PORT));

		desiredCapabilities.setCapability("appPackage", "com.google.android.deskclock");
		desiredCapabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");

		driver = new AndroidDriver(new URL("http://127.0.0.1:" + PORT), desiredCapabilities);

		System.out.println("Opened Clock!!");

		Thread.sleep(3000);

		service.stop();

		System.out.println("Server STOPPED");

	}

	@Test(enabled = true)
	public void methodTwo() throws MalformedURLException, InterruptedException {

		System.out.println("Start Method 2 with Device Pixel XL API 31");
		String PORT = "4723";

		startAppiumService(PORT);
		System.out.println("Started Server at PORT " + PORT);

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "Pixel XL API 31");
		desiredCapabilities.setCapability("platformVersion", "13");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

		desiredCapabilities.setCapability("noReset", "true");
		desiredCapabilities.setCapability("avd", "Pixel_XL_API_31");
		desiredCapabilities.setCapability("avdArgs", "-no-window");
		
		desiredCapabilities.setCapability("udid", "emulator-5556");
		desiredCapabilities.setCapability("port", Integer.parseInt(PORT));

		desiredCapabilities.setCapability("appPackage", "com.google.android.deskclock");
		desiredCapabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");

		driver = new AndroidDriver(new URL("http://127.0.0.1:" + PORT), desiredCapabilities);

		System.out.println("Opened Clock!!");

		Thread.sleep(3000);

		service.stop();

		System.out.println("Server STOPPED");

	}

}