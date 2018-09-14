package com.cks.exercise.map;

import java.util.HashMap;

/**
 * @Author: cks
 * @Date: Created by 9:34 2018/9/13
 * @Package: com.cks.exercise.map
 * @Description:
 */
public class LRUCached<K, V> {

    private final int MAX_CACHE_SIZE;

    private Entry first;

    private Entry last;

    private HashMap<K, Entry<K, V>> hashMap;

    public LRUCached(int cacheSize) {
        this.MAX_CACHE_SIZE = cacheSize;
        hashMap = new HashMap<>();
    }

    private Entry<K, V> getEntry(K key) {
        return hashMap.get(key);
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) first = null;
            else last.next = null;
        }
    }

    private void moveToFirst(Entry entry) {
        if (entry == first) return;
        if (entry.pre != null) entry.pre.next = entry.next;
        if (entry.next != null) entry.next.pre = entry.pre;
        if (entry == last) last = last.pre;

        if (first == null || last == null) {
            first = last = entry;
            return;
        }

        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    public void put(K key, V value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            if (hashMap.size() >= MAX_CACHE_SIZE) {
                hashMap.remove(last.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key, entry);
    }

    public void remove(K key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            if (entry.pre != null) entry.pre.next = entry.next;
            if (entry.next != null) entry.next.pre = entry.pre;
            if (entry == first) first = entry.next;
            if (entry == last) last = entry.pre;
        }
        hashMap.remove(key);
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) return null;
        moveToFirst(entry);
        return entry.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Entry entry = first;
        while (entry != null) {
            sb.append(String.format("%s=%s ", entry.key, entry.value));
            entry = entry.next;
        }
        return sb.toString();
    }

    private class Entry<K, V> {

        Entry pre;
        Entry next;

        K key;
        V value;
    }

}
