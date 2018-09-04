package com.cks.exercise.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: cks
 * @Date: Created by 17:13 2018/9/4
 * @Package: com.cks.exercise.map
 * @Description:
 */
public class LRUMap extends LinkedHashMap {

    private int maxSize;

    public LRUMap(int maxSize) {
        super(maxSize + 1, 0, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return maxSize > this.size();
    }
}
