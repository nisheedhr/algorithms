package com.array;

import java.util.ArrayList;
import java.util.List;

/*8
 * Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you,
 replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
 */
public class ZigzagIterator {

	private List<List<Integer>> mList = new ArrayList<>();
	private int curIndex;
	
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
         
    	if(!v1.isEmpty()) {
        	 mList.add(v1);
         }
    	
    	if(!v2.isEmpty()) {
       	 mList.add(v2);
        }
    	curIndex = 0;
    }

    public int next() {
        List<Integer> curList = mList.get(curIndex);
        int val = curList.get(0);
        curList.remove(0);
        if (curList.isEmpty()) {
        	mList.remove(curIndex);
        }
        else {
        	curIndex++;
        }
        
        if(curIndex == mList.size()) {
        	curIndex = 0;
        }
        return val;
    }

    public boolean hasNext() {
        return !mList.isEmpty();
    }
}
