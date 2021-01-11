package com.cbautomate.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cbautomate.utilities.BasePageUtils;
import com.cbautomate.utilities.Constants;

public class ChatBotAssertionPage extends BasePageUtils {
	public ChatBotAssertionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='sntch_button']")
	public WebElement clickBotInterface;

	@FindBy(xpath = "//div[@class='mat-form-field-infix']/textarea")
	public WebElement botMessageArea;

	@FindBy(xpath = "(//div[@class='ps-content']/div/div/div[2]/div/div/p)")
	public WebElement botMessageAreaText;

	@FindBy(xpath = "//span[text()='Reception schedule']/../../button")
	public WebElement receptionSchedule;

	@FindBy(xpath = "(//div[@class='ps-content']/div/div/div[2]/div/div/p)[3]")
	public WebElement checkRecemptionSchedule;

	@FindBy(xpath = "//button/span[text()='See our contacts']")
	public WebElement contactsMenu;

	@FindBy(xpath = "//button/span[text()='Back to menu']")
	WebElement quotesMenu;

	@FindBy(xpath = "//div[@id='sntch_close']")
	WebElement closeWindow;

	@FindBy(xpath = "//label[text()='Logout']")
	WebElement logout;

	/**
	 * Method to test the Reception Schedule flow for Chat Bot conversation
	 * 
	 *
	 * @since 09/01/2021
	 */
	public void chatBotsOpsAndAssertion() throws IOException, InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals(true, botMessageArea.isDisplayed());
		clickButton(clickBotInterface);
		driver.switchTo().frame("sntch_iframe");
		assertContains(Constants.TEXTVERIFICATIONONE, botMessageAreaText.getText());
		clickButton(receptionSchedule);
		clickButton(contactsMenu);
		clickButton(quotesMenu);
		driver.switchTo().defaultContent();
		clickButton(closeWindow);
		clickButton(logout);

	}

}
