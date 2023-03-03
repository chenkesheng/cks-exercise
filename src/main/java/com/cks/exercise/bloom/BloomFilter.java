package com.cks.exercise.bloom;

/**
 * @Author: cks
 * @Date: Created by 上午11:00 2021/1/29
 * @Package: com.cks.exercise.bloom
 * @Description:
 */
public class BloomFilter<T> {
    private final int bitSize;
    private final long[] bits;    //保存二进制向量
    private final int hashSize;

    /**
     * 布隆过滤器的构造函数
     *
     * @param numberSize 数据规模
     * @param p          误判率
     */
    public BloomFilter(int numberSize, double p) {
        //pow() 方法可返回 x 的 y 次幂的值。
        this.bitSize = (int) (-numberSize * Math.log(p) / Math.pow(Math.log(2), 2));
        //计算对数
        this.hashSize = (int) (bitSize * Math.log(2) / numberSize);
        //向上取整函数 this.bitSize / 6 优化到 >>
        this.bits = new long[(int) Math.ceil(this.bitSize >> 6)];   //向上取整
    }

    public boolean put(T value) {
        int hashCode1 = value.hashCode();
        int hashCode2 = hashCode1 >> 16;
        boolean result = false;
        for (int i = 0; i < hashSize; i++) {
            int combinedHash = hashCode1 + (i * hashCode2);
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            int index = combinedHash % bitSize;
            if (set(index)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * 设置二进制向量的index位为1, 设置成功返回true, 失败返回false
     */
    private boolean set(int index) {
        boolean result = false;
        int numbersIndex = index / Long.SIZE;
        int numberIndex = index % Long.SIZE;
        //获得某个位的数字---只需要和该位数字为1其他位数字都为0的数进行按位与运算即可
        result = (bits[numbersIndex] & (1L << numberIndex)) == 0;    //如果取出的数字为0表示一定修改成功
        //将某个位的数字设置为1---只需要和该位数字为1其他位数字都为0的数进行按位或运算即可
        bits[numbersIndex] |= (1L << numberIndex);
        return result;
    }

    public boolean contains(T value) {
        int hashCode1 = value.hashCode();
        int hashCode2 = hashCode1 >> 16;
        for (int i = 0; i < hashSize; i++) {
            int combinedHash = hashCode1 + (i * hashCode2);
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            int index = combinedHash % bitSize;
            if (!get(index)) return false;
        }
        return true;
    }

    /**
     * 看二进制向量的index位为是否为1
     */
    private boolean get(int index) {
        int numbersIndex = index / Long.SIZE;
        int numberIndex = index % Long.SIZE;
        return (bits[numbersIndex] & (1L << numberIndex)) != 0;  //按位与取到的位不为0就位true
    }

    public static void main(String[] args) {
        BloomFilter<Integer> bf = new BloomFilter<>(200_0000, 0.01);
        for (int i = 0; i < 200_0000; i++) {
            bf.put(i);
        }
        //        for (int i = 0; i < 200_0000; i++) {
        //            System.out.println(bf.contains(i));
        //        }
        int count = 0;  //统计误判数量
        for (int i = 200_0000; i < 400_0000; i++) {
            if (bf.contains(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
