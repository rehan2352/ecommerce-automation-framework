package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    private By searchBox = By.xpath("//input[@id='search']");
    private By searchBtn = By.xpath("//button[@title='Search']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String product) {
        driver.findElement(searchBox).sendKeys("shirt");
        driver.findElement(searchBtn).click();
        
    }
}
