package com.cbautomate.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.cbautomate.utilities.BasePageUtils;

public class HomePage extends BasePageUtils {
	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(xpath = "//a/label[text()='My Bots']")
	public WebElement myBotslink;

	@FindBy(xpath = "//button[@data-test='bot-action-configure']/span")
	public WebElement configureBtn;

	@FindBy(xpath = "//input[@name='name']")
	public WebElement botNameBtn;
	
	@FindBy(xpath = "//.[@data-test='bot_profile_name_input']")
	public WebElement botNameField;

	@FindBy(xpath = "//input[@name='description']")
	public WebElement botDescBtn;

	@FindBy(xpath = "//div/div[2]/h4")
	public WebElement clickBot;

	@FindBy(linkText = "Computers")
	WebElement ComputerMenu;

	@FindBy(linkText = "Notebooks")
	WebElement NotbooksMenu;
	
	@FindBy(xpath = "//label[text()='logout']")
	public WebElement logOut;
	
	String botTitleXpath = "//h4[contains(text(),'%s')]";
	
	
	/**
	* This function returns the title of the page.
	*
	* @since   09/01/2021
	*/

	public String getTitle() {
		return driver.getTitle();
	}
	
	
	public void logOut() throws InterruptedException {
		clickButton(logOut);
	}
	
	public boolean botTitleExist(String botTitle) {
		String botXpathExpression=String.format(botTitleXpath,botTitle);
		return driver.findElement(By.xpath(botXpathExpression)).isDisplayed();
	}
	
	/**
	* Method to update  botname 
	*
	* @since   09/01/2021
	*/

	public void updateBotName(String botName) throws IOException, InterruptedException {
		clickButton(myBotslink);
		clickButton(configureBtn);
		clearText(botNameBtn);
		setTextElementText(botNameBtn, botName);
		clickButton(myBotslink);
		clickButton(clickBot);
		Thread.sleep(5000);
	}
	
	/**
	*  Method to get  botname 
	*
	* @since   09/01/2021
	*/
	public String getBotName() throws InterruptedException {
		clickButton(myBotslink);
		clickButton(configureBtn);
		String botName = getTextElementText(botNameField);
		clickButton(myBotslink);
		clickButton(clickBot);
		return botName;
	}

}
