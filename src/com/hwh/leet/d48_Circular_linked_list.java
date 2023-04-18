package com.hwh.leet;

import com.hwh.leet.util.ListNode;

import java.util.HashSet;

/**
 * @author hwh
 * @create 2023-04-18 16:32
 */
public class d48_Circular_linked_list {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (true){
            if(head==null){
                return false;
            }
            if(!set.contains(head)){
                set.add(head);
                head=head.next;
            }else {
                return true;
            }
        }

    }
}
