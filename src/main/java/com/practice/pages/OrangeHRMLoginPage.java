package com.practice.pages;

import org.openqa.selenium.By;

import com.practice.enums.WaitiStrategy;

public final class OrangeHRMLoginPage extends BasePage {

	private final By textbox_username = By.xpath("//*[@name='username']");
	private final By textbox_password = By.name("password");
	private final By button_login = By.tagName("button");

	public OrangeHRMLoginPage enterUserName(String userName) throws Exception {
		sendKeys(textbox_username, userName, WaitiStrategy.VISIBILITY);
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textbox_password, password, WaitiStrategy.VISIBILITY);
		return this;
	}

	public OrangeHRMHomePage clickLogin() {
		click(button_login, WaitiStrategy.NONE);
		return new OrangeHRMHomePage();
	}
	
	public String getPageTitle() {
		return getTitle();
	}

}
