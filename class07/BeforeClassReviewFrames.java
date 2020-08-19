package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BeforeClassReviewFrames {

	public static String url = "http://www.uitestpractice.com/Students/Switchto";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);

		// Locating Frame by index

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("HEllo World");

		// Switching to Main page
		driver.switchTo().defaultContent();
		

	}
}
