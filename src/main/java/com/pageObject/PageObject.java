package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageObject {
    protected final WebDriver webDriver;
    private final Wait<WebDriver> wait;
    protected String url;

    public PageObject(WebDriver webDriver) {
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(2), Duration.ofSeconds(2));
        this.webDriver = webDriver;
    }

    public void open() {
        this.webDriver.get(this.url);
    }

    protected void waitElementClickable(By webElement) {
        this.wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitForVisibilityElement(By webElement) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
    }
}
