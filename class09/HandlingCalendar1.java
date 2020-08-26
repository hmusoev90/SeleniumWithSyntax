package com.syntax.class09;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingCalendar1 {

	public static String url = "http://18.232.148.34/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement userName = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		userName.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");
		loginButton.click();

		WebElement leaveButton = driver.findElement(By.xpath("//b[text()='Leave']"));
		leaveButton.click();
		WebElement leaveList = driver.findElement(By.linkText("Leave List"));
		leaveList.click();

		// 1st Calendar
		WebElement calendar1 = driver.findElement(By.id("calFromDate"));
		calendar1.click();

		// Selecting Month by Visible Text
		WebElement mDD = driver.findElement(By.className("ui-datepicker-month"));
		Select monthDD = new Select(mDD);
		monthDD.selectByVisibleText("Oct");

		// Selecting Year by Visible Text
		WebElement yDD = driver.findElement(By.className("ui-datepicker-year"));
		Select yearDD = new Select(yDD);
		yearDD.selectByVisibleText("1990");

		// Selecting Day by Table
		List<WebElement> calendarTable = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

		for (WebElement dates : calendarTable) {
			String date = dates.getText();
			if (date.equals("12")) {
				dates.click();
				break;
			}
		}

	}
}
