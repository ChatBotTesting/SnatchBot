package com.cbautomate.tests;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cbautomate.pages.ChatBotAssertionPage;
import com.cbautomate.pages.HomePage;
import com.cbautomate.pages.LoginPage;
import com.cbautomate.properties.ReadPropertyHelper;
import com.cbautomate.utilities.WebdriverUtils;

/**
 * This class describes chat bot creation test.
 *
 * @since 09/01/2021
 */

public class SnatchBotTests extends WebdriverUtils {

	/*
	 * 1- User Login 2- Search for Bot and Configure 3- Add and Assert Bot
	 * functionalities.
	 * 
	 */

	LoginPage loginPage;
	HomePage homePage;
	ChatBotAssertionPage chatBotAssertionPageObject;
    public static String userId ;
	public static String password;

	// 1- Test to verify the login to SnatchBot.me site 
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws IOException, InterruptedException {

		test = extent.createTest("UserCanRegisterSuccssfully");
		loginPage = new LoginPage(driver);
		loginPage.openRegistrationPageAndLogin("cbauto983@gmail.com" , "cbAuto123");
		homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getTitle(), "Dashboard - SnatchBot");
		test.info("Login Successful , Title found for Home Page " + homePage.getTitle());

	}

	// 2- Test to verify the search For My Bot and Rename the Bot
	
	@Test(priority = 2)
	public void userCanConfigureChatBot() throws IOException, InterruptedException {
		int n = 100 + new Random().nextInt(900);
		String botTitle = "MyTestHealthCare Bot_" + n;
		test = extent.createTest("userCanConfigureChatBot");
		homePage.updateBotName(botTitle);
     	
	}

	// 3- Test to verify the conversation between the BOT and the user for Reception Schedule flow
	
	@Test(priority = 1,alwaysRun = true)
	public void chatBotFunctionAndAssertionMethod() throws IOException, InterruptedException {
		test = extent.createTest("chatBotFunctionAndAssertionMethod");
		chatBotAssertionPageObject = new ChatBotAssertionPage(driver);
		chatBotAssertionPageObject.chatBotsOpsAndAssertion();
	}

}
