package stepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
	
	public WebDriver driver;
	
	@Given("Open browser and there is a user who do gmail login")
	public void open_browser_and_there_is_a_user_who_do_gmail_login() 
	{
		System.setProperty("webdriver.chrome.driver", "D://eclipse-workspace/TestMailFun/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "https://mail.google.com/mail/";
		// launch the Base URL
		driver.get(baseUrl);
	    
	}

	@And("User login with Email Address {string} and password {string}")
	public void user_login_with_email_address_and_password(String username, String password) throws InterruptedException {
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\'identifierNext\']/div/button/span")).click();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\'identifierNext\']/div/button/span")).click();
		
	    
	}
	@When("User sends mail to {string} with subject {string} and body {string}")
	public void user_sends_mail_to_with_subject_and_body(String string, String string2, String string3) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='z0']/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td//img[2]")).click();
		driver.findElement(By.className("vO")).sendKeys(string);
		driver.findElement(By.className("aoT")).sendKeys(string2);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='1']")));
		WebElement printbody = driver.switchTo().activeElement();
		printbody.sendKeys(string3);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	   
	}

	@Then("Email sends successfully and email appears in send folder with subject {string}")
	public void email_sends_successfully_and_email_appears_in_send_folder_with_subject(String string) throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='Sent Mail']")).click();
		if (driver.findElement(By.xpath("//div[@class='y6']//b[text()='" + string + "']")) != null) {
			System.out.println("Wowww.. Email sent sucessfully!!!");
		} else {
			System.out.println("Failed to send email !!!");
		}
		Thread.sleep(2000);
	   
	}

	@When("Click on Log out")
	public void click_on_log_out() throws InterruptedException {
		driver.findElement(By.cssSelector("img[class='gb_Ca gbii']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='gb_71']"));
		Thread.sleep(1000);

	}

	@Then("Successfully log out and Close the browser")
	public void successfully_log_out_and_close_the_browser() {
		driver.close();
	    
	}

}
