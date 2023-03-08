package seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo extends BrowserLaunch {
	@Test
	public void scrollToSpecficElement() throws InterruptedException {
		navigateToUrl("https://www.amazon.in/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement sectionToview = driver.findElement(By.xpath("//a[text()='See all deals']"));
		// for page scrolldown to specific element
		jse.executeScript("arguments[0]. scrollIntoView(false);", sectionToview);

		//String val = jse.executeScript("return document.readyState").toString();
		//System.out.println(val);
		/*
		 * do { Thread.sleep(1000); } while
		 * (jse.executeScript("return document.readyState").toString().equalsIgnoreCase(
		 * "complete"));
		 */
		WebElement clickAllDetails = driver.findElement(By.linkText("See all deals"));
		// for click
		jse.executeScript("arguments[0].click();", clickAllDetails);

	}

}
