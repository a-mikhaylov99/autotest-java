package com.pageobject.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver webDriver;
    private final Wait<WebDriver> wait;

    public MainPage(WebDriver webDriver) {
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(2), Duration.ofSeconds(2));
        this.webDriver = webDriver;
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

    public String getLoginText() {
        this.waitForVisibilityElement(this.getUserLogin());
        return this.webDriver.findElement(getUserLogin()).getText();
    }

    private void waitForVisibilityElement(By webElement) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
    }

    private void waitElementClickable(By webElement) {
        this.wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
