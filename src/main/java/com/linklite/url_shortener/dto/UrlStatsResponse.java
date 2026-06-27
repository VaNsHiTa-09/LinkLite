package com.linklite.url_shortener.dto;

public class UrlStatsResponse {

    private String shortCode;
    private String originalUrl;
    private Long clicks;

    public UrlStatsResponse() {
    }

    public UrlStatsResponse(String shortCode, String originalUrl, Long clicks) {
        this.shortCode = shortCode;
        this.originalUrl = originalUrl;
        this.clicks = clicks;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }
}