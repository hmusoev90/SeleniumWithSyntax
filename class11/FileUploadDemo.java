package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {

	public static String url = "https://the-internet.herokuapp.com/";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		// 0.File Upload link WebElement
		WebElement fileUploadLink = driver.findElement(By.linkText("File Upload"));
		fileUploadLink.click();

		// 1. Choose File Button
		WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
		String xlsFilePath = "C:\\Users\\Habib\\eclipse-workspace\\00JavaSDET(with Syntax)\\TestData\\Result.xlsx";
		chooseFileButton.sendKeys(xlsFilePath);

		Thread.sleep(3000);

		// 2. Upload Button
		WebElement uploadButton = driver.findElement(By.id("file-submit"));
		uploadButton.click();

		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	}
}
