package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAllLinks {

	public static String url = "http://amazon.com";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("All links: " + allLinks.size());

		for (WebElement links : allLinks) {
			String link = links.getText();
			String fullLink = links.getAttribute("href");
			if (!link.isEmpty()) {
				System.out.println(link + " " + fullLink);

			}
		}
	}
}
