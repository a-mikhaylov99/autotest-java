package com.data;

import org.apache.commons.lang.RandomStringUtils;

public class UserRegistry {
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String getRandomString(String mask) {
        return RandomStringUtils.randomAlphanumeric(10)
                + getRandomNumber(100, 10000)
                + System.currentTimeMillis()
                + mask;
    }
}
