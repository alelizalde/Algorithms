package com.practices;

import java.util.Iterator;
import java.util.Stack;

public class MaxStack {

    private Stack<Integer> stack     = new Stack<>();
    private Stack<Integer> maxesStack = new Stack<>();

    // Add a new item to the top of our stack. If the item is greater
    // than or equal to the last item in maxesStack, it's
    // the new max! So we'll add it to maxesStack.
    public void push(int item) {
        stack.push(item);
        
        Iterator<Integer> it = stack.iterator();
        System.out.println("--stack--");
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
        
        System.out.println("----");
        if (maxesStack.empty() || item >= maxesStack.peek()) {
            maxesStack.push(item);
        }
        
        it = maxesStack.iterator();
        System.out.println("--maxesStack--");
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
        System.out.println("----");
    }

    // Remove and return the top item from our stack. If it equals
    // the top item in maxesStack, they must have been pushed in together.
    // So we'll pop it out of maxesStack too.
    public int pop() {
        int item = stack.pop();
        
        Iterator<Integer> it = stack.iterator();
        System.out.println("--stack--");
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
        
        if (item == maxesStack.peek()) {
            maxesStack.pop();
        }

        it = maxesStack.iterator();
        System.out.println("--maxesStack--");
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
        
        return item;
    }

    // The last item in maxesStack is the max item in our stack.
    public int getMax() {
        return maxesStack.peek();
    }
}