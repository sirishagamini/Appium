package appiumActivities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class MobileWebURL {
	 WebDriverWait wait;
	    AppiumDriver<MobileElement> driver = null;
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  DesiredCapabilities caps=new DesiredCapabilities();
	  caps.setCapability("deviceId", "emulator-5554");
	  caps.setCapability("deviceName", "AOSP on IA Emulator");
	  caps.setCapability("platformName", "android");
	  caps.setCapability("appPackage", "com.android.chrome");
	  caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	  caps.setCapability("noReset", true);
	  
	  URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	  driver = new AndroidDriver<MobileElement>(appServer, caps);
	  wait = new WebDriverWait(driver, 10);
  }
  @Test
  public void testSearchAppium() throws InterruptedException {
	  wait=new WebDriverWait(driver, 10);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.training-support.net/");
	  String pageTitle=driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
	  System.out.println("Title on page is :"+pageTitle);
	  MobileElement aboutButton=driver.findElementByXPath("//android.view.View[@text='About Us']");
	  aboutButton.click();
	  Thread.sleep(1000);
	  String newPageTitle=driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]").getText();
	  System.out.println("Title on new page is: " + newPageTitle);
	  Assert.assertEquals(pageTitle, "Training Support");
	  Assert.assertEquals(newPageTitle, "About Us");
	  
	  
  }

  @AfterTest
  public void closeDown() {
	  //driver.close();
	  driver.quit();
  }

}
