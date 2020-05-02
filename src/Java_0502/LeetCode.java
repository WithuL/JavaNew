package Java_0502;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LeetCode {
    //字符串的排列
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    //n整数中1出现的次数
    class Solution {
        public int countDigitOne(int n) {
            return help(n);
        }
        public int help(int n) {
            if(n <= 0) {
                return 0;
            }
            String s = String.valueOf(n);
            int high = s.charAt(0) - '0';
            int pow = (int)Math.pow(10,s.length() - 1);
            int last = n - high * pow;
            if(high == 1) {
                return help(pow - 1) + help(last) + last + 1;
            }else{
                return pow + high * help(pow - 1) + help(last);
            }
        }
    }
    //礼物的最大价值
    class Solution3 {
        public int maxValue(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for(int i = 0; i < m; i++ ) {
                for(int j = 0; j < n; j++) {
                    if(i == 0 && j == 0) {
                        continue;
                    }else if(i == 0) {
                        grid[i][j] += grid[i][j-1];
                    }else if(j == 0) {
                        grid[i][j] += grid[i-1][j];
                    }else{
                        grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
                    }
                }
            }
            return grid[m-1][n-1];
        }
    }

    //平衡二叉树
    class Solution4 {
        public boolean isBalanced(TreeNode root) {
            if(root == null) {
                return true;
            }
            if(root.left == null && root.right == null) {
                return true;
            }
            int max1 = max(root.left);
            int max2 = max(root.right);
            return isBalanced(root.left) && isBalanced(root.right) && max1 - max2 >= -1 && max1 - max2 <= 1;
        }
        public int max(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int max1 = max(root.left);
            int max2 = max(root.right);
            return  1 + Math.max(max1,max2);
        }
    }

}
