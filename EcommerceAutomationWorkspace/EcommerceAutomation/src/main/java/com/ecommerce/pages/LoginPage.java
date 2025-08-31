package com.ecommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Enter Email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).clear();
        driver.findElement(By.id("email")).sendKeys("zk2390405@gmail.com");

        // Enter Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass"))).clear();
        driver.findElement(By.id("pass")).sendKeys("Zahir@06");

        // Click Sign In button
        WebElement signInBtn = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInBtn);

        System.out.println("Sign In button clicked, waiting for captcha");

        // Captcha solve karne ke liye rukna hoga
        try {
            Thread.sleep(20000); // 20 sec rukega
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Continue test after solving captcha");
    }

}
