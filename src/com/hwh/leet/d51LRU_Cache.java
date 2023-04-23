package com.hwh.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hwh
 * @create 2023-04-23 11:26
 */
public class d51LRU_Cache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
            lRUCache.put(1,2);
            lRUCache.put(1,1);
        System.out.println(lRUCache.get(2));
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        System.out.println(lRUCache.get(1));    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        System.out.println(lRUCache.get(1));// 返回 -1 (未找到)
//        System.out.println(lRUCache.get(3));// 返回 3
//        System.out.println(lRUCache.get(4));// 返回 4
        Map map = lRUCache.getMap();
        LRUCache.DLinkedNode head = lRUCache.getHead();
    }

   static class LRUCache {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            DLinkedNode() {
            }

            DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }


        private Map<Integer, DLinkedNode> map;
        private Integer size;
        private Integer capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.map = new HashMap();
            this.capacity = capacity;
            this.size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                DLinkedNode node = map.get(key);
                //将node从当前位置移出来
                node.prev.next = node.next;//修改node前节点的后指针
                node.next.prev = node.prev;//修改node后节点的前指针
                //将node放在head的后面，表式最新使用的
                head.next.prev = node;//修改head后节点的前指针
                node.next = head.next;//修改node后指针
                node.prev = head;
                head.next = node;

                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {

            if(map.containsKey(key)){//如果key是存在的,则替换
                DLinkedNode node = map.get(key);
                node.value=value;
                //将node从当前位置移出来
                node.prev.next = node.next;//修改node前节点的后指针
                node.next.prev = node.prev;//修改node后节点的前指针
                //将node放在head的后面，表式最新使用的
                head.next.prev = node;//修改head后节点的前指针
                node.next = head.next;//修改node后指针
                node.prev = head;
                head.next = node;
            }else {//如果key不存在,则插入
                if(size>=capacity){//缓存已满
                    map.remove(tail.prev.key);//移除map中的记录
                    //移除最久未使用的
                    tail.prev.prev.next=tail;
                    tail.prev=tail.prev.prev;
                    size--;
                }
                DLinkedNode node = new DLinkedNode(key, value);
                head.next.prev = node;//修改head后节点的前指针
                node.next = head.next;//修改node后指针
                node.prev = head;
                head.next = node;
                map.put(key,node);
                size++;
            }
        }
        public Map getMap(){
            return map;
        }
        public DLinkedNode getHead(){
            return head;
        }
    }
}

