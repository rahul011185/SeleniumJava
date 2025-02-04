package com.eCommerce.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.eCommerce.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readData = new ReadConfig();
	public String url = readData.getApplicationUrl();
	public String uname = readData.getUserName();
	public String pass = readData.getPassword();

	public WebDriver driver;

	public static Logger logger = LogManager.getLogger(BaseClass.class);

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger.info("**********Before class method Start**********");

		// Initialize the driver based on browser parameter
		if (br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			logger.info("************Chrome Browser is initialized**************");
		} else if (br.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			logger.info("***************fireFox driver is initialized******************");
		} else if (br.equalsIgnoreCase("ie")) {
			driver = new EdgeDriver();
			logger.info("************Edge driver is initialized*************");
		}

		// Open the application URL
		driver.get(url);
		logger.info("********Application URL is opened: ***********" + url);

		// Maximize the browser window
		driver.manage().window().maximize();
		logger.info("**********Browser window is maximized**********");
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
			logger.info("************Browser Closed*****************");
		}
	}
}
