package com.examples;


public class ReverseList {

	public static class LinkedListNode {

		public String value;
		public LinkedListNode next;

		public LinkedListNode(String value) {
			this.value = value;
		}
	}



	public static void main(String[] args) {
		LinkedListNode a = new LinkedListNode("A");
		LinkedListNode b = new LinkedListNode("B");
		LinkedListNode c = new LinkedListNode("C");
		LinkedListNode d = new LinkedListNode("D");
		a.next=b;
		b.next=c;
		c.next=d;
		System.out.println(reverseList(a).value);

	}



	private static LinkedListNode reverseList(LinkedListNode node) {
		LinkedListNode current = node;
		LinkedListNode previous = null;
		LinkedListNode next = null;
		
		while(current!=null) {
			next=current.next;
			//System.out.println("node value: "+node.value);
			//System.out.println("node next: "+node.next.value);
			current.next=previous;
			previous = current;
			current=next;
			//System.out.println("node value: "+node.value);
			//System.out.println("node next: "+node.next.value);
		}
		return previous;
	}



}
