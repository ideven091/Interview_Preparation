package com.cleo.leetcode.lists;

public class Main {

    public static void main(String[] args) {
        ListNode list = new ListNode(10);
        ListNode head = list;
        list.next = new ListNode(15);

        list=list.next;
        list.next=new ListNode(20);
        list=list.next;

        list.next=new ListNode(25);
        ListNode current=list;
        list=list.next;



        list.next=new ListNode(30);
        list=list.next;
        list.next=current;


        DetectCycle cycle=new DetectCycle();
        if(cycle.detectCycle(head)==null)
            System.out.println("No cycle");
        else
            System.out.println(cycle.detectCycle(head).val);
    }
}
