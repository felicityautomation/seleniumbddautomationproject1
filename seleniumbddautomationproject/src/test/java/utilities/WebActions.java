package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class WebActions {
	
	public static void openUrl(RemoteWebDriver driver,String url) {
		driver.get(url);
		Reporter.log("Launched the browser with the URL:="+url);
	}
	
	public static void setText(RemoteWebDriver driver,By locator,String value) {
		driver.findElement(locator).sendKeys(value);
		Reporter.log("Set the field with locator:="+locator.toString()+" with value:="+value);
	}
	
	public static void click(RemoteWebDriver driver,By locator) {
		driver.findElement(locator).click();
		Reporter.log("Clicked the field with locator:="+locator.toString());
	}

	public static void navigate(RemoteWebDriver driver,String url) {
		driver.navigate().to(url);
		Reporter.log("Navigated to the URL:="+url);
	}
	
	public static void quit(RemoteWebDriver driver) {
		driver.quit();
		Reporter.log("Quit the driver");
	}
	
	public static String getTitle(RemoteWebDriver driver) {
		String title=driver.getTitle();
		Reporter.log("Browser title is:="+title);
		return title;
	}
	
	public static void takeScreenshot(RemoteWebDriver driver, String screenshotName) {
		File screenshot=driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("screenshots/"+screenshotName+".PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Comments at the end of the file
}
