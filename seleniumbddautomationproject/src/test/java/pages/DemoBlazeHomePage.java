package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WebActions;

public class DemoBlazeHomePage {

	RemoteWebDriver driver;
	
	
	
	By linkLogout=By.id("logout2");


	public DemoBlazeHomePage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	public void clickLogout() {
		//driver.findElement(linkLogout).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(linkLogout));
		WebActions.click(driver, linkLogout);
	}

}
