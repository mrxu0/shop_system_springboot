package com.shop.system.utils;

import java.util.Random;

public class RandomString {
    private int length;
    public RandomString(int length) {
        this.length = length;
    }

    public String getRandom() {
        Random random = new Random();
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ;i < this.length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
