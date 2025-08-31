package com.ecommerce.tests;

import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private CartPage cartPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void testAddToCart() {
        try {
            //  Login
            loginPage.login("zk2390405@gmail.com", "Zahir@06");

            //  Go to Men Category
            cartPage.clickMenCategory();

            // Click Product
            cartPage.clickItem();

            // Add to cart (with size + color)
            cartPage.addToCart();

            //  Verify success message
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            String successMsg = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message-success"))
            ).getText();

            Assert.assertTrue(successMsg.contains("You added"), "Product not added to cart");
            System.out.println("Test Passed: Product added to cart");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test Failed: " + e.getMessage());
        }
    }

    
}
