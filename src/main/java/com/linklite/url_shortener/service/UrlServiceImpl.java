package com.linklite.url_shortener.service;

import com.linklite.url_shortener.dto.UrlResponse;
import com.linklite.url_shortener.util.Base62Encoder;
import org.springframework.stereotype.Service;
import com.linklite.url_shortener.repository.UrlRepository;
import java.util.concurrent.atomic.AtomicLong;
import com.linklite.url_shortener.exception.InvalidURLException;
import com.linklite.url_shortener.util.URLValidator;

@Service
public class UrlServiceImpl implements UrlService {

    private final AtomicLong counter = new AtomicLong(1000);
    private final UrlRepository urlRepository;
    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }
    @Override
    public UrlResponse shortenUrl(String originalUrl) {
        if (!URLValidator.isValid(originalUrl)) {
            throw new InvalidURLException("Invalid URL");
        }
        String shortCode = Base62Encoder.encode(counter.getAndIncrement());

        String shortUrl = "http://localhost:8080/" + shortCode;
        urlRepository.save(shortCode, originalUrl, 30);

        return new UrlResponse(shortUrl);
    }
    @Override
    public String getOriginalUrl(String shortCode) {
        return urlRepository.findByShortCode(shortCode);
    }
    @Override
    public void incrementClickCount(String shortCode) {

        urlRepository.incrementClickCount(shortCode);

    }

    @Override
    public Long getClickCount(String shortCode) {

        return urlRepository.getClickCount(shortCode);

    }
}