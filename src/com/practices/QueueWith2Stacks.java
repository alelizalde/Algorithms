package com.practices;

import java.util.LinkedList;

public class QueueWith2Stacks {
	public static LinkedList<Integer> stackHold = new LinkedList<Integer>();
	public static LinkedList<Integer> stackIn = new LinkedList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("stackHold:"+stackHold);
		System.out.println("stackIn"+stackIn);

		InQueue(1);

		System.out.println("stackHold:"+stackHold);
		System.out.println("stackIn"+stackIn);

		System.out.println(OutQueue());
		System.out.println("stackHold:"+stackHold);
		System.out.println("stackIn"+stackIn);

		InQueue(2);
		InQueue(4);
		System.out.println("stackHold:"+stackHold);
		System.out.println("stackIn"+stackIn);

		System.out.println(OutQueue());
		System.out.println("stackHold:"+stackHold);
		System.out.println("stackIn"+stackIn);

		InQueue(3);
		System.out.println("stackHold:"+stackHold);
		System.out.println("stackIn"+stackIn);

		System.out.println(OutQueue());

		System.out.println("stackHold:"+stackHold);
		System.out.println("stackIn"+stackIn);

	}

	public static void InQueue(int newValue){
		int i=-1;

		if(stackHold.size()==0) {
			stackIn.add(newValue);
		}else {
			for(i=stackHold.size()-1;i>=0;i--){
				stackIn.add(stackHold.get(i));
			}
			stackHold.clear();
			stackIn.add(newValue);
		}
	}

	public  static int 	OutQueue(){
		if(stackIn.size()==0) return -1;
		int output=-1;
		for(int i=stackIn.size()-1;i>=0;i--){
			if(i==0) {
				output = stackIn.get(i);
			}else {
			stackHold.add(stackIn.get(i));	
			}
		}
		stackIn.clear();
		return output;
	}

}