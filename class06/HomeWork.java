package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {

	// Go to http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html
	// click on each button and handle the alert accordingly

	public static String url = "http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		driver.manage().window().maximize();

		// Simple Alert
		WebElement simpleAlertButton = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
		simpleAlertButton.click();

		Thread.sleep(3000);

		// Switching to Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);

		// Confirm Alert
		WebElement confimrAlertButton = driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']"));
		confimrAlertButton.click();
		Thread.sleep(3000);

		alert.dismiss();

		// Prompt Alert

		WebElement promptAlertButton = driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']"));
		promptAlertButton.click();
		Thread.sleep(3000);
		alert.sendKeys("Hello Promp Alert");
		Thread.sleep(3000);
		alert.accept();
	}
}
