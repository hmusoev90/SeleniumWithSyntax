package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
	public static void main(String[] args) {

		/*
		 * 1.Launch the Chrome Browser 2.Navigate to Amazon.com 3. Print out the title
		 * and the url in console
		 */

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Habib\\Desktop\\Soft\\Selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println(url + "\n" + title);

	}
}
