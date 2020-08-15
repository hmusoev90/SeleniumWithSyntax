package com.syntax.class04;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxPractice {
	public static String url = "http://166.62.36.207/syntaxpractice/basic-checkbox-demo.html";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		List<WebElement> optionCheckBoxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));
		System.out.println(optionCheckBoxes.size());

		for (WebElement CheckBoxOption : optionCheckBoxes) {
			if (CheckBoxOption.isDisplayed()) {
				CheckBoxOption.click();
			}
		}
	}
}
