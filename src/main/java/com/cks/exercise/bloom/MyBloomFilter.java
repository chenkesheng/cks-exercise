package com.cks.exercise.bloom;

/**
 * @Author: cks
 * @Date: Created by 上午10:55 2021/1/29
 * @Package: com.cks.exercise.bloom
 * @Description:
 */
public class MyBloomFilter {

    private byte[] data;

    private int[] slots;

    /**
     * 初始化容器的大小
     */
    public MyBloomFilter(int num) {
        this.data = new byte[num * 2];
        slots = new int[3];
    }

    /**
     * @Description: 把对应的元素添加待BloomFilter
     */
    public void add(Integer key) {
        /** 计算hash1的函数取模以后的桶为 */
        int location1 = Math.abs(hash1(key) % data.length);
        /** 计算hash2的函数取模以后的桶为 */
        int location2 = Math.abs(hash2(key) % data.length);
        /** 计算hash3的函数取模以后的桶为 */
        int location3 = Math.abs(hash3(key) % data.length);
        /** 把对应的hash函数的桶位置为1 */
        data[location1] = 1;
        data[location2] = 1;
        data[location3] = 1;

    }

    /**
     * @Description: 判断一个元素是否在布隆过滤器中
     */
    public Boolean contain(Integer key) {
        int location1 = Math.abs(hash1(key) % data.length);
        int location2 = Math.abs(hash2(key) % data.length);
        int location3 = Math.abs(hash3(key) % data.length);
        /** 只要有一个元素部位1，计算结果为0，返回false,否则 计算结果为1，返回true */
        return data[location1] * data[location2] * data[location3] == 1;
    }

    /**
     * @Description: hash1 计算key的hash 值
     */
    public int hash1(Integer key) {
        return key.hashCode();
    }

    /**
     * @Description: hash2 计算key的hash 值
     */
    public int hash2(Integer key) {
        return key.hashCode() ^ (key.hashCode() >>> 3);
    }

    /**
     * @Description: hash3 计算key的hash 值
     */
    public int hash3(Integer key) {
        return key.hashCode() ^ (key.hashCode() >>> 16);
    }

}
