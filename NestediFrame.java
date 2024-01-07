package com.SeleniumPracticeTask21.org;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestediFrame {

	public static void main(String[] args) throws InterruptedException {
		// Create driver instance for ChromeBrowser
		WebDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// Initiate global wait (implicitlyWait) for 10 seconds to load the xpath's
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigate to requirement URL
		driver.get("http://the-internet.herokuapp.com/nested_frames");

		// Switch to the top frame
		WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(topFrame);

		// Verify that there are three frames on the page
		int numberOfFrames = driver.findElements(By.tagName("frame")).size();
		if (numberOfFrames == 3) {
			System.out.println("Number of Frame is three and successfully verified");
		} else {
			System.out.println("Number of Frame is more than three and verification failed");
		}

		// Switch to the left frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-left']")));
		WebElement leftFrame = driver.findElement(By.tagName("body"));

		// Verify that the left frame has a text "LEFT"
		if (leftFrame.getText().contains("LEFT")) {
			System.out.println("LEFT Frame has been successfully verified");
		} else {
			System.out.println("LEFT Frame text verification is failed");
		}

		// Switch back to the top frame
		driver.switchTo().parentFrame();

		// Switch to the middle frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		WebElement middleFrame = driver.findElement(By.xpath("//div[@id='content']"));

		// Verify that the left frame has a text "MIDDLE"
		if (middleFrame.getText().contains("MIDDLE")) {
			System.out.println("MIDDLE Frame has been successfully verified");
		} else {
			System.out.println("MIDDLE Frame text verification is failed");
		}

		// Switch back to the top frame
		driver.switchTo().parentFrame();

		// Switch to the right frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));
		WebElement rightFrame = driver.findElement(By.tagName("body"));

		// Verify that the right frame has a text "RIGHT"
		if (rightFrame.getText().contains("RIGHT")) {
			System.out.println("RIGHT Frame has been successfully verified");
		} else {
			System.out.println("RIGHT Frame text verification is failed");
		}

		// Switch back to defaultContent
		driver.switchTo().defaultContent();

		// Switch to the bottom frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
		WebElement bottomFrame = driver.findElement(By.tagName("body"));

		// Verify that the bottom frame has a text "BOTTOM"
		if (bottomFrame.getText().contains("BOTTOM")) {
			System.out.println("BOTTOM Frame has been successfully verified");
		} else {
			System.out.println("BOTTOM Frame text verification is failed");
		}

		// Switch back to the top frame
		driver.switchTo().parentFrame();

		// Verify that the page has Frame Top PageSource
		boolean frameTop = driver.getPageSource().contains("frame-top");
		System.out.println("Page was successfully switched to top frame: " + frameTop);

		// Wait for 2 seconds and quit the browser
		Thread.sleep(2000);
		driver.quit();
	}

}
