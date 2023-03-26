package com.hwh.leet;

import com.hwh.leet.util.ListNode;

import java.util.Arrays;

/**
 * @author hwh
 * @create 2023-03-25 21:47
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Merge_two_ordered_linked_lists_12 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(0, new ListNode(2, new ListNode(4)));
        ListNode list2= new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode mergeTwoLists = mergeTwoLists(list1, list2);
        System.out.println("mergeTwoLists = " + mergeTwoLists);
    }

    /**
     * 答案版本
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        if(list1.val< list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    /**
     * 自己写的比较丑陋
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode mergeListNode=new ListNode(0);
         merge(mergeListNode, list1, list2);
        return mergeListNode.next;
    }
    public static ListNode merge(ListNode merge,ListNode list1, ListNode list2){
        if(list1==null ||list2==null){
            if(list1!=null){
                merge.next=list1;
            }
            else if(list2!=null){
                merge.next=list2;
            }
            return merge;
        }else {
            ListNode node = new ListNode();
            if(list1.val<list2.val){
                node.val= list1.val;
                list1=list1.next;
            }else {
                node.val= list2.val;
                list2=list2.next;
            }
            merge.next=node;
            merge=merge.next;
            return merge(merge,list1,list2);
        }
    }
}
