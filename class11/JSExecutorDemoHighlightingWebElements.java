package com.syntax.class11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorDemoHighlightingWebElements {
	public static String url = "http://18.232.148.34/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement userName = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		userName.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Highlighting password field with red color
		js.executeScript("arguments[0].style.backgroundColor='red'", password);
		
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", loginButton);
		

	}
}
