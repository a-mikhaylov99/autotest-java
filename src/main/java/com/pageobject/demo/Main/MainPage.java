package com.pageobject.demo.Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
public class MainPage {
    public WebDriver webDriver;
    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    @FindBy(xpath = "//*[@id=\"login_field\"]")
    private WebElement getLoginField;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement getPassword;
    @FindBy(xpath = "//*[@type=\"submit\"]")
    private WebElement getSubmitButton;
    public void login(String userName, String password) {
        getLoginField.click();
        getLoginField.sendKeys(userName);
        getPassword.click();
        getPassword.sendKeys(password);
        getSubmitButton.click();

    }


}
