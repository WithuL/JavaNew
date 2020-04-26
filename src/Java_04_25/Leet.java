package Java_04_25;

public class Leet {

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//二叉树的最近公共祖先
class Solution {

    private TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        findNode(root,p,q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        int left = findNode(root.left,p,q) ? 1 : 0;
        int right = findNode(root.right,p,q) ? 1 : 0 ;
        int mid = (root == p || root == q) ? 1 : 0;
        if(left + right + mid == 2) {
            lca = root;
        }
        return left + right + mid > 0;
    }


    //二叉搜索树与双向链表 牛客
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while(leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if(leftTail != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left != null ? left : pRootOfTree;
    }

    //从前序与中序遍历序列构造二叉树
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        if(inorderLeft >= inorderRight) {
            return null;
        }if(index >= preorder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[index]);
        int pos = find(inorder,inorderLeft,inorderRight,newNode.val);
        index++;
        newNode.left = buildTreeHelper(preorder,inorder,inorderLeft,pos);
        newNode.right = buildTreeHelper(preorder,inorder,pos+1,inorderRight);
        return newNode;
    }

    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for(int i = inorderLeft; i < inorderRight ; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}


