package com.datastructures;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 * @author nraveend
 *
 */
public class MovingAverage {

	private double oldAverage = 0;
	private int [] window;
	private int curIndex = 0;
	private int oldWindowSize = 0;
    /** 
     * Store an ring buffer of window size. 
     * Store old average. Store new entries into ring buffer at correct poistion.
     * new wverage = old avergae * win size + new value - old value /window size.
     * Initialize your data structure here. 
     * */
    public MovingAverage(int size) {
    	window = new int[size]; 
    }
    
    public double next(int val) {
        int oldVal = window[curIndex];
        double newAverage = 0;
        if(oldWindowSize != window.length) {
        	newAverage = (oldAverage * oldWindowSize  - oldVal + val) / (oldWindowSize +1);
        	oldWindowSize++;
        }
        else {
        	newAverage = (oldAverage * window.length - oldVal + val) / window.length;
        }
        
        window[curIndex] = val;
        curIndex++;
        if(curIndex == window.length) {
        	curIndex = 0;
        }
        
        oldAverage = newAverage;
        return newAverage;
    }
}
