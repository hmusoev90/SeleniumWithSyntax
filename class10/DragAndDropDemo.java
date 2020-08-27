package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	public static String url = "https://jqueryui.com/droppable/";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		// Switching to Frame
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));

		Thread.sleep(3000);
		Actions action = new Actions(driver);
		// action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();

		action.dragAndDrop(draggable, droppable).perform();

		
		//Refreshing Page
		driver.navigate().refresh();
		

	}
}
