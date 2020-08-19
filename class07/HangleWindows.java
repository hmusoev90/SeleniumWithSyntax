package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;

import javax.xml.bind.SchemaOutputResolver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HangleWindows {

	public static String url = "https://accounts.google.com/signup";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		String mainPage = driver.getWindowHandle();
		System.out.println(mainPage);
		WebElement helpLink = driver.findElement(By.linkText("Help"));
		helpLink.click();
		
		Set<String> allWindowHangles = driver.getWindowHandles();
		System.out.println(allWindowHangles.size());
		Iterator<String> it= allWindowHangles.iterator();
		mainPage = it.next();
		String childHangle = it.next();
		System.out.println(childHangle);
		Thread.sleep(3000);
		
		//Switching back to 1st Page
		driver.switchTo().window(mainPage);
		
	}
}
