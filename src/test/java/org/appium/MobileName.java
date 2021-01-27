package org.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MobileName {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "onePlus Nord");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("appPackage", "com.snapdeal.main");
		cap.setCapability("appActivity", "com.snapdeal.ui.material.activity.MaterialMainActivity");

		URL u = new URL("http://localhost:4723/wd/hub");

		AppiumDriver driver = new AppiumDriver(u, cap);

		Thread.sleep(5000);
		WebElement close = driver.findElement(By.id("com.snapdeal.main:id/close"));
		close.click();

		Dimension size = driver.manage().window().getSize();

		Double start = size.getHeight() * 0.5;
		int startHeight = start.intValue();

		Double end = size.getHeight() * 0.2;
		int endHeight = end.intValue();

		TouchAction tc = new TouchAction(driver);
		tc.press(PointOption.point(0, startHeight)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(0, endHeight)).release().perform();

		Double start1 = size.getHeight() * 0.2;
		int startHeight1 = start1.intValue();

		Double end1 = size.getHeight() * 0.5;
		int endHeight1 = end1.intValue();

		tc.press(PointOption.point(0, startHeight1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(0, endHeight1)).release().perform();

	}
}
