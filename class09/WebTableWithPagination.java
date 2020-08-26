package com.syntax.class09;

import java.util.List;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableWithPagination {
	public static String url = "http://syntaxtechs.com/selenium-practice/table-pagination-demo.php";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr"));
		WebElement next = driver.findElement(By.xpath("//a[@class='page_link']"));

		boolean flag = true;

		while (flag) {
			for (WebElement row : rows) {
				String rowText = row.getText();
				if (rowText.contains("Archy J")) {
					flag = false;
					System.out.println(rowText);
					break;
				}
			}
			next.click();
		}

		driver.quit();
	}
}
