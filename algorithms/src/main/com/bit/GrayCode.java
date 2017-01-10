package com.bit;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {

    /**
     * Each succesive bits differ by 1 bit.
     * Can be built reflectively from previous level.
     * By adding 0 to all elements in previous level and adding 1 to reverse of previous level.
     * Max value is 2^n -1 .
     * for loop i < 1 << n which is 2 ^ n
     * i /2 is i >> 1
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}
