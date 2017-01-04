package com.queue;

import java.util.Arrays;

import org.junit.Test;

public class SlidingWindowMaxTest {

    @Test
    public void testMaxSlidingWindow() throws Exception {
        SlidingWindowMax sm = new SlidingWindowMax();
        int num[] = { 1,3,-1,-3,5,3,6,7 };
        System.out.println(Arrays.toString(sm.maxSlidingWindow(num, 3)));
        
        int num2[] = { 5, 3, 4 };
        System.out.println(Arrays.toString(sm.maxSlidingWindow(num2, 1)));
        
        int num3[] = { 7, 2, 4 };
        System.out.println(Arrays.toString(sm.maxSlidingWindow(num3, 2)));
        
        int num4[] = {1,3,1,2,0,5};
        System.out.println(Arrays.toString(sm.maxSlidingWindow(num4, 3)));
        
        int num5[] = {9,10,9,-7,-4,-8,2,-6};
        System.out.println(Arrays.toString(sm.maxSlidingWindow(num5, 5)));
        
    }

}
