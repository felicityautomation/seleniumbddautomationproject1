package utilities;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class BrowserUtility {
	
	
	public static RemoteWebDriver getDriver() {
		Logger logger=LoggingUtility.getLogger("BrowserUtility.getDriver()");
		RemoteWebDriver driver=null;
		String driverName=null;
		driverName=System.getProperty("browser");
		System.out.println("Browser Name:="+driverName);
		
		if(driverName==null) {
			logger.debug("browser parameter is not found. Hence launching the browser in Chrome mode.");
			driver=new ChromeDriver();
		}
		else if(driverName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(driverName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(driverName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		Reporter.log("Opened the Browser");
		return driver;
		
	}

}
