package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedXpathDemo {

	public static String url = "https:/www.amazon.com/";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		// SearchBar

		WebElement searchBar = driver.findElement(By.xpath("//label[@id='nav-search-label']/following-sibling::input"));
		//searchBar.sendKeys("Samsung Galaxy Note 20 Ultra Unlocked");

	}
}
