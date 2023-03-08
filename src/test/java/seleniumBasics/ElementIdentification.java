package seleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIdentification extends BrowserLaunch{

	@Test (priority = 0,groups = { "demo" })
	public void xpathLocator() {
		navigateToUrl("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
		driver.findElement(By.xpath("//label[@for='input-agree']")).click();
		System.out.println("executed 1");
	}
	
	
	@Test (priority = 4, enabled = false,timeOut = 1000,invocationCount = 5)
	public void selectsTag() {
		navigateToUrl("https://testsheepnz.github.io/testing-ideas.html");
		driver.findElement(By.partialLinkText("Brian Eno's Oblique")).click();
		String titleName = driver.getTitle();
		System.out.println(titleName);
		System.out.println("executed 4");

	}
	
	@Test(priority = 3)
	public void selectValue() {
		navigateToUrl("https://testsheepnz.github.io/panther.html");
		
		SoftAssert soAssert = new SoftAssert();
		
		WebElement missileCount = driver.findElement(By.id("numMissiles"));
		String val1 =  driver.findElement(By.xpath("//form[@id='equipmentForm']/h2")).getText();
		
		soAssert.assertEquals(val1, "Equipment");
		Select missileSelObj = new Select(missileCount);
		missileSelObj.selectByVisibleText("1");

		WebElement bombCount = driver.findElement(By.id("numDumbBomb"));
		Select bombSelObj = new Select(bombCount);
		bombSelObj.selectByValue("4");
		driver.findElement(By.id("setEquipmentButton")).click();

		String errorMessage = driver.findElement(By.id("initErrorMsg")).getText();
		System.out.println(errorMessage);
		
		List<WebElement> abcd = driver.findElements(By.xpath("//input[@type='button']"));
		int val2 = abcd.size();
		soAssert.assertEquals(val2, 2);
		soAssert.assertAll();
		
		Assert.assertEquals(errorMessage, "Max fuel level of 3000kg");
		System.out.println("executed 3");
		

	}

	@Test(priority = 1,groups = { "demo" })
	public void addFunctionality() throws InterruptedException {
		navigateToUrl("https://testsheepnz.github.io/BasicCalculator.html");
		driver.findElement(By.id("number1Field")).sendKeys("5.48");
		driver.findElement(By.id("number2Field")).sendKeys("2.35");
		driver.findElement(By.id("calculateButton")).click();
		Thread.sleep(4000);
		String value = driver.findElement(By.id("numberAnswerField")).getText();
		System.out.println("runTime Value :: "+value);
		
		System.out.println("executed 2");
		
		/*
		 * driver.findElement(By.id("integerSelect")).click(); Thread.sleep(4000);
		 * driver.findElement(By.id("clearButton")).click();
		 */
	}
}
