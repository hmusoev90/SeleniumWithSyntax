package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassTask {
	public static String url = "http://166.62.36.207/syntaxpractice/bootstrap-iframe.html";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		driver.switchTo().frame("FrameOne");
		WebElement logo = driver.findElement(By.xpath("//img[@src='img/Syntax.png']"));
		System.out.println(logo.isDisplayed() ? "Logo Displayed" : "Logo not Displayed");
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		WebElement button = driver.findElement(By.xpath("//a[@class='enroll-btn']"));
		System.out.println(button.isEnabled() ? "Button is Enabled" : "Button is Disabled");
		

	}
}
