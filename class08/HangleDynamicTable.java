package com.syntax.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HangleDynamicTable {

	public static String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fdefault.aspx";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
		username.sendKeys("Tester");

		WebElement password = driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
		password.sendKeys("test");

		WebElement login = driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button"));
		login.click();

		Thread.sleep(3000);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));
		System.out.println("Number of rows: " + rows.size());

		for (int i = 0; i < rows.size(); i++) {
			String rowTxt = rows.get(i).getText();
			System.out.println(rowTxt);
			if (rowTxt.contains("Bob Feather")) {
				driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[1]")).get(i).click();
				break;
			}

		}

	}
}
