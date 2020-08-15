package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HanglingAlerts {

	public static String url = "http://www.uitestpractice.com/Students/Switchto";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);

		// Simple Alert
		WebElement simpleAlertBtn = driver.findElement(By.id("alert"));
		simpleAlertBtn.click();
		Thread.sleep(3000);
		Alert simpleAlert = driver.switchTo().alert();
		Thread.sleep(7000);

		// Confirm Alert
		WebElement confirmAlertBtn = driver.findElement(By.id("confirm"));
		confirmAlertBtn.click();
		Thread.sleep(3000);
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.dismiss();
		Thread.sleep(5000);

		// Promt Alert
		WebElement promtAlertBtn = driver.findElement(By.id("prompt"));
		promtAlertBtn.click();
		Thread.sleep(3000);

	}
}
