package com.hwh.leet;

import com.hwh.leet.util.TreeNode;

/**
 * @author hwh
 * @create 2023-04-10 19:51
 */
public class d37_Verify_Binary_Search_Tree {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    /**
     * 判断这个节点值是否在规定的上下界中
     * @param root
     * @param lower
     * @param upper
     * @return
     */
    public boolean isValidBST(TreeNode root,long lower,long upper){
        if(root==null){
            return true;
        }
        if(root.val<=lower|| root.val>=upper){
            return false;
        }
        //判断左子树修改上界为根节点值
        //判断右子树修改下界为根节点值
        return isValidBST(root.left,lower,root.val)&&isValidBST(root.right,root.val,upper);
    }
}
