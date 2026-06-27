package com.linklite.url_shortener.util;

import java.net.URI;

public class URLValidator {

    public static boolean isValid(String url) {

        try {
            URI uri = new URI(url);

            return uri.getScheme() != null &&
                    (uri.getScheme().equals("http") ||
                     uri.getScheme().equals("https"));

        } catch (Exception e) {
            return false;
        }
    }
}