package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	
	WebDriver driver;
	
	@Given("User is on the login page")
	public void userIsOnTheLoginPage() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
	}
	
	@When("User enters valid credentials")
	public void userEntersValidCredentials() {
		  
		   driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		   driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		   driver.findElement(By.xpath("//button[@type='submit']")).click();
		   
		 
	}
	
	@When("User enters Invalid credentials")
	public void userEntersInvalidCredentials() throws InterruptedException {
		
		 driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Adminnn");
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123");
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(1000);
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']"));
		String error = errorMessage.getText();
		Assert.assertEquals("Invalid credentials", error);
		driver.quit();
	}
	
	@Then("User should be redirected to Dashboard")
	public void userRedirectedToDashboard() {
		  String currentUrl = driver.getCurrentUrl();
		   Assert.assertTrue(currentUrl.contains("dashboard"));
		   driver.quit();
	}

}
