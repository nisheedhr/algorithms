package com.stack;

import java.util.Arrays;

import org.junit.Test;

public class ProductExceptSelfTest {

    @Test
    public void testProductExceptSelf() throws Exception {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(nums)));
    }

}
