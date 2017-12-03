package com.examples;

public class LinkedListNodev2 {

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

		a.next = b;
		b.next = c;
		System.out.println("value: "+a.value +" next: "+ a.next.value);
		System.out.println("value: "+b.value +" next: "+ b.next.value);
		System.out.println("value: "+c.value);

		deleteNode(b);
		System.out.println("value: "+a.value +" next: "+ a.next.value);
		System.out.println("value: "+c.value);

		LinkedListNode d = new LinkedListNode("A");
		LinkedListNode e = new LinkedListNode("B");
		b.next = d;
		d.next = e;
		e.next = a;

		System.out.println(containsCycle(a));

	}



	private static void deleteNode(LinkedListNode node) {

		if(node.next==null) {
			node.value=null;
		}else {
			LinkedListNode nextNode = node.next;
			node.value = nextNode.value;
			node.next  = nextNode.next;
		}
	}

	public static boolean containsCycle(LinkedListNode firstNode) {

		// start both runners at the beginning
		LinkedListNode slowRunner = firstNode;
		LinkedListNode fastRunner = firstNode;

		// until we hit the end of the list
		while (fastRunner != null && fastRunner.next != null) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			System.out.println("slowRunner:"+slowRunner.value);
			System.out.println("fastRunner: "+fastRunner.value);
			// case: fastRunner is about to "lap" slowRunner
			if (fastRunner == slowRunner) {
				return true;
			}
		}

		// case: fastRunner hit the end of the list
		return false;
	}

}
