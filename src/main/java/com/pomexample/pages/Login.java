package com.pomexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;
    By userName = By.name("uid");
    By password = By.name("password");
    By titleText =By.className("barone");
    By login = By.name("btnLogin");

    public Login(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }

    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickLogin(){
        driver.findElement(login).click();
    }

    public String getLoginTitle(){
        return	driver.findElement(titleText).getText();
    }

    public void loginToGuru99(String strUserName,String strPassword){
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickLogin();
    }
}
