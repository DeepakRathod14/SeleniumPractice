package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Setup {

	protected static WebDriver driver;

	public static void main(String[] args) {
		loadBrowser("firefox");
		loadURL("http://www.google.com");
		search();
		//closeBrowser();
	}

	public static void loadBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Deepak laption data\\eclips-workspace\\SeleniumProject\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Deepak laption data\\eclips-workspace\\SeleniumProject\\drivers\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", false);
			driver = new FirefoxDriver(options);
		}
		driver.manage().window().maximize();
	}

	public static void loadURL(String url) {
		driver.get(url);
	}

	public static void search()
	{
		driver.findElement(By.name("q")).sendKeys("guru99");
		driver.findElement(By.name("q")).submit();
		
	}
	public static void closeBrowser() {
		driver.quit();
	}
}
