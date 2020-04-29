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


    //机器人的运动范围
    class Solution {
        //创建成员变量用以记数（记录可以到达的点的个数）
        int count;
        //主程序，只执行一次
        public int movingCount(int m, int n, int k) {
            count = 0;
            //mark用来记录
            int[][] mark = new int[m][n];
            helper(0,0,m,n,k,mark);
            return count;
        }
        public void  helper(int i, int j, int m, int n, int k, int[][] mark) {
            if(i < m && j < n &&
                    i >= 0 && j >= 0 &&
                    mark[i][j] != 1 &&
                    (sum(i) + sum(j) <= k )) {
                count++;
                mark[i][j] = 1;
                helper(i+1,j,m,n,k,mark);
                helper(i,j+1,m,n,k,mark);
                helper(i-1,j,m,n,k,mark);
                helper(i,j-1,m,n,k,mark);
            }
        }
        public int sum(int i ) {
            int sum = 0;
            while(i != 0) {
                sum += i % 10;
                i /= 10;
            }
            return sum;
        }
    }


    //剪绳子

    //这道题比较抽象，这里的解法是要立足于两个推论的：
    //1.一根绳子要被拆剪断并得到最大乘积，那么以相等长度等分为多段，得到的乘积最大
    //2.尽可能将绳子以长度为3等分为多段时，得到的乘积最大
    //注意：有特例！
    //长度为 2 和 3 时不应切分，因为得到的乘积是 n-1;
    //长度为 4 时 (2 + 2) 比 ( 1 + 3) 更优、5 时 应切分为 (2 + 3), 6 以上就应以3为长度进行分配
    class Solution2 {
        public int cuttingRope(int n) {
            //判断是否小于等于3
            if(n <= 3) {
                return n-1;
            }
            //看看 n 是多少个3相乘得到的
            int a = n / 3;
            //看看多余部分是多少
            int b = n % 3;
            if(b == 0) {
                return (int)Math.pow(3,a);
            }
            //如果多 1 直接少乘一个 3 ，将 3 + 1 变成 4 与前面的相乘  （*4比*3*1）优
            if(b == 1) {
                return (int)Math.pow(3,a-1) * 4;
            }
            //如果多2 直接在末尾成个 2
            return (int)Math.pow(3,a) * 2;
        }
    }


    //剪绳子2 进阶版  循环求余
    class Solution3 {
        public int cuttingRope(int n) {
            if(n <= 3) {
                return n-1;
            }
            //题目要求要取余
            int p = 1000000007;
            //设置一个长整型用来暂时保存结果
            long res = 1;
            //求 a ^ 3 的结果，相当于求 a^1 = a*1 , a^2 = a^1 * a , a^3 = a^2 * a;同时取余避免超出数据范围。
            while(n > 4) {
                res = res * 3 % p;
                n -= 3;
            }
            //此时n可以取2、3、4
            return (int)(res * n % p);
        }
    }

    //合并两个排序的链表

    class Solution4 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode cur = head;
            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                }else{
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 == null ? l2 : l1;
            return head.next;
        }
    }

    //对称的二叉树
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
    class Solution5 {
        public boolean isSymmetric(TreeNode root) {
            return isSymmetricHelper(root,root);
        }
        public boolean isSymmetricHelper(TreeNode root1,TreeNode root2) {
            if(root1 == null && root2 == null) {
                return true;
            }
            if(root1 == null || root2 == null) {
                return false;
            }
            return root1.val == root2.val &&
                    isSymmetricHelper(root1.left, root2.right) &&
                    isSymmetricHelper(root1.right, root2.left);
        }
    }

    //树的子结构

    class Solution6 {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return (A != null && B != null) && (
                    help(A,B) ||
                            isSubStructure(A.left,B) ||
                            isSubStructure(A.right,B));
        }
        public boolean help(TreeNode A,TreeNode B) {
            if(B == null) {
                return true;
            }
            if(A == null) {
                return false;
            }
            return (A.val == B.val) && help(A.left,B.left) && help(A.right,B.right);
        }
    }
}
