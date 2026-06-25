package com.cks.exercise.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUMap<K, V> extends LinkedHashMap<K, V> {

    private final int _maxSize;

    public LRUMap(int _maxSize) {
        super(_maxSize + 1, 1, true);
        this._maxSize = _maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        if (this.size() > _maxSize) {
            return true;
        }
        return false;
    }
}
