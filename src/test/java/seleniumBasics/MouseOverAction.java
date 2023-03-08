package seleniumBasics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MouseOverAction extends BrowserLaunch{
	
	@Test
	public void printCourseDetailsWithExplicitWait() throws InterruptedException {
		navigateToUrl("https://oceanacademy.co.in/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	
		WebElement closeBUtton = driver.findElement(By.xpath("//div[@id='root']/div[1]/div"));
		wait.until(ExpectedConditions.elementToBeClickable(closeBUtton));
		closeBUtton.click();
		
		WebElement courses = driver.findElement(By.id("courses"));
		Actions actionObj = new Actions(driver);
		actionObj.moveToElement(courses).perform();
		
		WebElement offlineCourses = driver.findElement(By.xpath("//a[text()='Offline Courses']"));
		actionObj.moveToElement(offlineCourses).click().build().perform();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[@class='title'])[1]")));
		
		String firstCourseName = driver.findElement(By.xpath("(//p[@class='title'])[1]")).getText();
		System.out.println(firstCourseName);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		List<WebElement> courseNameList = driver.findElements(By.xpath("//p[@class='title']"));
		for (WebElement indiCourse : courseNameList) {
			System.out.println(indiCourse.getText());
		}
		
		//browserClose();
	}
	
}
