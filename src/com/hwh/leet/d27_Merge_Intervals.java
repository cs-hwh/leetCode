package com.hwh.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hwh
 * @create 2023-04-05 21:04
 */
public class d27_Merge_Intervals {
    public static void main(String[] args) {
//      int[][] arrs=  merge(new int[][]{{1,3},{8,10},{2,6},{15,18}});
      int[][] arrs=  merge(new int[][]{{1,3},{3,6}});
      for(int[] arr:arrs){
          System.out.println(Arrays.toString(arr));
      }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] tmp=intervals[0];
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
           int[] arr= intervals[i];
            if(tmp[1]>=arr[0]){
                tmp[1]=Math.max(tmp[1],arr[1]);
            }else {
                list.add(tmp);
                tmp=arr;
            }
        }
       list.add(tmp);
        return list.toArray(new int[list.size()][]);
    }
}
