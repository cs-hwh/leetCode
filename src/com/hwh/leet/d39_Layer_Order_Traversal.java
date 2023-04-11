package com.hwh.leet;

import com.hwh.leet.util.TreeNode;

import java.util.*;

/**
 * @author hwh
 * @create 2023-04-11 10:27
 */
public class d39_Layer_Order_Traversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Deque<TreeNode> deque = new LinkedList<>();


        deque.add(root);
        while (!deque.isEmpty()) {//负责深度下去

            ArrayList<Integer> layer = new ArrayList<>();
            int size = deque.size();

            for (int i = 0; i < size; i++) {//遍历每一层,将一层元素加入队列中
                TreeNode node = deque.poll();//出队当前元素
                layer.add(node.val);
                if (node.left != null) {//添加当前元素的下一层元素
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }

            }
            resultList.add(layer);
        }
        return resultList;
    }

}
