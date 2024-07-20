package com.orangehrm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	
	//locators
	
	private By userName = By.name("username");
	private By password = By.name("password");
	private By login =By.xpath("//button[@type='submit']");
	private By errorMessage = By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']");
    
	
    //methods
    
	public void enterUsername(String uname) {
		WebElement userNameElement = driver.findElement(this.userName);
		userNameElement.sendKeys(uname);
	}
	
	public void enterPassword(String password) {
		WebElement passwordElement = driver.findElement(this.password);
		passwordElement.sendKeys(password);
	}
	
	public void clickLogin() {
		WebElement loginElement = driver.findElement(login);
		loginElement.click();
	}
	
	public String getErrorMessage() {
		WebElement errorMessageElement = driver.findElement(errorMessage);
		System.out.println(errorMessageElement.getText());
		return errorMessageElement.getText();
	}
}
