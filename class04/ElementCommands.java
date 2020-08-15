package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementCommands {
	public static String url = "http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement ageRadioBtn = driver.findElement(By.xpath("//input[@value='0 - 5']"));
		boolean isEnabled = ageRadioBtn.isEnabled();
		boolean isDisplayed = ageRadioBtn.isDisplayed();
		System.out.println(isEnabled + "\n" + isDisplayed);
		
		System.out.println("Before clicking " + ageRadioBtn.isSelected());
		Thread.sleep(3000);
		ageRadioBtn.click();
		System.out.println("After clicking " + ageRadioBtn.isSelected());
	}
}
