package com.hwh.leet;

import com.hwh.leet.util.ListNode;
import org.junit.Test;

/**
 * @author hwh
 * @create 2023-03-08 22:17
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */

public class Two_Number_add_02 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(5))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode oldNode = null;
        ListNode insertNode = null;
        ListNode head = new ListNode();
        int carry = 0;//进位
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int val = n1 + n2 + carry;
            carry = 0;
            if (val >= 10) {//如果相加溢出
                val = val % 10;
                carry = 1;
            }
            insertNode = new ListNode(val);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            if (oldNode == null) {
                oldNode = insertNode;
                head = oldNode;
            } else {
                //尾插法
                oldNode.next = insertNode;
                oldNode = insertNode;
            }
        }
        if (carry > 0) {
            oldNode.next = new ListNode(carry);
        }
        return head;
    }
}


