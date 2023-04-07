package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {
    protected String url = "https://github.com/login";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        super.url = this.url;
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

    private By getErrorMessage() {
        return By.xpath("//div[@id=\"js-flash-container\"]");
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

    public Boolean errorMessageIsExist() {
        WebElement getErrorMessage = this.webDriver.findElement(getErrorMessage());
        this.waitForVisibilityElement(getErrorMessage());
        return getErrorMessage.isDisplayed();
    }

    @Override
    public void open() {
        super.open();
    }
}
