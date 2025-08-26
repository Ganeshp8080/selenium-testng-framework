package com.practice.pages;

import org.openqa.selenium.By;

import com.practice.enums.WaitiStrategy;

public class OrangeHRMHomePage extends BasePage {

	private static By button_profileDropdown = By.xpath("//*[@class='oxd-userdropdown-img']");

	private static By button_logout = By.linkText("Logout");

	public OrangeHRMHomePage clickProfileDropdown() {
		click(button_profileDropdown, WaitiStrategy.CLICKABLE);
		return this;
	}

	public OrangeHRMLoginPage clickLogoutButton() {
		click(button_logout, WaitiStrategy.CLICKABLE);
		return new OrangeHRMLoginPage();
	}

}
