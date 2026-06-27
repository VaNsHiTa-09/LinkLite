package com.linklite.url_shortener.controller;

import com.linklite.url_shortener.service.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedirectController {

    private final UrlService urlService;

    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String originalUrl = urlService.getOriginalUrl(shortCode);

        if (originalUrl == null) {
            return ResponseEntity.notFound().build();
        }

        urlService.incrementClickCount(shortCode);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(java.net.URI.create(originalUrl));

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}