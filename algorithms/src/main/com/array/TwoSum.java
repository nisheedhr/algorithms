package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * use 2 pointers to compute 2 sum
 * @author nraveend
 *
 */
public class TwoSum {

  List<List<Integer>> sumList(int[] arr, int expectedSum) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(arr);
    int beg = 0;
    int end = arr.length - 1;
    while(beg < end) {
      try {
        int sum = Math.addExact(arr[beg], arr[end]);
        if (sum == expectedSum) {
          List<Integer> pair = new ArrayList<>();
          pair.add(arr[beg]);
          pair.add(arr[end]);
          result.add(pair);
          beg++;
          end--;
        }
        else if (sum > expectedSum) {
          end--;
        }
        else {
          beg++;
        }
      }
      //overflow has happened
      catch ( ArithmeticException ex) {
        //last number triggered overflow as it is near integer maximum
        if (arr[beg] > 0 && arr[end] > 0) {
          end--;
        }
        // first number triggered overflow as it is near integer minimum
        else if (arr[beg] < 0 && arr[end] < 0) {
          beg++;
        }
      }
    }
    return result;
  }
}
