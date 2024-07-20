package com.orangehrm.testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.drivers.WebDriverFactory;
import com.orangehrm.pageobjects.LoginPage;

public class LoginPageTest {
	
	private WebDriver driver;
	private LoginPage loginpage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
	    driver = WebDriverFactory.createDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		loginpage = new LoginPage(driver);
		Thread.sleep(1000);
	}
	
	@Test
	public void testSuccessfullLogin() {
	   loginpage.enterUsername("Admin");
	   loginpage.enterPassword("admin123");
	   loginpage.clickLogin();
	   
	   String currentUrl = driver.getCurrentUrl();
	   Assert.assertTrue(currentUrl.contains("dashboard"));
	}
	
	@Test
	public void testInvalidLogin() throws InterruptedException {
		
		loginpage.enterUsername("adminnn");
		loginpage.enterPassword("1234");
		loginpage.clickLogin();
		
		Thread.sleep(1000);
		String errorMessage = loginpage.getErrorMessage();
		Assert.assertEquals("Invalid credentials", errorMessage);
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
