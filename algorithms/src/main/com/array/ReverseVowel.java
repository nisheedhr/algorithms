package com.array;

public class ReverseVowel {

  public String reverseVowels(String s) {
    char[] arr = s.toCharArray();
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      while (left < right && !isVowel(s.charAt(left))) {
        left++;
      }

      while (right > left && !isVowel(s.charAt(right))) {
        right--;
      }

      if (left < right) {
        arr[left] = s.charAt(right);
        arr[right] = s.charAt(left);
        left++;
        right--;
      }
    }
    return new String(arr);
  }

  private boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'u' || ch == 'o'
        || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
  }
}
