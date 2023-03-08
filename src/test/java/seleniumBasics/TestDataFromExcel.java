package seleniumBasics;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataFromExcel extends GenericClass {
	
	public String testDataExcelPath = "./testData/sampleTestdata.xlsx";

	@DataProvider(name = "oceanTestData")
	public Object[][] retrieveDataFromExcel() throws IOException {

		return ReadDataFromExcel.excelRead(testDataExcelPath);
	}

	
	@Test(dataProvider = "oceanTestData")
	public void enterDataUsingString(String name, String mobile, String message) throws InterruptedException {
		driver.get("https://oceanacademy.in/");
		driver.findElement(By.linkText("Contact Us")).click();
		driver.findElement(By.name("fullName")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(mobile);
		driver.findElement(By.name("query")).sendKeys(message);
		
		System.out.println("Data entered successfully");
	}

}
