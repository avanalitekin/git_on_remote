package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
	private Driver() {}

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			switch ("chrome") {

				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "chrome-headless":
					WebDriverManager.chromedriver().setup();
					ChromeOptions options=new ChromeOptions();
					options.addArguments("--headless");
					driver =new ChromeDriver(options);
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "firefox-headless":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "ie":
					if (System.getProperty("os.name").toLowerCase().contains("mac")) {
						throw new WebDriverException("Your operating system does not  support the requested browser");
					} else {
						WebDriverManager.iedriver().setup();
						driver = new InternetExplorerDriver();
						break;

					}
				case "edge":
					if (System.getProperty("os.name").toLowerCase().contains("mac")) {
						throw new WebDriverException("Your operating system does not  support the requested browser");
					} else {
						WebDriverManager.edgedriver().setup();
						driver = new EdgeDriver();
						break;
					}
				case "safari":
					if (System.getProperty("os.name").toLowerCase().contains("windows")) {
						throw new WebDriverException("Your operating system does not  support the  requested browswer");
					} else {
						WebDriverManager.getInstance(SafariDriver.class).setup();
						driver = new SafariDriver();
						break;
					}
			}
		}
		return driver;

	}
	public static void closeDriver() {
		if(driver!=null) {
			driver.quit();
			driver=null;
		}
	}

}
