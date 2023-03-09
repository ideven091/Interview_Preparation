package com.cleo.leetcode.lists;

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode slow = head,fast=head;
        while(fast.next!=null){
            if(fast.next.next!=null){
                fast=fast.next.next;
                slow = slow.next;
                if(slow==fast)
                    break;
            }else{
                return null;
            }

        }
        if(fast==null||fast.next==null)
            return null;
        slow = head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
