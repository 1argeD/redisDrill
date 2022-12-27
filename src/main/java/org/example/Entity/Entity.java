package org.example.Entity;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;


import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@RedisHash(value = "Physiogel", timeToLive = 30)
public class Entity {
    @Id

    private String Id;
    private int ml;
    private String madeIn;
    private LocalDateTime localDateTime;

    public Entity(int ml, String madeIn) {
        this.ml = ml;
        this.madeIn = madeIn;
        this.localDateTime = LocalDateTime.now();
    }
}
