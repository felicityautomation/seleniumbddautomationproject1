package utilities;

import org.openqa.selenium.By;
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
}
