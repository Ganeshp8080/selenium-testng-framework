package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.parctice.driver.DriverManager;
import com.practice.enums.WaitiStrategy;
import com.practice.factory.ExplicitWaitFactory;

public class BasePage {

	protected BasePage() {

	}

	protected void click(By by, WaitiStrategy waitStrategy) {

		WebElement webElement = ExplicitWaitFactory.waitForElement(waitStrategy, by);
		webElement.click();
	}

	protected void sendKeys(By by, String str, WaitiStrategy waitStrategy) {
		WebElement webElement = ExplicitWaitFactory.waitForElement(waitStrategy, by);
		webElement.sendKeys(str);

	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected String getText(By by) {
		return DriverManager.getDriver().findElement(by).getText();
	}

}
