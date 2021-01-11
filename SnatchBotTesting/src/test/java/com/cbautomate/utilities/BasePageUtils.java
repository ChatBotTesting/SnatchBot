package com.cbautomate.utilities;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * This class describes base page utilities and its methods.
 *
 * @since 09/01/2021
 */
public class BasePageUtils extends WebdriverUtils {

	protected WebDriver drvier;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;

	// create constructor
	public BasePageUtils(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button) throws InterruptedException {
		button.click();
		Thread.sleep(3000);
	}

	protected static void changeFrame() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.switchTo().frame("sntch_iframe");
		Thread.sleep(3000);
	}

	protected static void setTextElementText(WebElement textElement, String value) throws InterruptedException {
		Thread.sleep(3000);
		textElement.sendKeys(value);

	}

	protected static String getTextElementText(WebElement textElement) throws InterruptedException {
		Thread.sleep(5000);
		return textElement.getText();

	}

	protected static void assertContains(String value, String valueNew) {
		assertTrue(valueNew.contains(value));
	}

	public void scrollToBottom()

	{
		jse.executeScript("scrollBy(0,2500)");
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public void explicitWait() throws IOException, InterruptedException {
		int waitFor = Integer.parseInt(getProperty("waitTime"));
		Thread.sleep(waitFor);
	}

	public static String getProperty(String propertyName) throws IOException {
		FileReader reader = new FileReader("userdata.properties");
		Properties configProp = new Properties();
		configProp.load(reader);
		return configProp.getProperty(propertyName);

	}
}
