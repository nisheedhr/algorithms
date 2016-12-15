package com.sort;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.sort.WiggleSort;

public class WiggleSortTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testWiggleSort() throws Exception {
    int arr[] = { 3, 5, 2, 1, 6, 4};
    WiggleSort ws = new WiggleSort();
    ws.wiggleSort(arr);
    System.out.println(Arrays.toString(arr));
    int arr2[] = { 3, 3, 3, 3, 5, 6, 8};
    ws.wiggleSort(arr2);
    System.out.println(Arrays.toString(arr2));
    int arr3[] = { 2, 2, 8, 9, 5, 2, 3, 7};
    ws.wiggleSort(arr3);
    System.out.println(Arrays.toString(arr3));
  }

}
