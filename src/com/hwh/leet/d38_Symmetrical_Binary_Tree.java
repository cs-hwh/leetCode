package com.hwh.leet;

import com.hwh.leet.util.TreeNode;

/**
 * @author hwh
 * @create 2023-04-10 20:51
 */
public class d38_Symmetrical_Binary_Tree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        boolean symmetric = isSymmetric(node);
        System.out.println("symmetric = " + symmetric);
    }
    public static boolean isSymmetric(TreeNode root) {
        return LRJudgment(root.left,root.right);
    }
    public static boolean LRJudgment(TreeNode left,TreeNode right){
        if(left==right && left==null){
            return true;
        }
        if(left!=null && right!=null && left.val==right.val){
            return LRJudgment(left.left,right.right)&&LRJudgment(left.right,right.left);
        }else {
            return false;
        }
    }
}
