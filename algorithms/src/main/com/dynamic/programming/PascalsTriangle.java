package com.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 * @author nisheedh
 *
 */
public class PascalsTriangle {

    /**
     * Create lits of size k+1.
     * Initialize last element to 1.
     * compute next row from previous row where each elem, a[i] = a[i] + a[i+1]
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> out = new ArrayList<>(rowIndex +1);
        for (int i = 0; i <=rowIndex; ++i) {
            out.add(0);
        }
        out.set(out.size() -1, 1);
        
        for (int i = 1; i <= rowIndex ; ++i) {
            int beg = out.size() -1 -i;
            for (int j = beg; j < out.size() -1; ++j) {
                out.set(j, out.get(j) + out.get(j +1));
            }
        }
        return out;
    }
}
