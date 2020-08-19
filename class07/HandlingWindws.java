package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindws {

	public static String url = "http://166.62.36.207/syntaxpractice/window-popup-modal-demo.html";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		String mainPage = driver.getWindowHandle();
		WebElement instaButton = driver.findElement(By.linkText("Follow On Instagram"));
		WebElement fbButton = driver.findElement(By.linkText("Like us On Facebook"));
		WebElement instaAndFbButton = driver.findElement(By.linkText("Follow Instagram & Facebook"));
		Thread.sleep(3000);
		instaButton.click();
		fbButton.click();
		instaAndFbButton.click();

		Set<String> allWindowHangles = driver.getWindowHandles();
		System.out.println(allWindowHangles.size());

		Iterator<String> it = allWindowHangles.iterator();
		while (it.hasNext()) {
			String childHangle = it.next();
			if (!childHangle.equals(mainPage)) {
				driver.switchTo().window(childHangle);
				System.out.println(driver.getTitle());
				driver.close();
				Thread.sleep(3000);
			}
			driver.switchTo().window(mainPage);
			instaButton.click();
		}

	}
}
