package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class clearCommand {

	public static String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();

		WebElement userNameTxtBox = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
		userNameTxtBox.sendKeys("Tester");
		WebElement passwordTxtBox = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$password']"));
		passwordTxtBox.sendKeys("test");
		Thread.sleep(3000);
		WebElement loginButton = driver.findElement(By.className("button"));
		loginButton.click();
		// userNameTxtBox.clear();
		// passwordTxtBox.clear();

		WebElement logo = driver.findElement(By.xpath("//h1[text()='Web Orders']"));
		if (logo.isDisplayed()) {
			String logoText = logo.getText();
			if (logoText.equals("Web Orders")) {
				System.out.println("This is the right logo");
			} else {
				System.out.println("This is the wrong logo");
			}
		}
	}

}
