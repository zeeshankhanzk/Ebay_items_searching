package com.ebay.carSEARCH;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(_23_TestNG_Listeners_Re_Run_Failed_Tests._04_02_ITestListener_ListenerTest_For_Scenarios.class)

public class _04_01_ITestListener_Test_Cases_Having_Scenarios {

	static WebDriver driver;

	@Test
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com.au/");
		System.out.println("TC: openBrowser");
	}

	/*
	 * @Test(dependsOnMethods = "openBrowser") public void login() throws
	 * InterruptedException { driver.findElement(By.
	 * xpath("//span[@class='gh-ug-guest']//a[contains(text(),'Sign in')]")).click()
	 * ; Thread.sleep(2000);
	 * 
	 * driver.findElement(By.xpath("//div[contains(text(),'Continue with email')]"))
	 * .click(); Thread.sleep(2000);
	 * 
	 * driver.findElement(By.xpath("//input[@name='userid']")).sendKeys(
	 * "zeeshankhanzk@gmail.com"); Thread.sleep(2000);
	 * driver.findElement(By.xpath("//button[@name='signin-continue-btn']")).click()
	 * ; Thread.sleep(2000);
	 * driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Friendship1")
	 * ; Thread.sleep(2000);
	 * driver.findElement(By.xpath("//button[@name='sgnBt']")).click();
	 * Thread.sleep(3000); System.out.println("TC: login"); }
	 */

	@Test(dependsOnMethods = "openBrowser")
	public void carSearching() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("BMW");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
		WebElement numberofCars = driver.findElement(By.xpath("//div[@id='mainContent']/div/div[2]/div[2]/div/div/h1/span"));
		System.out.println("List of cars on the page: " + numberofCars.getText());
		System.out.println("TC: carSearching");
		// Assert.fail("Intentionally failing the test case 3");
		//throw new SkipException("Intentionally skipping the testToSkip");
	}
	
	@Test(dependsOnMethods = "carSearching")
	public void carDetails() throws InterruptedException {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		WebElement element = driver.findElement(By.xpath("//img[contains(@alt,'BMW M SPORT')]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", element);
		//driver.findElement(By.xpath("//img[contains(@alt,'BMW M SPORT')]")).click();
		Thread.sleep(2000);
		WebElement ebayNumber = driver.findElement(By.xpath("//div[@class='u-flL iti-act-num itm-num-txt']"));
		System.out.println("Ebay Item Number: "+ ebayNumber.getText());
	}
	
	@Test(dependsOnMethods = "carDetails")
	public void browserQuit() {
		System.out.println("TC: browserQuit");
		driver.quit();
	}
}
