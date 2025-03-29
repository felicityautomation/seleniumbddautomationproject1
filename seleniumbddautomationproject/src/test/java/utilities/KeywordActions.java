package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class KeywordActions {
	RemoteWebDriver driver;
	
	public By getLocator(String locatorType,String locatorValue) {
		if(locatorType.equalsIgnoreCase("id")) {
			return By.id(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("xpath")) {
			return By.xpath(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("name")) {
			return By.name(locatorValue);
		}
		return null;
	}

	public void performAction(String locatorType,String locatorValue,String data,String action) throws InterruptedException {
		switch(action) {
		case "openBrowser":
			driver=BrowserUtility.getDriver();
			break;
		case "openUrl":
			//driver.get(data);
			WebActions.openUrl(driver, data);
			break;
		case "setText":
			//driver.findElement(getLocator(locatorType,locatorValue)).sendKeys(data);
			WebActions.setText(driver, getLocator(locatorType,locatorValue), data);
			break;
		case "click":
			//driver.findElement(getLocator(locatorType,locatorValue)).click();
			WebActions.click(driver, getLocator(locatorType,locatorValue));
			break;
		case "wait":
			Thread.sleep(Long.parseLong(data));
			Reporter.log("Waited for milli seconds:="+data);
			break;
		case "verifyTitle":
			//String actualTitle=driver.getTitle();
			String actualTitle=WebActions.getTitle(driver);
			Assert.assertEquals(actualTitle, data);
			break;
		case "navigateToPage":
			//driver.navigate().to(data);
			WebActions.navigate(driver, data);
			break;
		case "closeBrowser":
			//driver.quit();
			WebActions.quit(driver);
			break;
		}
	}

}
