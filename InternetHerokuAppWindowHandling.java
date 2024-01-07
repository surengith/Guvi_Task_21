package com.SeleniumPracticeTask21.org;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InternetHerokuAppWindowHandling {

	public static void main(String[] args) {
		// Create driver instance for ChromeBrowser
		WebDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// Initiate global wait (implicitlyWait) for 10 seconds to load the xpath's
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigate to requirement URL
		driver.get("https://the-internet.herokuapp.com/windows");

		// Get the parent window handle
		String parentWindow = driver.getWindowHandle();

		// Click the "Click Here" button to open a new window
		WebElement clickHereButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickHereButton.click();

		// Iterate to switch to the new window
		Set<String> childWindow = driver.getWindowHandles();
		for (String windowhandle : childWindow) {
			driver.switchTo().window(windowhandle);
		}

		// Verify that the text "New Window" is present on the child window
		WebElement newWindowText = driver.findElement(By.xpath("//h3[text()='New Window']"));
		System.out.println(newWindowText.getText());

		// Close the browser
		driver.close();

		// Switch back to parent window and Verify that the original window is active
		driver.switchTo().window(parentWindow);
		WebElement originalWindowPage = driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']"));
		String originalWindowText = originalWindowPage.getText();

		if (originalWindowText.contains("Opening a new window")) {
			System.out.println("Switched back to the original window successfully");
		} else {
			System.out.println("Failed to switch back to original window");
		}

		// quite the driver instance
		driver.quit();
	}
}
