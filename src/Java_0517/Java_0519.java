package Java_0517;

public class Java_0519 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] ch = word.toCharArray();
            for(int i = 0 ; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(helper(board,ch,i,j,0)) {
                        return true;
                    }
                }
            }
            return false;
        }
        public boolean helper(char[][] board,char[] ch,int i,int j,int k) {
            if(i >= board.length || i < 0 ||
                    j >= board[0].length || j < 0 ||
                    board[i][j] != ch[k]
                    ) {
                return false;
            }
            if(k == ch.length - 1) {
                return true;
            }
            char tmp = board[i][j];
            board[i][j] = '/';
            boolean ret =   helper(board,ch,i+1,j,k+1) ||
                    helper(board,ch,i-1,j,k+1) ||
                    helper(board,ch,i,j+1,k+1) ||
                    helper(board,ch,i,j-1,k+1);
            board[i][j] = tmp;
            return ret;
        }
    }
}
