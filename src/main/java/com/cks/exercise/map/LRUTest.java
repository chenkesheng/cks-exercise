package com.cks.exercise.map;

/**
 * @Author: cks
 * @Date: Created by 20:29 2018/9/4
 * @Package: com.cks.exercise.map
 * @Description:
 */
public class LRUTest {
    public static void main(String[] args) {
//        LRUMap<Integer, String> lru = new LRUMap<>(3);
////        lru.put(1, "11");
////        lru.put(2, "11");
//        lru.put(3, "11");
//        lru.put(4, "11");
//        lru.put(5, "11");
//        System.out.println(lru.toString());
////        lru.put(6, "66");
////        lru.get(3);
////        lru.put(7, "77");
////        lru.get(4);
//        lru.get(5);
//        lru.get(4);
//        lru.get(3);
//        System.out.println(lru.toString());
//        System.out.println();

        LRUCached<Integer,String> lruCached = new LRUCached<>(5);
        lruCached.put(1,"a" );
        lruCached.put(2,"b" );
        lruCached.put(3,"c" );
        lruCached.put(4,"d" );
        lruCached.put(5,"e" );
        lruCached.put(6,"f" );
        System.out.println(lruCached.toString());
    }
}
