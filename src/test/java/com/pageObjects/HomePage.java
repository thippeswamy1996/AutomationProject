package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {  // Keep BasePage only if it exists

    @FindBy(xpath = "//img[@src='application/view/image/icon/opencart-logo.png']")
    private WebElement home;

    public HomePage(WebDriver driver) {
        super(driver);  // Calls BasePage constructor
        
    }

    public void clickHome() {
        home.click();
    }
}
