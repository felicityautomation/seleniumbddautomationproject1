package steps;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoBlazeHomePage;
import pages.DemoBlazeIndexPage;
import utilities.BrowserUtility;
import utilities.ExcelUtility;
import utilities.WebActions;

public class StepDefinitions {
	RemoteWebDriver driver;
	
	@Given("User opens the browser")
	public void user_opens_the_browser() {
	   driver=BrowserUtility.getDriver();
	}

	@When("user opens the DemoBlaze application URL")
	public void user_opens_the_demo_blaze_application_url() {
	  WebActions.openUrl(driver, "https://www.demoblaze.com/index.html");
	}

	@When("user clicks on Login link")
	public void user_clicks_on_login_link() {
	    DemoBlazeIndexPage indexPage=new DemoBlazeIndexPage(driver);
	    indexPage.clickLoginLink();
	}

	@When("user enters user name as {string} and password {string}")
	public void user_enters_user_name_as_and_password(String userName, String password) {
		 DemoBlazeIndexPage indexPage=new DemoBlazeIndexPage(driver);
		 indexPage.enterUserName(userName);
		 //Read the password from a file and store in a variable
		 
		 indexPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		 DemoBlazeIndexPage indexPage=new DemoBlazeIndexPage(driver);
		 indexPage.clickLoginButton();
	}

	@Then("the home page should be displayed with signout link")
	public void the_home_page_should_be_displayed_with_signout_link() {
	    DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
	    homePage.clickLogout();
	}


	@Then("Alert message should be displayed with error message")
	public void alertMessageInDemoBlazeWithError() {
		DemoBlazeIndexPage indexPage=new DemoBlazeIndexPage(driver);
		indexPage.verifyAlertPresent();
	}
	
	@And("the browser is closed")
	public void closeBrowser() {
		driver.quit();
	}

	@When("user enters user name and password from the excel {string} and sheet {string}")
	public void user_enters_user_name_and_password_from_the_excel_and_sheet(String excelSheetPath, String sheetName) throws IOException {
	    ExcelUtility.readFromExcelSheet(excelSheetPath, sheetName);
	    DemoBlazeIndexPage indexPage=new DemoBlazeIndexPage(driver);
//		 indexPage.enterUserName(userName);
//		 //Read the password from a file and store in a variable
//		 
//		 indexPage.enterPassword(password);
	}
}
