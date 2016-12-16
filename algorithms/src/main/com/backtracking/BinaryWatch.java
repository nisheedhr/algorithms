package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom 
 * represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return 
all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 * @author nraveend
 *
 */
public class BinaryWatch {

  /**
   * Build minutes using recursive backtracking.
   * Hours can be hard coded.
   * @param num
   * @return
   */
  public List<String> readBinaryWatch(int num) {
    List<String> res = new ArrayList<>();
    if (num > 8) {
      return res;
    }
    
    for (int i = 0; i <= Math.min(3, num); ++i) {
      List<String> hours = buildHours(i);
      List<String> minutes = buildMinutes(num -i);
      
      for (String hour: hours){
        for (String minute: minutes) {
          StringBuilder sb = new StringBuilder(hour);
          sb.append(":");
          sb.append(minute);
          res.add(sb.toString());
        }
      }
    }
    return res;
  }

  private List<String> buildMinutes(int num) {
    List<String> res = new ArrayList<>();
    if (num == 0) {
      res.add("00");
    } else {
      int curValue = 0;
      int pos = 0;
      int arr[] = {32,16,8,4,2,1};
      recBuildMinutes(curValue,pos, arr, num, res);
    }
    return res;
  }

  private void recBuildMinutes(int curValue, int pos, int[] arr, int num, List<String> res) {
    if (num == 0) {
      if (curValue < 10) {
        StringBuilder sb = new StringBuilder("0");
        sb.append(curValue);
        res.add(sb.toString());
      } else if (curValue < 60) {
        res.add(Integer.toString(curValue));
      }
      return;
    } else if (curValue > 59 || arr.length - pos < num) {
      return;
    } else {
      for (int i = pos; i < arr.length ; ++i) {
        curValue += arr[i];
        recBuildMinutes(curValue, i + 1, arr, num - 1, res);
        curValue -= arr[i];
      }
    }
    
  }

  private List<String> buildHours(int num) {
    List<String> res = new ArrayList<>();
    if (num == 0) {
      res.add("0");
    }
    else if (num ==1) {
      res = Arrays.asList(new String[]{"1","2","4","8"});
    } else if (num ==2) {
      res = Arrays.asList(new String[]{"3","5","9","6", "10"});
    } else if (num ==3) {
      res = Arrays.asList(new String[]{"7", "11"});
    }
    return res;
  }
}
