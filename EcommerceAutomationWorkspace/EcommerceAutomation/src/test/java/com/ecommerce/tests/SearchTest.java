package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.SearchPage;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
	@Test
	public void testSearchProduct() {
	    // Login
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.login("zk2390405@gmail.com", "Zahir@06");

	    // Search
	    SearchPage searchPage = new SearchPage(driver);
	    searchPage.searchProduct("shirt");

    }
}
