package com.syntax.class10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {
	public static String url = "https://artoftesting.com/samplesiteforselenium";

	public static void main(String[] args) {

		System.setProperty("driver.chromedriver.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
}
