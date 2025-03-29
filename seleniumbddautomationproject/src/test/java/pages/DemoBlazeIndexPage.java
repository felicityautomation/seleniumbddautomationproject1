package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WebActions;

public class DemoBlazeIndexPage {
	RemoteWebDriver driver;
	WebDriverWait wait;
	
	
	public DemoBlazeIndexPage(RemoteWebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//Locators
	By linkLogin=By.id("login2");
	By inputUserName=By.id("loginusername");
	By inputPassword=By.id("loginpassword");
	By buttonLogin=By.xpath("//button[text()='Log in']");
	
	
	//Functionalities that are offered by the page which are required for your test cases
	public void clickLoginLink() {
		//driver.findElement(linkLogin).click();
		WebActions.click(driver, linkLogin);
	}

	public void enterUserName(String userName) {
		//driver.findElement(inputUserName).sendKeys(userName);
		WebActions.setText(driver, inputUserName, userName);
	}
	
	public void enterPassword(String password) {
		//driver.findElement(inputPassword).sendKeys(password);
		WebActions.setText(driver, inputPassword, password);
	}
	
	public void clickLoginButton() {
		//driver.findElement(buttonLogin).click();
		WebActions.click(driver, buttonLogin);
	}
	
	public void verifyAlertPresent() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	public void login(String userName,String password) throws InterruptedException {
		this.clickLoginLink();
		wait.until(ExpectedConditions.elementToBeClickable(inputUserName));
		Thread.sleep(5000);
		this.enterUserName(userName);
		this.enterPassword(password);
		//ckeckbox
		this.clickLoginButton();
		
	}
}
