package com.aking.redis.util.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @ClassName BloomFilterTest
 * @Description
 * @Author Python大星
 * @Date 2020/4/13 9:56
 * @Version 1.0
 **/
public class BloomFilterTest {
    /**
     * 预估数据量 100 w
      */
    private static int n = 1000000;
    /**
     * 定义 BloomFilter 对象
     */
    private static BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), n);

    public static void main(String[] args) {
        // 初始化 100 万数据到过滤器中
        for (int i = 0; i < n; i++) {
            bf.put(i);
        }
        // 匹配已在过滤器中的值（看是否有遗漏的值）
        for (int i = 0; i < n; i++) {
            if (!bf.mightContain(i)) {
                System.out.println("i = " + i + "，不在布隆过滤器中");
            }
        }
        // 我们知道布隆过滤器因hash冲突，可能会被误认为是存在布隆过滤器中
        int count = 0;
        for (int j = n; j < n + 10000 ; j++) {
            if (bf.mightContain(j)) {
                count++;
            }
        }
        System.out.println("1 万中有 " + count + " 个数被误认为存在布隆过滤器中");
    }
}
