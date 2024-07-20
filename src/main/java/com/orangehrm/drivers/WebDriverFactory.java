package com.orangehrm.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

	
	public static WebDriver createDriver() {
		
		WebDriver driver = new ChromeDriver();
	    return driver;
	}
}
