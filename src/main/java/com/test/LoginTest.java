package com.test;

import com.data.ConfProperties;
import com.pageObject.LoginPage;
import com.pageObject.MainPage;
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
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        loginPage.open();
    }

    @Test
    public void loginTest() {
        loginPage.login(
                ConfProperties.getProperty("login"),
                ConfProperties.getProperty("sashacleverboy1999")
                );
        mainPage.openUserMenu();
        String login = mainPage.getLoginText();
        Assert.assertEquals("a-mikhaylov99", login);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}