package com.test;

import com.data.ConfProperties;
import com.data.UserRegistry;
import com.pageObject.LoginPage;
import com.pageObject.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    public String testMask = "login-test";
    public static ChromeDriver driver;
    public static ChromeOptions chromeOptions;
    public static LoginPage loginPage;
    public static MainPage mainPage;
    private UserRegistry userRegistry;

    @BeforeEach
    public void login() {
        userRegistry = new UserRegistry();
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        loginPage.open();
    }

    @Test
    public void loginTest() {
        loginPage.login(
                ConfProperties.getProperty("login"),
                ConfProperties.getProperty("password")
        );
        mainPage.openUserMenu();
        String login = mainPage.getLoginText();
        Assertions.assertEquals(ConfProperties.getProperty("login"), login);
    }

    @Test
    public void loginWrongPassword() {
        loginPage.login(
                ConfProperties.getProperty("login"),
                userRegistry.getRandomString(testMask)
        );
        Assertions.assertTrue(loginPage.errorMessageIsExist());
    }

    @Test
    public void loginWrongLogin() {
        loginPage.login(
                userRegistry.getRandomString(testMask),
                ConfProperties.getProperty("password")
        );
        Assertions.assertTrue(loginPage.errorMessageIsExist());
    }

    @Test
    public void loginIncorrectData() {
        loginPage.login(
                userRegistry.getRandomString(testMask),
                userRegistry.getRandomString(testMask)
        );
        Assertions.assertTrue(loginPage.errorMessageIsExist());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}