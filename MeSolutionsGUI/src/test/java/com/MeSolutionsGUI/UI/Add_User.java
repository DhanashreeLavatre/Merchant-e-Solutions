package com.MeSolutionsGUI.UI;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;


  
public class Add_User {
	
	@Test
	public void webTest() {
	
//	System.setProperty("webdriver.gecko.driver","geckodriver 2");
    System.setProperty("webdriver.chrome.driver","chromedriver-3");
//	WebDriver driver = new FirefoxDriver();
    WebDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.navigate().to("http://qainterview.merchante-solutions.com:8080/admin");
	driver.findElement(By.id("users")).click();
	driver.findElement(By.xpath("//a[@href='/admin/users/new']")).click();
	driver.findElement(By.id("user_username")).sendKeys("xyzghtfkf");
	driver.findElement(By.id("user_password")).sendKeys("1234"); //minimum 4 char is needed in password.
	driver.findElement(By.id("user_email")).sendKeys("test@test1122.com");
	driver.findElement(By.name("commit")).click();
	driver.navigate().to("http://qainterview.merchante-solutions.com:8080/admin/users");
//	Select selectObj = new Select(driver.findElement(By.xpath("//select[@id='q_username_input']")));
//	selectObj.selectByVisibleText("username_equals");
	driver.findElement(By.id("q_username")).sendKeys("xy");
	driver.findElement(By.id("q_email")).sendKeys("test");
//	driver.findElement(By.id("q_created_at_gteq_datetime")).click();
//	driver.findElement(By.name("ui-state-default ui-state-highlight")).click();
	driver.findElement(By.xpath("//input[@value='Filter']")).click();

}
}
