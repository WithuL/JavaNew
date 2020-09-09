package Java_0808;

public class Test {
    //
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int res = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 1) {
                        int tmp = dfs(grid, i ,j);
                        res = tmp > res ? tmp : res;
                    }
                }
            }
            return res;
        }
        public int dfs(int[][] grid,int i ,int j) {
            if(!inArae(grid, i , j)) {
                return 0;
            }
            if(grid[i][j] == 2) {
                return 0;
            }
            if(grid[i][j] == 0) {
                return 0;
            }
            grid[i][j] = 2;
            return 1 +
                    dfs(grid, i -1, j) +
                    dfs(grid, i, j-1) +
                    dfs(grid, i, j+1) +
                    dfs(grid, i+1, j);
        }
        public boolean inArae(int[][] grid,int i ,int j) {
            if(i >= grid.length || j >= grid[0].length ||i < 0 || j < 0)  {
                return false;
            }
            return true;
        }
    }

    class solution2 {

    }
}
