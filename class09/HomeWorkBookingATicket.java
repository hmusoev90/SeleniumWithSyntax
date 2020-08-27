package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkBookingATicket {

	/*
	 * Go to aa.com/homePage.do select depart date select return date select
	 * destination click on search quit the browser
	 * 
	 */

	public static String url = "https://www.aa.com";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement roundTripRB = driver
				.findElement(By.xpath("//label[@for='flightSearchForm.tripType.roundTrip']/span[@class='control']"));
		if (!roundTripRB.isSelected()) {
			roundTripRB.click();
		}

		// From Text Box Web Element
		WebElement fromTxtBox = driver
				.findElement(By.cssSelector("input[id='reservationFlightSearchForm.originAirport']"));
		fromTxtBox.clear();
		fromTxtBox.sendKeys("San Antonio");

		// To TextBox WebElement

		WebElement ToTxtBox = driver
				.findElement(By.xpath("//label[@for='reservationFlightSearchForm.destinationAirport']/input"));
		ToTxtBox.sendKeys("New York");

		// Number of Passangers
		WebElement numberOfPass = driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount"));
		Select select = new Select(numberOfPass);
		select.selectByValue("2");

		Thread.sleep(3000);

		// Departure Calendar
		WebElement departureCal = driver.findElement(By.id("aa-leavingOn"));
		departureCal.click();

		// List of All days
		List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement day : days) {
			String d = day.getText();
			if (d.equals("31")) {
				day.click();
				break;
			}
		}

		Thread.sleep(3000);

		// Return Calendar
		WebElement returnCal = driver.findElement(By.id("aa-returningFrom"));
		returnCal.click();

		// List of Days 2
		List<WebElement> days2 = driver.findElements(
				By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']/table/tbody/tr/td"));
		for (WebElement day : days2) {
			String d = day.getText();
			if (d.equals("5")) {
				day.click();
				break;
			}
		}

		Thread.sleep(3000);

		System.out.println("From: " + fromTxtBox.getText());
		System.out.println("To: " + ToTxtBox.getText());
		System.out.println("Departure Date: " + departureCal.getText());
		System.out.println("Return Date: " + returnCal.getText());
		// Search Button

		WebElement searchButton = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
		searchButton.click();

		Thread.sleep(3000);

		driver.quit();

	}
}
