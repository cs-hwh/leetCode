package com.hwh.leet;

import com.hwh.leet.util.ListNode;

/**
 * @author hwh
 * @create 2023-05-17 22:52
 */
public class d53Intersecting_Linked_Lists {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null ||headB==null){
            return null;
        }
        ListNode pA=headA,pB=headB;
        while (pA!=pB){
            pA=pA==null?headB:pA.next;
            pB=pB==null?headA:pB.next;
        }
        return pA;
    }
}
