package com.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.sort.WiggleSort2;

public class WiggleSort2Test {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testWiggleSort() throws Exception {
    int arr[] = { 1, 1, 1, 1, 4, 5, 6};
    WiggleSort2 ws = new WiggleSort2();
    ws.wiggleSort(arr);
    System.out.println(Arrays.toString(arr));
    
    int arr2[] = { 1, 2, 2, 2, 2, 3, 4, 5};
    ws.wiggleSort(arr2);
    System.out.println(Arrays.toString(arr2));
  }

  @Test
  public void testFindKthLargest() throws Exception {
   int arr[] = {3, 2, 1, 5, 6, 4};
   WiggleSort2 ws = new WiggleSort2();
   assertEquals(5, ws.findKthLargest(arr, 2));
  }

}
