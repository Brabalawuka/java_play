package com.company.daily_challenge;

import com.company.util.ListNode;

import java.lang.foreign.StructLayout;

public class Q24SwapNodesInPair {

    public ListNode swapPairs(ListNode head) {
        ListNode result = head;
        ListNode prev;
        ListNode current;
        ListNode next;

        prev = null;
        current = head;

        while (true){
            if (current == null){
                break;
            }
            next = current.next;
            if (next == null) {
                break;
            }
            current.next = next.next;
            next.next = current;
            if (prev == null){
                result = next;
            } else {
                prev.next = next;
            }
            prev = current;
            current = current.next;
        }


        return result;

    }
}
