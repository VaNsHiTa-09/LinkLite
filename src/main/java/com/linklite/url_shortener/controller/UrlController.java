package com.linklite.url_shortener.controller;

import com.linklite.url_shortener.dto.UrlRequest;
import com.linklite.url_shortener.dto.UrlResponse;
import com.linklite.url_shortener.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.linklite.url_shortener.dto.UrlStatsResponse;
@RestController
@RequestMapping("/api/urls")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public UrlResponse shortenUrl(@Valid @RequestBody UrlRequest request) {

        return urlService.shortenUrl(request.getUrl());

    }
    @GetMapping("/stats/{shortCode}")
    public UrlStatsResponse getStats(@PathVariable String shortCode) {

        String originalUrl = urlService.getOriginalUrl(shortCode);
        Long clicks = urlService.getClickCount(shortCode);

        return new UrlStatsResponse(shortCode, originalUrl, clicks);
    }

}