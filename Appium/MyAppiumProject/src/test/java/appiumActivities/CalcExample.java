package appiumActivities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CalcExample {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver=null;
	
 @BeforeClass
	  public void beforeClass() throws MalformedURLException {
	 
	 DesiredCapabilities caps=new DesiredCapabilities();
	  caps.setCapability("deviceId", "4fdae107");
	  caps.setCapability("deviceName", "Redmi Note 5 Pro");
	  caps.setCapability("platformName", "android");
	  caps.setCapability("appPackage", "com.miui.calculator");
	  caps.setCapability("appActivity", ".cal.CalculatorActivity");
	  
	  URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	  driver = new AndroidDriver<MobileElement>(appServer, caps);
	  wait=new WebDriverWait(driver, 10);
	  
	  }
 
 @Test
  public void multiply() {
	 wait=new WebDriverWait(driver, 10);
	 wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='5']"))).click();
	 //driver.findElementByXPath("//android.widget.TextView[@text='5']").click();
	 driver.findElementById("com.miui.calculator:id/btn_mul_s").click();
	 driver.findElementById("com.miui.calculator:id/btn_6_s").click();
	 driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
	 
	 //MobileElement resultelement=driver.findElementById("com.miui.calculator:id/expression");
	 MobileElement resultelement=driver.findElementById("com.miui.calculator:id/result");
	 
	 wait.until(ExpectedConditions.textToBePresentInElement(resultelement, "30"));
	 String result=resultelement.getText();
	 System.out.println(result);
	 Assert.assertEquals(result,"= 30");
	 
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
