package com.linklite.url_shortener.service;

import com.linklite.url_shortener.dto.UrlResponse;

public interface UrlService {

    UrlResponse shortenUrl(String originalUrl);

    String getOriginalUrl(String shortCode);

    void incrementClickCount(String shortCode);

    Long getClickCount(String shortCode);
}