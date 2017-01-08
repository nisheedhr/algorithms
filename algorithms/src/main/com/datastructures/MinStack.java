package com.datastructures;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    List<Integer> elemStack = new ArrayList<>();
    List<Integer> minStack = new ArrayList<>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        elemStack.add(x);
        if (minStack.isEmpty() || x <= minStack.get(minStack.size() -1)) {
            minStack.add(x);
        }
    }
    
    public void pop() {
        if (elemStack.isEmpty()) {
            return;
        }
        int x = elemStack.remove(elemStack.size() -1 );
        if (x == minStack.get(minStack.size() - 1)) {
            minStack.remove(minStack.size() -1);
        }
    }
    
    public int top() {
        if(!elemStack.isEmpty()) {
            return elemStack.get(elemStack.size() - 1);
        } else {
            return -1;
        }
    }
    
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.get(minStack.size() - 1);
        } else {
            return -1;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * i 
*/