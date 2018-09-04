package com.cks.exercise.map;

import java.util.LinkedHashMap;
import java.util.Map.Entry;


/**
 * @Author: cks
 * @Date: Created by 17:13 2018/9/4
 * @Package: com.cks.exercise.map
 * @Description:最近最少使用算法，基于LinkedHashMap实现
 */
public class LRUMap<K, V> extends LinkedHashMap<K, V> {

    private int _maxSize;

    public LRUMap(int maxSize) {
        super(maxSize + 1, 1.0F, true);
        this._maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        if (this.size() > this._maxSize){
            return true;
        }
        return false;
    }
}
