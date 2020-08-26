package com.syntax.class10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightAndDoubleClick {

	public static String url = "http://demo.guru99.com/test/simple_context_menu.html";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement righClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action = new Actions(driver);

		action.contextClick(righClickButton).perform();// Right click on Button
		WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
		action.click(edit).perform();

		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();

		WebElement dblClickButton = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		action.doubleClick(dblClickButton).perform();
		System.out.println(alert.getText());
		Thread.sleep(2000);
		

	}
}
