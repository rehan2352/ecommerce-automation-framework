package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("zk2390405@gmail.com", "Zahir@06");

        System.out.println("Login successful");
        
    }
}
