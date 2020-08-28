package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorDemo2ScrollingDownUp {
	public static String url = "https:/www.amazon.com/";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);

		// Scrolling Down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		Thread.sleep(2000);

		// Scrolling Up
		js.executeScript("window.scrollBy(0,-500)");

		// Scrolling Until Specific WebElement
		WebElement backToTopButton = driver.findElement(By.xpath("//span[text()='Back to top']"));
		js.executeScript("arguments[0].scrollIntoView(true);", backToTopButton);

	}
}
