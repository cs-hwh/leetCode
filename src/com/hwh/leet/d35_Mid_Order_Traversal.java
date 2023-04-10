package com.hwh.leet;

import com.hwh.leet.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hwh
 * @create 2023-04-10 19:01
 * 求树的中序遍历
 */
public class d35_Mid_Order_Traversal {
    public static void main(String[] args) {

    }

    /**
     * 思路深度优先
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(root==null){
            return resultList;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left!=null){
            resultList.addAll(inorderTraversal(left));
        }
        resultList.add(root.val);
        if(right!=null){
            resultList.addAll(inorderTraversal(right));
        }
        return resultList;
    }

}
