package com.practices;


public class KthToLastNode {

	public static class LinkedListNode {

		public String value;
		public LinkedListNode next;

		public LinkedListNode(String value) {
			this.value = value;
		}
	}



	public static void main(String[] args) {

		LinkedListNode a = new LinkedListNode("Angel Food");
		LinkedListNode b = new LinkedListNode("Bundt");
		LinkedListNode c = new LinkedListNode("Cheese");
		LinkedListNode d = new LinkedListNode("Devil's Food");
		LinkedListNode e = new LinkedListNode("Eccles");

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		System.out.println(kthToLastNode(2, a));

	}



	private static String kthToLastNode(int k, LinkedListNode node) {
		LinkedListNode current = node;
		LinkedListNode last = node;
		
	    if (k < 1) {
	        throw new IllegalArgumentException("Impossible to find less than first to last node: " + k);
	    }
	    
		for(int x=1;x<=k;x++) {
	        if (last.next == null) {
	            throw new IllegalArgumentException("k is larger than the length of the linked list: " + k);
	        }
			last=last.next;
		}
		
		while(last!=null) {
			current=current.next;
			last=last.next;
		}
		
		return current.value;
		
	}
}
