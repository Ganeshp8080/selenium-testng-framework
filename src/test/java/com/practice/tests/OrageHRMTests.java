package com.practice.tests;

import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.practice.enums.ConfigProperties;
import com.practice.pages.OrangeHRMLoginPage;
import com.practice.utils.PropertyUtil;

public final class OrageHRMTests extends BaseTest {

	private OrageHRMTests() {

	}

	@Test
	public void loginLogoutTest() throws Exception {

		String pageTitle = new OrangeHRMLoginPage().enterUserName(PropertyUtil.get(ConfigProperties.USERNAME))
				.enterPassword(PropertyUtil.get(ConfigProperties.PASSWORD)).clickLogin().clickProfileDropdown()
				.clickLogoutButton().getPageTitle();
		Assertions.assertThat(pageTitle).isEqualTo("OrangeHRM");
		System.out.println("conflict");
        System.out.println("conflict1");
        System.out.println("conflict2");


	}

}
