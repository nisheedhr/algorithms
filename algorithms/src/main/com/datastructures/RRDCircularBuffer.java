package com.datastructures;

public class RRDCircularBuffer {

	private int[] buff;
	private int numSteps;
	private double average;
	private int min;
	private int max;
	private int curPos;
	private int numValues;

	public RRDCircularBuffer(int numSteps) {
		this.numSteps = numSteps;
		this.buff = new int[numSteps];
		this.average = 0;
		this.min = Integer.MAX_VALUE;
		this.max = Integer.MIN_VALUE;
		this.curPos = 0;
		this.numValues = 0;
	}
	
	public double getAverage() {
		return average;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	void addValue(int value) {
		if (value < min) {
			min = value;
		}
		
		if(value > max) {
			max = value;
		}
		
		if(numValues == numSteps) {
			int oldValue = buff[curPos];
			buff[curPos] = value;
			curPos++;
			average = (average * numSteps - oldValue + value) / numSteps;
		}
		else {
			buff[curPos] = value;
			curPos++;
			average = (average * numSteps  + value) / numSteps;
			numValues++;
		}
		
		if(curPos == numSteps) {
			curPos = 0;
		}
	}
}
