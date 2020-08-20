package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {

	/*
	 * Go to https://demoqa.com/browser-windows click on New Tab and print the text
	 * from new tab in the console click on New Window and print the text from new
	 * window in the console click on New Window Message and print the text from new
	 * window in the console Verify the title is displayed Print out the title of
	 * the main page
	 * 
	 */

	public static String url = "https://demoqa.com/browser-windows";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();

		String mainPageId = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement newTabButton = driver.findElement(By.cssSelector("button#tabButton"));
		WebElement newWindowButton = driver.findElement(By.cssSelector("button#windowButton"));
		WebElement newWindowMessageButton = driver.findElement(By.cssSelector("button#messageWindowButton"));

		newTabButton.click();
		newWindowButton.click();
		newWindowMessageButton.click();
		Set<String> windowsID = driver.getWindowHandles();

		Iterator<String> it = windowsID.iterator();
		String newTabHangle = "";
		while (it.hasNext()) {
			newTabHangle = it.next();
			if (!newTabHangle.equals(mainPageId)) {
				//System.out.println(driver.findElement(By.tagName("h1")).getText());
				System.out.println("----------------------------------");
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				driver.close();
			}
			driver.switchTo().window(newTabHangle);
		}
	}
}
