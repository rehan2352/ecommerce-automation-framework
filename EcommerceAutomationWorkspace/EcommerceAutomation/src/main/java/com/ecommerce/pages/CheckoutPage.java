package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By cartBtn = By.cssSelector("a.action.showcart");
    private By proceedToCheckoutBtn = By.id("top-cart-btn-checkout");
    private By nextBtn = By.xpath("//button[@data-role='opc-continue']");
    private By placeOrderBtn = By.xpath("//button[@title='Place Order']");
    private By orderSuccessMsg = By.xpath("//span[contains(text(),'Thank you for your purchase')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Open mini cart and go to checkout
    public void proceedToCheckout() {
        try {
            WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBtn));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartIcon);
            System.out.println("Cart icon clicked");

            WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutBtn);
            System.out.println("Proceeded to checkout successfully");

        } catch (Exception e) {
            System.out.println("Failed at proceedToCheckout: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // Click on next button (Shipping → Payment)
    public void clickNext() {
        try {
            System.out.println("Waiting 15s before clicking Next...");
            Thread.sleep(15000); // Hard wait for page/address auto-fill

            wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
            System.out.println("Next clicked");
        } catch (Exception e) {
            System.out.println("Failed at Next button: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // Place order
    public void placeOrder() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement placeOrderBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Place Order']"))
            );

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrderBtn);

            // Normal click
            placeOrderBtn.click();
            System.out.println("Place Order clicked successfully");

        } catch (ElementClickInterceptedException e) {
            // Fallback to JS click
            WebElement placeOrderBtn = driver.findElement(By.xpath("//button[@title='Place Order']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderBtn);
            System.out.println(" Place Order clicked using JS executor (fallback)");
        }
    }


    // Verify success message
    public String getSuccessMessage() {
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessMsg));
        return success.getText();
    }
}
