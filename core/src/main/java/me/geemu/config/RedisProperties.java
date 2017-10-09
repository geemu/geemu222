package me.geemu.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class RedisProperties {
    @Value("${spring.redis.enable}")
    private boolean enable;
    @Value("${spring.redis.spin}")
    private boolean spin;
    @Value("${spring.redis.lockFailureTime}")
    private Integer lockFailureTime;
    @Value("${spring.redis.storageFailureTime}")
    private Integer storageFailureTime;
    @Value("${spring.redis.spinNum}")
    private Integer spinNum;
    @Value("${spring.redis.spinThreadTime}")
    private Integer spinThreadTime;
}
