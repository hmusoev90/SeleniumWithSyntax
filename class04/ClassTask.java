package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassTask {
	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);

		WebElement loginTxtBox = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		loginTxtBox.sendKeys("Admin");
		WebElement passwordTxtBox = driver.findElement(By.cssSelector("input[id='txtPassword']"));
		passwordTxtBox.sendKeys("Hum@nhrm123");
		Thread.sleep(3000);
		WebElement submitBtn = driver.findElement(By.xpath("//input[@name='Submit']"));
		submitBtn.click();

		WebElement logo = driver.findElement(By.xpath("//img[@alt='OrangeHRM']"));

		if (logo.isDisplayed()) {
			System.out.println("Logo is displayed");
		} else {
			System.out.println("Logo is not displayed");
		}
	}
}
