package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Habib\\Desktop\\Soft\\Selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.facebook.com");
		driver.navigate().to("http://google.com");
		driver.navigate().back();
		driver.manage().window().maximize();
		driver.close();
		// driver.quit();
	}
}
