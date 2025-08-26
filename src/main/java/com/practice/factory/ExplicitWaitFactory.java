package com.practice.factory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parctice.driver.DriverManager;
import com.practice.constants.FrameworkConstants;
import com.practice.enums.WaitiStrategy;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {

	}

	public static WebElement waitForElement(WaitiStrategy strategy, By by) {

		WebElement element;

		if (strategy == WaitiStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.elementToBeClickable(by));
			return element;

		} else if (strategy == WaitiStrategy.VISIBILITY) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
			return element;
		} else if (strategy == WaitiStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.presenceOfElementLocated(by));
			return element;
		} else {
			element = DriverManager.getDriver().findElement(by);
			return element;
		}

	}

}
