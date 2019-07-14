package com.practices;

import java.util.HashMap;

public class Temperatures {
	HashMap<Integer,Integer> mods = new HashMap<Integer,Integer>();
	int min=9999999;
	int max=-999999;
	int mode=9999999;
	double mean;
	int totalSum=0;
	int totalElements=0;
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = Math.min(this.min, min);
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = Math.max(this.max, max);
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {

		if(this.mode==9999999)
			mods.put(9999999, 1);
		
			if(mods.containsKey(mode)) {
				mods.put(mode, mods.get(mode)+1);
			}else {
				mods.put(mode, 1);
			}
			if(mods.get(this.mode)<mods.get(mode))
				this.mode = mode;
	}
	public double getMean() {
		return mean;
	}
	public void setMean(int mean) {

		totalSum+=mean;
		totalElements+=1;
		this.mean = totalSum/totalElements;
	}
	
	public void insert(int temp) {
		setMode(temp);
		setMean(temp);
		setMax(temp);
		setMin(temp);
	}

}
