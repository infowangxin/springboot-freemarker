package cn.springboot.framework.constant;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 缓存时长
 *
 * @author 胡桃夹子
 * @date 2020-09-21 13:12
 */
public class CacheableKey {

    /**
     * CacheConfig cacheNames
     */
    public static final String BI_SECRET_KEY = "BI_SECRET_KEY";

    public static final long CACHE_1_WEEK = 604800L;
    public static final long CACHE_1_DAY = 86400;
    public static final long CACHE_4_HOUR = 14400;
    public static final long CACHE_2_HOUR = 7200;
    public static final long CACHE_1_HOUR = 3600;
    public static final long CACHE_30_MIN = 1800;
    public static final long CACHE_10_MIN = 600;
    public static final long CACHE_5_MIN = 300;
    public static final long CACHE_1_MIN = 60;
    public static final long CACHE_10_SECOND = 10;
    public static final long CACHE_5_SECOND = 5;

    private static final Map<String, Long> CACHEABLE_KEY_MAP = new LinkedHashMap<>();

    private CacheableKey() {

    }

    static {
        // 设置缓存时长
        CACHEABLE_KEY_MAP.put(BI_SECRET_KEY, CACHE_4_HOUR);
    }

    public static Map<String, Long> getCacheableKeyMap() {
        return CACHEABLE_KEY_MAP;
    }
}
