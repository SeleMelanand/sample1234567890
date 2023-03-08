package seleniumBasics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesWithExtentReport extends BrowserLaunch{
	@Test
	public void WebTablesWorking() throws InterruptedException {
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"./reports/TestReport" + System.currentTimeMillis() + ".html");

		extent.attachReporter(spark);

		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation report");

		ExtentTest test = extent.createTest("Rail search");
		test.assignAuthor("Anand");
		test.assignCategory("RegrssionTesting");
		test.assignCategory("SmokeTesting");

		boolean testResult = true;
				
		navigateToUrl("https://erail.in/");
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("SCT",Keys.TAB);
		
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MS",Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(5000);
		List<WebElement> trainList = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]//tr"));
		int rowCount = trainList.size();
		System.out.println(rowCount);
		System.out.println("````````````````````````");
		for(int i=2;i<=rowCount;i++) {
			String trainName = driver.findElement(By.xpath("//table[contains(@class,'DataTable TrainList')]//tr["+i+"]/td[1]/a")).getText();
			System.out.println(trainName);
		}	
		
		if (rowCount != 4) {
			testResult = false;
		}
		
		Media snap = MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot()).build();

		if (testResult == true) {
			test.log(Status.PASS, "train count displayed correctly", snap);
		} else {
			test.log(Status.FAIL, "train count displayed correctly", snap);

		}
		extent.flush();
		
	}

}
