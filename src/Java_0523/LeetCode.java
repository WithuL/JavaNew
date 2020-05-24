package Java_0523;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode {

    public static boolean exist(char[][] board, String word) {
        Queue<Character> tmp = new LinkedList<>();
        for(char[] x : board) {
            for(char y : x) {
                tmp.offer(y);
            }
        }

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int j = 0;
            for(; j < (board.length * board[0].length); j++) {
                char a = tmp.poll();
                if(a == c){
                    break;
                }else{
                    tmp.offer(a);
                }
            }
            if(j == (board.length * board[0].length)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
}

















