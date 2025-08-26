package com.practice.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.parctice.driver.Driver;
import com.parctice.driver.DriverManager;
import com.practice.enums.ConfigProperties;
import com.practice.utils.PropertyUtil;

public class BaseTest {

	protected BaseTest() {

	}

	@BeforeMethod
	protected void setUP() throws Exception {

		Driver.initDriver();
		DriverManager.getDriver().get(PropertyUtil.get(ConfigProperties.URL));
	}

	@AfterMethod
	protected void tearDown() {

		Driver.quitDriver();
	}

}
