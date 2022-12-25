package org.example.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.example.Entity.ChatMessage;
import org.example.Redis.CacheKey;
import org.jboss.jandex.ClassType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.StringTokenizer;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;
    private final ObjectMapper objectMapper;

    public void setRedisTemplateValue(ChatMessage chatMessage) {
        ValueOperations<String, String > stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("sender", chatMessage.getSender());
        stringStringValueOperations.set("context", chatMessage.getContext());
    }

    public void getRedisStringValue(String key) {
        ValueOperations<String, String>stringStringValueOperations = stringRedisTemplate.opsForValue();
        System.out.println(key+":"+stringStringValueOperations.get(key));
    }

    public void setRedisValue(ChatMessage chatMessage) throws JsonProcessingException {
        String key = chatMessage.getSender();
        redisTemplate.opsForValue().set(key, objectMapper.writeValueAsBytes(chatMessage));
    }

    public <T> T getRedisValue(String key, Class<T> classType) throws JsonProcessingException {
        String redisValue = (String)redisTemplate.opsForValue().get(key);

        return objectMapper.readValue(redisValue, classType);
    }
}
