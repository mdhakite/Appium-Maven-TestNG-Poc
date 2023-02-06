package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	AndroidDriver driver;
	AppiumDriverLocalService service;

	@BeforeTest
	public void setUp() {
		System.out.println("Starting the appium Server");
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Madhusudan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Stop the server");
		service.stop();
	}

	@Test(enabled = false)
	public void newApp() throws MalformedURLException, InterruptedException {
		System.out.println("Start Test 2");
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Pixel XL API 31");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("noReset", true);

		desiredCapabilities.setCapability("browserName", "Chrome");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
		driver.get("https://www.google.com");

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Appium");
		searchBox.submit();

		Thread.sleep(3000);
		// driver.quit();

		System.out.println("Done test 2");
	}

	@Test(enabled = true)
	public void AppiumBasics() throws MalformedURLException {
		System.out.println("In Test 1");

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 5 API 31");
		options.setApp(
				"C:\\Users\\Madhusudan\\Documents\\Work\\Appium\\src\\test\\resources\\apps\\ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();

		System.out.println("Test 1 Done!!!");

	}

	@Test(enabled = true)
	public void ChromeApp() throws MalformedURLException, InterruptedException {
		System.out.println("Start Test 2");

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Nexus 6 API 30");
		options.setApp(
				"C:\\Users\\Madhusudan\\Documents\\Work\\Appium\\src\\test\\resources\\apps\\ApiDemos-debug.apk");
		options.setCapability("platformName", "Android");
		options.setCapability("deviceName", "Pixel XL API 31");
		options.setCapability("automationName", "UiAutomator2");
		options.setCapability("platformName", "Android");
		options.setCapability("platformVersion", "11");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();

		System.out.println("Done test 2");
	}
}