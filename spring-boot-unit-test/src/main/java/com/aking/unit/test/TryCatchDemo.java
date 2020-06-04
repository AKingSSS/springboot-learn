package com.aking.unit.test;

/**
 * @ClassName TryCatchDemo
 * @Description
 * @Author yk
 * @Date 2020/6/3 11:21
 * @Version 1.0
 **/
public class TryCatchDemo {
    /**
     * try-catch 在 for 循环内
     *
     * @param forSize
     * @return
     */
    public int innerForeach(int forSize) {
        int count = 0;
        for (int i = 0; i < forSize; i++) {
            try {
                if (i == forSize) {
                    throw new Exception("new Exception");
                }
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    /**
     * try-catch 在 for 循环外
     * @param forSize
     * @return
     */
    public int outerForeach(int forSize) {
        int count = 0;
        try {
            for (int i = 0; i < forSize; i++) {
                if (i == forSize) {
                    throw new Exception("new Exception");
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
