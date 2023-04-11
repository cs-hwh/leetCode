package com.hwh.leet;

import com.hwh.leet.util.TreeNode;

/**
 * @author hwh
 * @create 2023-04-11 17:09
 */
public class d40_Root_Maximum_Depth {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
