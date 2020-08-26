package com.syntax.class10;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingScreenShot {

	public static String url = "http://18.232.148.34/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement login = driver.findElement(By.cssSelector("input#txtUsername"));
		WebElement password = driver.findElement(By.cssSelector("input#txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));

		login.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");
		loginButton.click();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE); // the ScreenShot is taken
		
		
		try {
		FileUtils.copyFile(sourceFile, new File("ScreenShots/HRMS/AdminLogin.png"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
