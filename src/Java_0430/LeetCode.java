package Java_0430;

import java.util.*;

public class LeetCode {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //二叉树的镜像
    class Solution1 {
        public TreeNode mirrorTree(TreeNode root) {
            //如果root为空则返回，含义是如果找到叶子结点的时候就开始向上返回 触底
            if (root == null) {
                return null;
            }
            //暂时记录子树的左树，因为下一步操作会先让root原来的左树位置指向原来的右树
            TreeNode tmp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tmp);
            return root;
        }
    }

    //从上到下打印二叉树

    class Solution2 {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            Queue<TreeNode> queue = new LinkedList<>();
            ArrayList<Integer> ret = new ArrayList<>();
            queue.offer(root);
            TreeNode cur;
            while (!queue.isEmpty()) {
                cur = queue.poll();
                ret.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            int[] ans = new int[ret.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = ret.get(i);
            }
            return ans;
        }
    }



    //从上到下打印二叉树2

    class Solution3 {
        List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null) {
                return list;
            }
            list.clear();
            levelOrderHelper(root,0);
            return list;
        }
        public void levelOrderHelper (TreeNode root, int i) {
            if(i == list.size()) {
                list.add(new ArrayList<Integer>());
            }
            List<Integer> cur = list.get(i);
            cur.add(root.val);
            if(root.left != null) {
                levelOrderHelper(root.left,i+1);
            }
            if(root.right != null) {
                levelOrderHelper(root.right,i+1);
            }
        }
    }

    //最小K的个数
    class Solution4 {
        public int[] getLeastNumbers(int[] arr, int k) {
            Arrays.sort(arr);
            return Arrays.copyOfRange(arr,0,k);
        }
    }

    //第一个只出现一次的字符
    class Solution5 {
        public char firstUniqChar(String s) {
            HashMap<Character, Boolean> map = new HashMap<>();
            char[] ch = s.toCharArray();
            for(char x : ch) {
                if(map.containsKey(x)) {
                    map.replace(x,false);
                }else{
                    map.put(x,true);
                }
            }
            for(char x : ch) {
                if(map.get(x)) {
                    return x;
                }
            }
            return ' ';
        }
    }
    //二叉树的深度
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
        }
    }

    //顺时针打印矩阵
    static class Solution6 {
        public static int[] spiralOrder(int[][] matrix) {
            if(matrix.length == 0) {
                return new int[0];
            }
            int[] ret = new int[matrix.length * matrix[0].length];
            int left = 0;
            int right =  matrix[0].length-1;
            int top = 0;
            int bottom = matrix.length - 1;
            int cur = 0;
            while(cur < ret.length) {
                for(int i = top, j = left; j <= right ; j++) {
                    ret[cur++] = matrix[i][j];
                }
                if(++top > bottom) {
                    return ret;
                }
                for(int i = top,j = right; i <= bottom; i++) {
                    ret[cur++] = matrix[i][j];
                }
                if(--right < left) {
                    return ret;
                }
                for(int i = bottom,j = right; j >= left; j--) {
                    ret[cur++] = matrix[i][j];
                }
                if(--bottom < top ) {
                    return ret;
                }
                for(int i = bottom,j = left; i >= top; i--) {
                    ret[cur++] = matrix[i][j];
                }
                if(++left > right ) {
                    return ret;
                }
            }
            return ret;
        }
    }

}













