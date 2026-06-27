package com.linklite.url_shortener.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.redis.core.RedisTemplate;

@Repository
public class UrlRepositoryImpl implements UrlRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public UrlRepositoryImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void save(String shortCode,
                     String originalUrl,
                     long minutes) {

        redisTemplate.opsForValue().set(
                shortCode,
                originalUrl,
                minutes,
                java.util.concurrent.TimeUnit.MINUTES
        );
    }

    @Override
    public String findByShortCode(String shortCode) {
        return redisTemplate.opsForValue().get(shortCode);
    }

    @Override
    public void incrementClickCount(String shortCode) {

        redisTemplate.opsForValue().increment(shortCode + ":clicks");

    }

    @Override
    public Long getClickCount(String shortCode) {

        String value = redisTemplate.opsForValue().get(shortCode + ":clicks");

        return value == null ? 0L : Long.parseLong(value);

    }
}