package com.linklite.url_shortener.dto;

import jakarta.validation.constraints.NotBlank;

public class UrlRequest {

    @NotBlank(message = "URL cannot be empty")
    private String url;

    public UrlRequest() {
    }

    public UrlRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}