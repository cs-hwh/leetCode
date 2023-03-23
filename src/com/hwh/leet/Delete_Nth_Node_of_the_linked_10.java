package com.hwh.leet;

import com.hwh.leet.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author hwh
 * @create 2023-03-23 21:51
 */

public class Delete_Nth_Node_of_the_linked_10 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(5))));
        ListNode node = removeNthFromEnd(l1, 4);
        System.out.println(node);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node=new ListNode(0,head);
        ListNode first=head;
        ListNode second=node;
        for(int i=0;i<n;i++){
            first=first.next;
        }
        while (first!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;

        return node.next;
    }
    //将链表转为list集合处理
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ArrayList<ListNode> nodeList = new ArrayList<>();
        ListNode node=head;
        while (node!=null){
            nodeList.add(node);
            node=node.next;
        }
        if(nodeList.size()==1){
            return null;
        }
        int index = nodeList.size()-n;
        if(index==0){
            head=head.next;
        }else if(index==nodeList.size()-1){
            nodeList.get(index-1).next=null;
        }else {
            nodeList.get(index-1).next=nodeList.get(index+1);
        }
        return head;
    }

}

