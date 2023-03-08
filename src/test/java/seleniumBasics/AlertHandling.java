package seleniumBasics;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AlertHandling extends BrowserLaunch {

	@Test(groups = { "demo" })
	public void alertTypes() throws InterruptedException {
		navigateToUrl("https://letcode.in/alert");

		// Modern Alert - dismiss
		driver.findElement(By.id("modern")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("// button[@aria-label='close']")).click();

		// Prompt Alert - dismiss
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Welcome to Alert class");
		driver.switchTo().alert().accept();
		String textVal = driver.findElement(By.id("myName")).getText();
		System.out.println(textVal);

		// Confirm Alert - dismiss
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();

		// Simple Alert
		
		driver.findElement(By.id("accept")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
}
