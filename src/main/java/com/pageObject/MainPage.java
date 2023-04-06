package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends PageObject {
    protected String url = "https://github.com";

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        super.url = this.url;
    }

    public String getLoginText() {
        this.waitForVisibilityElement(this.getUserLogin());
        return this.webDriver.findElement(getUserLogin()).getText();
    }

    private By getUserAvatar() {
        return By.xpath("//summary//*[@alt=\"@a-mikhaylov99\"]");
    }

    private By getUserLogin() {
        return By.xpath("//details-menu//strong");
    }

    public void openUserMenu() {
        this.waitElementClickable(getUserAvatar());
        this.webDriver.findElement(getUserAvatar()).click();
    }

    @Override
    public void open() {
        super.open();
    }
}
