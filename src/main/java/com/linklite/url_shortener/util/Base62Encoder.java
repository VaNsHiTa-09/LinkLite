package com.linklite.url_shortener.util;

public class Base62Encoder {

    private static final String CHARACTERS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String encode(long number) {

        StringBuilder shortUrl = new StringBuilder();

        while (number > 0) {

            shortUrl.append(CHARACTERS.charAt((int) (number % 62)));

            number /= 62;
        }

        return shortUrl.reverse().toString();
    }
}