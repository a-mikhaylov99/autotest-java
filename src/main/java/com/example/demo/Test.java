package com.example.demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crtweb.ru/");
        driver.quit();
    }
}