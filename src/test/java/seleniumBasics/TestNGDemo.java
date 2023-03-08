package seleniumBasics;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo extends BrowserLaunch{
	
	@Test
	public void testcase1() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Testcase 1 Executed");
	}
	
	
	@Test
	public void testcase2() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Testcase 2 Executed");
	}
	
	
	@AfterSuite
	public void method1() {
		System.out.println("method 1 :: After Suite Executed");
	}
	
	
	@BeforeClass
	public void method2() {
		System.out.println("method 2 :: Before Class Executed");
	}
	
	@BeforeTest
	public void method3() {
		System.out.println("method 3 :: Before Test Executed");
	}
	
}
