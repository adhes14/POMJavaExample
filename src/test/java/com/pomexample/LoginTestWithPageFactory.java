package com.pomexample;

import java.util.concurrent.TimeUnit;

import com.pomexample.pageFactory.HomePage;
import com.pomexample.pageFactory.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginTestWithPageFactory {
    WebDriver driver;
    Login objLogin;
    HomePage objHomePage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testHomePageAppearCorrect() {
        objLogin = new Login(driver);
        String loginPageTitle = objLogin.getLoginTitle();

        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

        objLogin.loginToGuru99("mgr123", "mgr!23");
        objHomePage = new HomePage(driver);

        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }
}