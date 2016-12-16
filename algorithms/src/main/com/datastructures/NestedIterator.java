package com.datastructures;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

  private Stack<Iterator<NestedInteger>> iterStack = new Stack<>();
  private NestedInteger cur;

  /**
   * Current value stores a nested value integer.
   * Use stack to point to current iterator of nested list.
   * hasNext should iterate till it finds a current with integer value.
   * @param nestedList
   */
  public NestedIterator(List<NestedInteger> nestedList) {
    if (nestedList != null) {
      iterStack.push(nestedList.iterator());
    }
  }

  @Override
  public Integer next() {
    return cur.getInteger();
  }

  @Override
  public boolean hasNext() {
    // Find next available integer
    while (!iterStack.isEmpty()) {
      // Get next from current iterator
      if (iterStack.peek().hasNext()) {
        cur = iterStack.peek().next();
        if (!cur.isInteger()) {
          iterStack.push(cur.getList().iterator());
        } else {
          break;
        }
      } else {
        //remove current iter if it doesn't have next element
        cur = null;
        iterStack.pop();
      }
    }
    return cur != null;
  }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */