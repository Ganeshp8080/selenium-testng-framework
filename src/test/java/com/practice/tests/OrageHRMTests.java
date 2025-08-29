package com.practice.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.practice.enums.ConfigProperties;
import com.practice.pages.OrangeHRMLoginPage;
import com.practice.utils.PropertyUtil;

import java.util.HashMap;

public final class OrageHRMTests extends BaseTest {

	private OrageHRMTests() {

	}

	@Test(dataProvider = "login_data")
	public void loginLogoutTest( String username, String password) throws Exception {
/*
		String pageTitle = new OrangeHRMLoginPage().enterUserName(PropertyUtil.get(ConfigProperties.USERNAME))
				.enterPassword(PropertyUtil.get(ConfigProperties.PASSWORD)).clickLogin().clickProfileDropdown()
				.clickLogoutButton().getPageTitle();
 */
        String pageTitle = new OrangeHRMLoginPage().enterUserName(username)
                .enterPassword(password).clickLogin().clickProfileDropdown().clickLogoutButton().getPageTitle();

		Assertions.assertThat(pageTitle).isEqualTo("OrangeHRM");

	}
    @DataProvider(name="login_data"/*, parallel = true*/)
    public Object[][] getData(){
        Object[][] data= new Object[][]{{"Admin", "admin123"},{"Admin", "admin123"}};
        return data;
    }

}
