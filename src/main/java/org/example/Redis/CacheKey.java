package org.example.Redis;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum CacheKey {
    THEATER_SEAT(Key.NOMAL_KEY, 60*60*24),
    TAG(Key.TAG_KEY, 60*10);

    public static final int DEFAULT_EXP = 60;

    public class Key {
        public static final String NOMAL_KEY = "nomals";
        public static final String TAG_KEY = "Tags";
    }

    private final String key;
    private final int exp;
}
