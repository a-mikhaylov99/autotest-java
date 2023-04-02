package com.example.demo;

import com.pageobject.demo.LoginPage;
import com.pageobject.demo.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    public ChromeDriver driver;
    public ChromeOptions chromeOptions;
    public LoginPage loginPage;
    public MainPage mainPage;

    @Before
    public void setup() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        loginPage.open();
    }

    @Test
    public void loginTest() {
        loginPage.login("", "");
        mainPage.openUserMenu();
        String login = mainPage.getLoginText();
        Assert.assertEquals("", login);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}