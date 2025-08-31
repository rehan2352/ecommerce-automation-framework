package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menCategory = By.xpath("//span[normalize-space()='Men']");
    private By productItem = By.xpath("//img[@alt='Argus All-Weather Tank']");
    private By sizeOption = By.xpath("//div[@id='option-label-size-143-item-167']");
    private By colorOption = By.xpath("//div[@id='option-label-color-93-item-52']");
    private By addToCartBtn = By.xpath("//button[@id='product-addtocart-button']");
    private By successMsg = By.xpath("//div[contains(@data-bind,'message.text')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickMenCategory() {
        WebElement men = wait.until(ExpectedConditions.elementToBeClickable(menCategory));
        men.click();
        System.out.println("Men category clicked");
    }

    public void clickItem() {
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(productItem));
        item.click();
        System.out.println("Product clicked");
    }

    public void addToCart() {
        // Select size
        wait.until(ExpectedConditions.elementToBeClickable(sizeOption)).click();
        System.out.println("Size selected");

        // Select color
        wait.until(ExpectedConditions.elementToBeClickable(colorOption)).click();
        System.out.println("Color selected");

        // Click Add to Cart
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        System.out.println("Add to Cart clicked");

        // Wait for confirmation message
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
        System.out.println("Product added to cart successfully");
    }
}
