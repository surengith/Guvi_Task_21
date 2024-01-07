package com.SeleniumPracticeTask21.org;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InternetHerokuAppiFrame {

	public static void main(String[] args) throws InterruptedException {
		// Create driver instance for ChromeBrowser
		WebDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// Initiate global wait (implicitlyWait) for 10 seconds to get the URL
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigate to requirement URL
		driver.get("https://the-internet.herokuapp.com/iframe");

		// Switch to frame using XPath
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(frame);

		// Locate the text area inside the frame using XPath and Clear the existing text
		// and write the text "Hello People"
		WebElement textArea = driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']"));
		textArea.clear();
		textArea.sendKeys("Hello People.");

		// Locate the text area using XPath verify and print the text in the console
		WebElement textMessage = driver.findElement(By.xpath("//body[@id='tinymce']"));

		String actualText = textMessage.getText();
		String expectedText = "Hello People.";

		if (actualText.equals(expectedText)) {
			System.out.println("Entered text is successfully verified: " + actualText);
		} else {
			System.out.println("Entered text is verified unsuccessful: " + actualText);
		}

		// Switch back to the default content
		driver.switchTo().defaultContent();

		// Finally quit the browser
		driver.quit();
	}

}
