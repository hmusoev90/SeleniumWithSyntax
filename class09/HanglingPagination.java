package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HanglingPagination {

	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement login = driver.findElement(By.cssSelector("input#txtUsername"));
		WebElement password = driver.findElement(By.cssSelector("input#txtPassword"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin'"));

		login.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");
		login.click();

		WebElement pim = driver.findElement(By.linkText("PIM"));
		pim.click();

		WebElement addEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
		addEmployee.click();

		WebElement firstName = driver.findElement(By.id("firstName"));
		WebElement lastName = driver.findElement(By.id("lastName"));
		firstName.sendKeys("Ali");
		lastName.sendKeys("Nazarov");
		
		WebElement empIdElement = driver.findElement(By.id("employeeId"));
		
		
	}
}