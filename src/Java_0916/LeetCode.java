package Java_0916;

import java.util.*;
public class LeetCode{
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while(sc.hasNextLine()) {
                String str1 = sc.nextLine();
                String str2 = sc.nextLine();

            }
    }

    public class Solution {
        /**
         *
         * @param grid char字符型二维数组
         * @return int整型
         */
        public int numIslands (char[][] grid) {
            // write code here
            if(grid.length == 0 || grid[0].length == 0) {
                return  0;
            }
            grid[0][0] = 'a';
            int count = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid.length; j++) {
                    count += dfs(grid, i , j);
                }
            }
            return count;
        }

        private int dfs(char[][] grid, int i, int j) {
            if(!inArea(grid, i , j)) {
                return 0;
            }
            char[][] a = new char[2][2];
            if(grid[i][j] == '0') {
                return 0;
            }
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            grid[i][j] = '0';
            return 1;
        }

        private boolean inArea(char[][] grid, int i, int j) {
            return i < grid.length && i >= 0 && j < grid[0].length && j >= 0;
        }
    }
}


// Grwoing二叉树的构建, 二叉树的度, 岛屿问题 两个字符串的最长公共子字符串