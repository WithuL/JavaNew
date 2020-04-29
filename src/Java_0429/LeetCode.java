package Java_0429;

public class LeetCode {
    //矩阵中的路径
    public boolean exist(char[][] board, String word) {
        //首先将字符串转成字符数据
        char[] ch = word.toCharArray();
        //然后在board中找到第一个与ch[0]相同的字符，因为如果找不到相同的就会进行循环更新
        for(int i = 0 ; i < board.length; i++) { // 行的更新
            for(int j = 0; j < board[0].length; j++) { //列的更新
                if(helper(board,ch,i,j,0)) { // 找到的第一个与ch[0]相同的字符，如果后续能找到k中所有的值，那么就会返回true
                    return true;
                }
            }
        }
        return false;
    }
    //深度优先搜索 BFS
    public boolean helper(char[][] board,char[] ch,int i,int j,int k) {
        //首先判断数组下标是否合理，i 是行下标，j 是列下标，所以不能超过各自的长度，也不能小于0，
        // 并且如果board中对应下标的元素不等于ch[k]的话也是不满足条件，则都返回false
        if(     i >= board.length || i < 0 ||
                j >= board[0].length || j < 0 ||
                board[i][j] != ch[k]
                                                ) {
            return false;
        }
        //走到这一步说明board[i][j] 等于 ch[k] 并且如果k走到了最后一个下标，则说明board中有ch中所有的元素
        if(k == ch.length - 1) {
            return true;
        }
        //暂存board[i][j]
        char tmp = board[i][j];
        //标记board[i][j]为已经寻找过，下次不可使用
        board[i][j] = '/';
        //下面这一步是分别向下，向上，向右，向左寻找是否有满足条件的下一个值
        //对于第一次寻找来说，可以把这步看成 判断后面是否包括了ch[1] ~ ch[length-1] 的所有元素，如果都包含了ret = true,否则为false;
        boolean ret = helper(board,ch,i+1,j,k+1) ||
                helper(board,ch,i-1,j,k+1) ||
                helper(board,ch,i,j+1,k+1) ||
                helper(board,ch,i,j-1,k+1);
        //上面这步结束后把board[i][j]设置成原来的值
        board[i][j] = tmp;
        return ret;
    }
}
