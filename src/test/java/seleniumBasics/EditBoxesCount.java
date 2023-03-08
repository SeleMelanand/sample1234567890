package seleniumBasics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EditBoxesCount extends GenericClass {
	@Parameters({ "Url"})
	@Test(groups = { "demo" })
	public void printCOuntEditBoxes(String url) throws InterruptedException {
		driver.get(url);
		driver.findElement(By.linkText("Register")).click();
		List<WebElement> editboxlist = driver.findElements(By.xpath("//input[@type='text']"));
		int editBoxCOunt = editboxlist.size();
		System.out.println("Testcase 2 Execution completed :: "+ editBoxCOunt);

	}
}