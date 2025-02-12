package com.saucedemo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    private final WebDriver driver;

    // Web elements
    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize the web elements
    }

    // Action methods for InventoryPage
    public boolean isCartLinkVisible() {
        return cartLink.isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
