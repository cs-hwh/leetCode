package com.hwh.leet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author hwh
 * @create 2023-03-30 19:51
 */
public class Catch_Rain_21 {
    public static void main(String[] args) {
        int result = new Catch_Rain_21().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(result);
    }

    class Arr {
        int i;
        int j;
        int capacity;

        public Arr() {
        }

        public Arr(int i, int j, int capacity) {
            this.i = i;
            this.j = j;
            this.capacity = capacity;
        }

    }

    public int trap(int[] height) {
        int n = height.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int max = -1;
        ArrayList<Arr> list = new ArrayList<>();
        int hinder = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                max = i;
            } else {
                int head = stack.peek();
                if (height[i] <= height[head]) {//如果新加入的柱子比较小
                    stack.push(i);
                } else {//遇到大于的栈顶元素的柱子
                    if (max == head) {//说明两根柱子间没有更小的柱子
                        max = i;
                    } else {//如果两根柱子之间有更小的柱子
                        for (int j = head; j > max; j--) {//积累阻碍值
                            head = j;
                            if (height[head] >= height[i]) {
                                break;
                            }
                            hinder = hinder + height[head];//记录障碍值
                        }
                        if (height[head] < height[i]) {//说明在i与max之间是没有比的i大的了
                            head = max;
                            if (height[i] > height[max]) {
                                max = i;
                            }

                        }
                        int temp = (Math.abs(i - head) - 1) * Math.min(height[head], height[i]) - hinder;
                        Arr arr = new Arr(head, i, temp);
                        list.add(arr);
                        hinder = 0;
                    }
                    stack.push(i);
                }
            }
        }
        //处理下
        int capacity = 0;
        int i=0,l = 0, r = 0, tmp = 0, index = 0;
        boolean b=false;
        while (i<n){
            for(int j=0;j<list.size();j++){
                Arr arr = list.get(j);
                l = arr.i;
                r = arr.j;
                if (l == i) {
                    if (arr.capacity > tmp) {
                        tmp = arr.capacity;
                        index = r;
                        b=true;
                    }
                }
            }
        if(b){
            capacity+=tmp;
            tmp=0;
            i=index;
            b=false;
        }else {
            i++;
        }

        }
        return capacity;
    }
}
