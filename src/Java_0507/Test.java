package Java_0507;

import java.util.ArrayList;
import java.util.List;

public class Test {
    // I. 数组中数字出现的次数
    class Solution1 {
        public int[] singleNumbers(int[] nums) {
            int y = 0;
            for(int x : nums) {
                y ^= x;
            }
            int x = 1;
            while((x & y) != 1) {
                x <<= 1;
            }
            int a = 0;
            int b = 0;
            for(int z : nums) {
                if((x & z) == 0) {
                    a = z;
                }else {
                    b = z;
                }
            }
            return new int[] {b,a};
        }
    }
        //8数组中数字出现的次数 II
    class Solution2 {
        public int singleNumber(int[] nums) {
            int[] tmp = new int[32];
            //记录所有数字所有位上1的个数
            for(int x : nums) {
                for(int i = 0 ; i < 32; i++) {
                    //加 x 最后一位1的个数
                    tmp[i] += (x & 1);
                    // x 向右移一位
                    x >>>= 1;
                }
            }
            //其他数都出现了3次，所以各位和是三的倍数
            int res = 0; int m = 3;
            for(int i = 0; i < 32; i++) {
                res <<= 1;
                res |= tmp[31 - i] % m;
            }
            return res;
        }

        // II. 和为s的连续正数序列
        class Solution3{
            public int[][] findContinuousSequence(int target) {
                int i = 1; // 滑动窗口的左边界
                int j = 2; // 滑动窗口的右边界
                int sum = 3; // 滑动窗口中数字的和
                List<int[]> res = new ArrayList<>();
                while(i <= target / 2) {
                    if(sum < target) {
                        j++;
                        sum += j;
                    }else if(sum > target) {
                        sum -= i;
                        i++;
                    }else {
                        int[] arr = new int[j-i+1];
                        int tmp = i;
                        for(int k = 0; k < arr.length; k++) {
                            arr[k] = tmp++;
                        }
                        res.add(arr);
                        sum -= i;
                        i++;
                    }
                }
                return res.toArray(new int[res.size()][]);
            }
        }
        //翻转单词顺序
        class Solution4 {
            public String reverseWords(String s) {
                s = s.trim();
                int i = s.length() - 1;
                int j = i;
                StringBuilder res = new StringBuilder();
                while(i >= 0) {
                    while(i >= 0 && s.charAt(i) != ' ') {
                        i--;
                    }
                    res.append(s.substring(i+1,j+1) + " ");//左闭右开
                    while(i >= 0 && s.charAt(i) == ' ') {
                        i--;
                    }
                    j = i;
                }
                return res.toString().trim();
            }
        }
        //旋转字符串左侧
        class Solution {
            public String reverseLeftWords(String s, int n) {
                StringBuilder res = new StringBuilder();
                res.append(s.substring(n,s.length()));
                return res.append(s.substring(0,n)).toString();
            }
        }

        //从前序与中序遍历序列构造二叉树
        class Solution5 {
            private int index = 0;
            public TreeNode buildTree(int[] preorder, int[] inorder) {
                index = 0;
                return buildTreeHelper(preorder,inorder,0,preorder.length);
            }
            private TreeNode buildTreeHelper(int[] preorder,int[] inorder,int inorderLeft,int inorderRight){
                if(inorderLeft >= inorderRight) {
                    return null;
                }
                if(index >= preorder.length) {
                    return null;
                }
                TreeNode cur = new TreeNode(preorder[index]);
                index++;
                int pos = find(inorder,inorderLeft,inorderRight,cur.val);
                cur.left = buildTreeHelper(preorder,inorder,inorderLeft,pos);
                cur.right = buildTreeHelper(preorder,inorder,pos+1,inorderRight);
                return cur;
            }
            public int find(int[] inorder,int inorderLeft,int inorderRight,int val) {
                for(int i = inorderLeft ; i < inorderRight; i++) {
                    if(inorder[i] == val) {
                        return i;
                    }
                }
                return -1;
            }
        }
    }
}
