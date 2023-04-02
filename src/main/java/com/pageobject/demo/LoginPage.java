package com.pageobject.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final String url = "https://github.com/login";
    private final WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By getLoginField() {
        return By.id("login_field");
    }

    private By getPassword() {
        return By.id("password");
    }

    private By getSubmitButton() {
        return By.xpath("//*[@type=\"submit\"]");
    }

    public void login(String userName, String password) {
        WebElement getLoginField = this.webDriver.findElement(getLoginField());
        WebElement getPassword = this.webDriver.findElement(getPassword());
        WebElement getSubmitButton = this.webDriver.findElement(getSubmitButton());
        getLoginField.sendKeys(userName);
        getPassword.click();
        getPassword.sendKeys(password);
        getSubmitButton.click();
    }

    public void open() {
        webDriver.get(url);
    }
}
