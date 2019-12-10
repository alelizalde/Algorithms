package com.practices;


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
        a.next = b;
        b.next = c;
        c.next = d;
        LinkedListNode res = reverseList(a);
        while (res != null) {
            System.out.print(res.value + " -> ");
            res = res.next;
        }
    }



    private static LinkedListNode reverseList(LinkedListNode node) {
        LinkedListNode current = node;
        LinkedListNode previous = null;
        LinkedListNode next = null;

        while(current!=null) {
            next=current.next;
            System.out.println(next != null? "next: " + next.value : "next: null");
            current.next=previous;
            System.out.println(current.next != null? "current.next: " + current.next.value : "current.next: null");
            previous = current;
            System.out.println("previous: " + previous.value);
            current=next;
            System.out.println(current != null? "current: " + current.value: "current: null");
        }
        return previous;
    }

}
