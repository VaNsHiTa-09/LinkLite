package com.linklite.url_shortener.repository;

public interface UrlRepository {

    void save(String shortCode, String originalUrl, long minutes);

    String findByShortCode(String shortCode);

    void incrementClickCount(String shortCode);

    Long getClickCount(String shortCode);
}