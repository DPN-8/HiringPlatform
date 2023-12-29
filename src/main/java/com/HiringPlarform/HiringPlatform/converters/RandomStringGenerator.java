package com.HiringPlarform.HiringPlatform.converters;

import java.util.Random;

public class RandomStringGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String   generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            randomString.append(CHARACTERS.charAt(index));
        }
        return randomString.toString();
    }

    public static Long generateRandomLong(int length) {
        StringBuilder randomLong = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(52, CHARACTERS.length());
            randomLong.append(CHARACTERS.charAt(index));
        }
        return Long.parseLong(String.valueOf(randomLong));
    }
}
