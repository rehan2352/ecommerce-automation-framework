package com.ecommerce.tests;

import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        // Page object init
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testCheckoutFlow() {
        // 1. Login
        loginPage.login("zk2390405@gmail.com", "Zahir@06");

        // 2. Proceed to checkout
        checkoutPage.proceedToCheckout();

        // 3. Next button (15s wait inside method)
        checkoutPage.clickNext();

        // 4. Place order
        checkoutPage.placeOrder();

        // 5. Verify order success message
        String successMsg = checkoutPage.getSuccessMessage();
        Assert.assertTrue(successMsg.contains("Thank you for your purchase"),
                "❌ Order was not placed successfully!");

        System.out.println("✅ Order placed successfully!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
