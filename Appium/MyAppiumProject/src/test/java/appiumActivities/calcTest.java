package appiumActivities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class calcTest {
  @Test
  public void calc() {
	  DesiredCapabilities caps=new DesiredCapabilities();
	  caps.setCapability("deviceId", "4fdae107");
	  caps.setCapability("deviceName", "Redmi Note 5 Pro");
	  caps.setCapability("platformName", "android");
	  caps.setCapability("appPackage", "com.miui.calculator");
	  caps.setCapability("appActivity", ".cal.CalculatorActivity");
	  
	  AppiumDriver<MobileElement> driver=null;
	  try {
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		System.out.println("Calculator is open");
		
	} 
	  catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		e.printStackTrace();
		
	}
	  
	  driver.quit();
			  }
  
}
