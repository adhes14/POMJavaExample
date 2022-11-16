package com.pomexample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePage {
    WebDriver driver;
    By homePageUserName = By.xpath("//table//tr[@class='heading3']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageDashboardUserName() {
        return driver.findElement(homePageUserName).getText();
    }
}
