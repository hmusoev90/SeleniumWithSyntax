package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW01 {

	/*
	 * Go to facebook sign up page Fill out the whole form Click signup
	 */
	public static String url = "http://facebook.com";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("u_0_2")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Wick");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("6956656595");
		Thread.sleep(2500);
		driver.findElement(By.cssSelector("input[autocomplete='new-password']")).sendKeys("WickJosh");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@value='2']")).click();

	}
}
