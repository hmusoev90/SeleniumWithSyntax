package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HanglingFrames {
	public static String url = "http://www.uitestpractice.com/Students/Switchto";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);

		// Locating Frames by index
		driver.switchTo().frame(0);
		WebElement txtBox = driver.findElement(By.id("name"));
		txtBox.sendKeys("Hello World");

		// Switching to main page
		driver.switchTo().defaultContent();

		WebElement clickOnLinkTxt = driver.findElement(By.xpath("//h3[text()='click on the below link: ']"));
		String text = clickOnLinkTxt.getText();
		System.out.println(text);
		Thread.sleep(3000);
		
		//Switching to Frame by name
		driver.switchTo().frame("iframe_a");
		txtBox.clear();
		txtBox.sendKeys("Bowi Kijon");
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		//Switching to Frame by WebElement
		WebElement iframe = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
		driver.switchTo().frame(iframe);
		txtBox.clear();
		txtBox.sendKeys("The End");

	}
}
