package com.hwh.leet;

import com.hwh.leet.util.TreeNode;

/**
 * @author hwh
 * @create 2023-04-11 17:21
 * 根据先序和中序遍历得到树
 */
public class d41_Build_Binary_Tree {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if(pStart>pEnd || iStart>iEnd){
            return null;
        }
        int rootVal=preorder[pStart];
        int rootIndex=0;
        for(int i=iStart;i<=iEnd;i++){
            if(inorder[i]==rootVal){//找到根节点的位置
                rootIndex=i;
                break;
            }
        }
        int leftSubtreeSize=rootIndex-iStart;//计算左子树的长度
        TreeNode root = new TreeNode(rootVal);
        root.left=helper(preorder,pStart+1,pStart+leftSubtreeSize,inorder,iStart,rootIndex-1);
        root.right=helper(preorder,pStart+leftSubtreeSize+1,pEnd,inorder,rootIndex+1,iEnd);
        return root;
    }
}
