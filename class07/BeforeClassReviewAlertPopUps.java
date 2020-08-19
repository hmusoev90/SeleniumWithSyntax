package com.syntax.class07;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BeforeClassReviewAlertPopUps {

	public static String url = "http://www.uitestpractice.com/Students/Switchto";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebElement simpleAlertButton = driver.findElement(By.xpath("//button[@id='alert']"));

		simpleAlertButton.click();
		Thread.sleep(3000);

		// Switching to Alert popup
		Alert alert = driver.switchTo().alert();

		alert.accept();
		Thread.sleep(3000);

		WebElement confirmAlertButton = driver.findElement(By.cssSelector("button[id='confirm']"));
		confirmAlertButton.click();
		Thread.sleep(3000);

		// Clicking Cancel on Confirm Alert
		alert.dismiss();
		Thread.sleep(3000);

		WebElement promtAlertButton = driver.findElement(By.cssSelector("button[id='prompt']"));

		// Entering data in Prompt Alert
		promtAlertButton.click();
		Thread.sleep(3000);
		alert.sendKeys("Hello Prompt");
		Thread.sleep(3000);
		alert.accept();

	}
}
