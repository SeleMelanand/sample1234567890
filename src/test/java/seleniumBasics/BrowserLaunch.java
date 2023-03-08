package seleniumBasics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

	public RemoteWebDriver driver;
	
	public void navigateToUrl(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	//@AfterMethod
	public void browserClose() {
		//driver.close();
		driver.quit();
	}
	
	public String captureScreenshot() {
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination2 = new File("./snaps/snap" + System.currentTimeMillis() + ".jpeg");
		String dest = destination2.getAbsolutePath();
		try {
			FileUtils.copyFile(source, destination2);
		} catch (IOException e) {
			System.out.println("Exception occured :: " + e);
		}
		return dest;
	}
	
	
	//@BeforeMethod
		public void openApplication() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
			driver.get("https://testsheepnz.github.io/panther.html");
		}
	
	//@BeforeMethod
	public void navigateToUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://testsheepnz.github.io/panther.html");
	}
}
