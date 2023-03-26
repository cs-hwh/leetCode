package com.hwh.leet;

import com.hwh.leet.util.ListNode;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hwh
 * @create 2023-03-26 20:11
 */
public class Merge_K_ascending_linked_lists_14 {
    public static void main(String[] args) {
//        ListNode[] lists=new ListNode[]{
//                new ListNode(1, new ListNode(4, new ListNode(5))),
//                new ListNode(1, new ListNode(3, new ListNode(4))),
//                new ListNode(2, new ListNode(6))
//        };

//        ListNode[] lists=null;
        ListNode[] lists=new ListNode[]{new ListNode(2),null,new ListNode(-1)};
        ListNode node = mergeKLists(lists);
        System.out.println(node);
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=null;
        if(lists==null){
            return null;
        }
        for(int i=0;i<lists.length;i++){
          ans= merge(ans,lists[i]);
        }
        return ans;
    }
    public static ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        else if(lists.length==1){
            return lists[0];
        }else {
            ArrayList<ListNode> nodeList =new ArrayList<>();
            Collections.addAll(nodeList,lists);
            ListNode node1=lists[0];
            ListNode node2=lists[1];
            nodeList.remove(0);
            nodeList.remove(0);
            ListNode node = merge(lists[0], lists[1]);
            nodeList.add(node);
            return mergeKLists(nodeList.toArray(new ListNode[nodeList.size()]));
        }
    }
    //归并合并两个链表
    public static ListNode merge(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        if(list1.val< list2.val){
            list1.next = merge(list1.next, list2);
            return list1;
        }else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }
}
