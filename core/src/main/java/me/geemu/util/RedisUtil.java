package me.geemu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public final class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean isExistsValue(final String key) {
        boolean exist = false;
        exist = redisTemplate.hasKey(key);
        return exist;
    }

    /**
     * 获取键对应的值
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }


    /**
     * 指定秒后过期
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean put(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 指定时间过期
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean put(final String key, Object value, Date expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expireAt(key, expireTime);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}