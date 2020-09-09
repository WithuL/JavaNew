//package Java_0804;
//
//import Java_0501.TreeNode;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//public class Test3 {
//    public List<Integer> preoderTraversel (TreeNode root){
//        List<Integer> res = new ArrayList<>();
//        if(root == null) {
//            return res;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while(!stack.empty()) {
//            TreeNode cur = stack.pop();
//            res.add(cur.val);
//            if(cur.right != null) {
//                stack.push(cur.right);
//            }
//            if(cur.left != null) {
//                stack.push(cur.left);
//            }
//        }
//        return res;
//    }
//
//    public List<Integer> inorderTraversel(TreeNode root) {
//        List<Integer>  res = new ArrayList<>();
//
//    }
//}
