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

    private final int _maxSize;

    public LRUMap(int maxSize) {
        /**
         * accessOrder false代表按插入顺序 true代表按照访问顺序
         */
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
