package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static String url = "http://syntaxtechs.com/selenium-practice/dynamic-data-loading-demo.php";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement newUserButton = driver.findElement(By.xpath("//button[text()='Get New User']"));

		newUserButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'First Name :')]")));

		// Finding First Name element and Printing First Name
		WebElement firstName = driver.findElement(By.xpath("//p[contains(text(),'First Name :')]"));
		System.out.println("First Name: " + firstName.getText());
		
		
	}
}
