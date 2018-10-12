package com.sccf.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author qianguobing
 * @date 2018-09-14 15:10
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public RedisUtils() {
    }

    public void setHash(String key, String hashKey, Object value) {
        this.setHash(key, hashKey, value, -1L);
    }

    public void setHash(String key, String hashKey, Object value, long expire) {
        this.redisTemplate.opsForHash().put(key, hashKey, value);
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }

    }

    public <T> T getHash(String key, String hashKey) {
        return this.getHash(key, hashKey, -1L);
    }

    public <T> T getHash(String key, String hashKey, long expire) {
        Object value = this.redisTemplate.opsForHash().get(key, hashKey);
        if (value == null) {
            return null;
        } else {
            if (expire != -1L) {
                this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
            }

            return (T) value;
        }
    }

    public Map<Object, Object> getHashMap(String key, long expire) {
        Map<Object, Object> map = this.redisTemplate.opsForHash().entries(key);
        if (map != null && !map.isEmpty()) {
            if (expire != -1L) {
                this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
            }

            return map;
        } else {
            return null;
        }
    }

    public Map<Object, Object> getHashMap(String key) {
        return this.getHashMap(key, -1L);
    }

    public boolean hasHashKey(String key, String hashKey) {
        return this.redisTemplate.opsForHash().hasKey(key, hashKey).booleanValue();
    }

    public void deleteHash(String key, String... hashKeys) {
        this.redisTemplate.opsForHash().delete(key, hashKeys);
    }

    public void set(String key, Object value, long expire) {
        this.redisTemplate.opsForValue().set(key, (String) value);
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }

    }

    public void set(String key, Object value) {
        this.set(key, value, -1L);
    }

    public <T> T get(String key, long expire) {
        Object value = this.redisTemplate.opsForValue().get(key);
        if (value == null) {
            return null;
        } else {
            if (expire != -1L) {
                this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
            }

            return value == null ? null : (T)value;
        }
    }

    public <T> T get(String key) {
        return this.get(key, -1L);
    }

    public void delete(String key) {
        this.redisTemplate.delete(key);
    }

    public void delete(String... keys) {
        this.redisTemplate.delete(Arrays.asList(keys));
    }

    public boolean exists(String key) {
        return this.redisTemplate.hasKey(key).booleanValue();
    }
}
