package com.syntax.class08;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HangleStaticWebTables {
	public static String url = "http://syntaxtechs.com/selenium-practice/table-search-filter-demo.php";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		// Getting Table Header
		List<WebElement> tableHeaders = driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("Number of cells in Header: " + tableHeaders.size());

		for (WebElement tableHeader : tableHeaders) {
			String tableHeaderTxt = tableHeader.getText();
			System.out.printf("%s\t", tableHeaderTxt);
		}

		System.out.println("\n--------------------------------------");
		List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("Number of rows: " + rowData.size());

		Iterator<WebElement> it = rowData.iterator();

		while (it.hasNext()) {
			WebElement row = it.next();
			String rowTxt = row.getText();
			System.out.println(rowTxt);
		}

	}
}
