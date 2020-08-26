package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {

	public static String url = "https://www.amazon.com";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();

		WebElement accountsAndLists = driver.findElement(By.xpath("//span[@class='nav-line-2 nav-long-width']"));

		Actions action = new Actions(driver);
		action.moveToElement(accountsAndLists).perform();

	}
}
