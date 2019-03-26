package com.test.methods;

import java.security.SecureRandom;
import java.util.Arrays;


public class RandomWordsAndNumber {

    private static final String AB = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    private static final String ab = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
    private static SecureRandom rnd = new SecureRandom();

    public static String intRandomNumber(int maxValue) {
        int random_number = (int)(Math.random()*(maxValue - 1) + 1);
        return String.valueOf( random_number );
    }

    public static String randomNumber(int min, int max) {
        int random_number = min + (int) (Math.random() * max);
        String b = String.valueOf(random_number);
        return Arrays.toString( new String[]{b} );
    }

    public String randomStringBig(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public String randomStringLittle(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(ab.charAt(rnd.nextInt(ab.length())));
        return sb.toString();
    }

}
