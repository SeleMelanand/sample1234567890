package seleniumBasics;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WindowHandling extends GenericClass {
	
	@Parameters({ "Url","Uname","passCode"})
	@Test(groups = { "demo" })
	public void workingOnWindows(String url,String userName,String password) throws InterruptedException {
		driver.get(url);
		System.out.println(userName);
		System.out.println(password);
		String baseWindow = driver.getWindowHandle();
		System.out.println(baseWindow);
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		driver.findElement(By.xpath("//span[@title='Remote']")).click();
		Set<String> windowNameList = driver.getWindowHandles();
		for (String winName : windowNameList) {
			Thread.sleep(5000);
			if (!winName.equalsIgnoreCase(baseWindow)) {
				System.out.println(winName);
				driver.switchTo().window(winName);
			}
		}
		String value = driver.findElement(By.xpath("//div[@class='sortAndH1Cont']/div[1]/span")).getText();
		System.out.println("Testcase 1 Execution completed :: "+value);
		
	}

}
