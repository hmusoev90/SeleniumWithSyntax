package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		long startTime = System.currentTimeMillis();
		driver.get(
				"https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
		driver.findElement(By.name("customer.firstName")).sendKeys("John");
		driver.findElement(By.name("customer.lastName")).sendKeys("Wick");
		driver.findElement(By.name("customer.address.street")).sendKeys("625 East Vista Ridge Mall Dr");
		driver.findElement(By.id("customer.address.city")).sendKeys("Dallas");
		driver.findElement(By.id("customer.address.state")).sendKeys("Texas");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("75067");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("6767156595");
		driver.findElement(By.id("customer.ssn")).sendKeys("123-45-6789");
		driver.findElement(By.id("customer.username")).sendKeys("JohnWick02");
		driver.findElement(By.id("customer.password")).sendKeys("Wick0101");
		driver.findElement(By.id("repeatedPassword")).sendKeys("Wick0101");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
		Thread.sleep(3000);
		driver.close();

		long endTime = System.currentTimeMillis();
		int elapcedTime = (int) ((endTime - startTime) / 1000);
		System.out.println("Test Time : " + elapcedTime + " seconds");

	}
}
