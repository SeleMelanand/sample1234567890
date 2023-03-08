package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataFromStringArray extends GenericClass {

	@DataProvider(name = "messageTestData")
	public Object[][] getTestdata() {
		String[][] employee = new String[2][3];
		employee[0][0] = "firstname";
		employee[0][1] = "1111111111";
		employee[0][2] = "Query for testcase 1";

		employee[1][0] = "lastname";
		employee[1][1] = "222222222";
		employee[1][2] = "Query for testcase 2";
		return employee;
	}

	@Test(dataProvider = "messageTestData")
	public void alertsDemo(String name, String mobile, String message) throws InterruptedException {
		driver.get("https://oceanacademy.in/");
		driver.findElement(By.linkText("Contact Us")).click();
		driver.findElement(By.name("fullName")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(mobile);
		driver.findElement(By.name("query")).sendKeys(message);

		Thread.sleep(3000);
		System.out.println("Data entered successfully");
	}

}
