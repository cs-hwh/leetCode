package com.hwh.leet;

import com.hwh.leet.util.TreeNode;

/**
 * @author hwh
 * @create 2023-04-11 19:14
 */
public class d43_Tree_To_Linked_List{
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(3),
                new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));

        flatten(node);
    }
    public static void flatten(TreeNode root) {
        adjustment(root);
    }
    public static TreeNode adjustment(TreeNode root){
        if(root==null){
            return null;
        }
        //两个返回值都是整理后的最后节点
        TreeNode leftSubtree=adjustment(root.left);//整理左边
        TreeNode rightSubtree=adjustment(root.right);//整理右边
        if(rightSubtree==null&&leftSubtree==null) {
            return root;
        }
        else if(leftSubtree==null){
             return rightSubtree;
        }
       else if(rightSubtree==null){
            root.right=root.left;
            root.left=null;
            return leftSubtree;
        }else {
            //左子树插入到右边
            TreeNode tmp= root.right;
            root.right=root.left;
            leftSubtree.right=tmp;
            root.left=null;
            return rightSubtree;
        }

    }
}

