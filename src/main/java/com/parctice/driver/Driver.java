package com.parctice.driver;

import java.util.Objects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.practice.constants.FrameworkConstants;

public final class Driver {

	public static void initDriver() {

		//System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());

        WebDriverManager.chromedriver().setup();

		if (Objects.isNull(DriverManager.getDriver())) {

			WebDriver driver = new ChromeDriver();
			DriverManager.setDriver(driver);
		}
	}

	public static void quitDriver() {

		if (Objects.nonNull(DriverManager.getDriver())) {

			DriverManager.getDriver().quit();
		}

		DriverManager.unload();
	}

}
