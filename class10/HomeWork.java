package com.syntax.class10;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWork {
	public static String url = "https://artoftesting.com/samplesiteforselenium";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Sample Page Link WebElement
		WebElement samplePage = driver.findElement(By.linkText("Sample Page"));
		samplePage.click();

		// MainPage Window Handle
		String mainPageHangle = driver.getWindowHandle();

		// 0. This is a link locator
		WebElement link = driver.findElement(By.linkText("This is a link"));
		link.click();

		// All Windows Handles
		Set<String> allWindowHangles = driver.getWindowHandles();

		Iterator<String> itWindowHangles = allWindowHangles.iterator();
		while (itWindowHangles.hasNext()) {
			String windowHangle = itWindowHangles.next();
			if (!windowHangle.equals(mainPageHangle)) {
				driver.switchTo().window(windowHangle);
				Thread.sleep(2000);
				driver.close();
			}
		}

		// Switching back to HomePage
		driver.switchTo().window(mainPageHangle);

		// 1. TextBox WebElement and Sending keys
		WebElement textBox = driver.findElement(By.id("fname"));
		textBox.sendKeys("Hello World");

		// 2. Submit Button WebElement and Click
		WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
		submitButton.click();

		// Action object
		Actions action = new Actions(driver);

		// 3. Double-Click Button WebElement and DoubleClicking on it
		WebElement dcButton = driver.findElement(By.xpath("//button[text()='Double-click to generate alert box']"));
		action.doubleClick(dcButton).perform();

		// Handlig Double Click Alert
		Alert alert1 = driver.switchTo().alert();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Double Click Alert Message: " + alert1.getText());
		alert1.accept();

		// 4. Radio Buttons
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));

		for (WebElement radioButton : radioButtons) {
			String gender = radioButton.getAttribute("value");
			if (gender.equalsIgnoreCase("male")) {
				radioButton.click();
				break;
			}
		}

		// 5. CheckBoxes
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement checkBox : checkBoxes) {
			String chB = checkBox.getAttribute("value");
			if (chB.equalsIgnoreCase("performance")) {
				checkBox.click();
				break;
			}
		}

		Thread.sleep(3000);

		// 6. DropDown
		WebElement DropDown = driver.findElement(By.cssSelector("select#testingDropdown"));
		Select select = new Select(DropDown);
		select.selectByVisibleText("Database Testing");

		Thread.sleep(3000);

		// 7. AlerBox Button
		WebElement alerBoxButton = driver.findElement(By.xpath("//button[text()='Generate Alert Box']"));
		alerBoxButton.click();
		Alert alertBox = driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("AlertBox Button message: " + alertBox.getText());
		alertBox.accept();

		Thread.sleep(3000);

		// 8. ConfirmBox Alert Button
		WebElement confirmAlertButton = driver.findElement(By.xpath("//button[text()='Generate Confirm Box']"));
		confirmAlertButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert confirmAlert = driver.switchTo().alert();
		System.out.println("ConfirmBox Alert Message: " + confirmAlert.getText());
		confirmAlert.dismiss();

		Thread.sleep(2000);

		// 9. Drag and Drop
		WebElement draggableIMG = driver.findElement(By.id("sourceImage"));
		WebElement droppabgle = driver.findElement(By.id("targetDiv"));
		// action.dragAndDrop(draggableIMG, droppabgle).perform();
		action.clickAndHold(draggableIMG).moveToElement(droppabgle).release().build().perform();
		// Thread.sleep(3000);
		// driver.close();

	}

}
