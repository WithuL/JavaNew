package Java_0509;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode {
//滑动窗口的最大值
    class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length == 0 || k == 0) {
                return new int[0];
            }
//            使用双端队列来完成取最大值的操作
//            队首存放的是当前窗口的最大值
//            队首后面存放的是窗口内大于等于当前窗口最后一个元素的数据
//            这样可以保证如果窗口发生移动，而且队首元素被移除，那么下一个元素是新窗口最大的元素
//
            Deque<Integer> deque = new LinkedList<>();
//            创建最终返回的数组
            int[] res = new int[nums.length - k + 1];
//            设窗口左右边界分别为left,right
//            那么left的取值范围为 [1-k,n-k+1],right的取值范围是 [0,nums.length - 1]；
//            这层循环是还没形成窗口前的情况，即right - left < k；
            for(int i = 0; i < k; i++) {
//                虽然left的取值范围是[1-k,n-k+1],但1-k可能会出现下标越界
//                所以从0开始计算
//                从0开始，如果队列不为空，并且每次窗口向右移动时，会更新队列元素
//                更新规则是队列内小于新增元素的数据全部删除，保持队列降序状态，删除时从后往前删
//                从而保证队首一定是当前窗口最大的元素
                while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.removeLast();
                }
//                完成删除操作后，将新增元素插入到队尾
                deque.addLast(nums[i]);
            }
//            上述循环k次，也已经形成了第一个窗口
//            此时将窗口内最大的元素加入到返回数组中
            res[0] = deque.peekFirst();
//            j为返回数组操作下标
            int j = 1;
//            从这里开始就是已形成窗口时的相关操作
//            那么i将继续从k位置开始，因为上一次已经操作到了k-1的位置
//            这里i代表的是将要插入的元素下标
            for(int i = k; i < nums.length; i++) {
//                每次更新窗口时，因为窗口右移会删除掉原来窗口最左侧的元素
//                所以需要判断原窗口最大元素是不是最左侧的元素
//                如果是的话那么就出队首元素
//                由于i表示的是将要插入的元素下标，并且原窗口最左侧的元素与插入元素之间相隔k个元素
//                所以最原窗口最左侧元素就是nums[i-k]；
                if(deque.peekFirst() == nums[i - k]) {
                    deque.removeFirst();
                }
//                同时在插入的时候要注意删除队列中所有小于插入元素的数据
                while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.removeLast();
                }
//                将新的元素插入
                deque.addLast(nums[i]);
//                将队首元素添加到返回数组中
                res[j++] = deque.peekFirst();
            }
            return res;
        }
    }

//    队列的最大值
class MaxQueue {
//        要每次都能找到队列的最大值
//    就需要使用辅助双端队列进行维护
    Queue<Integer> que = new LinkedList<>();
    Deque<Integer> deq = new LinkedList<>();
    public MaxQueue() {
    }

    public int max_value() {
//        如果队列不为空的话就返回双端队列的对手元素
        return deq.size() > 0 ? deq.peekFirst() : -1;
    }
    public void push_back(int value) {
//    每次入队列的时候先直接将value入到队列中
        que.offer(value);
//        但是双端队列中为了保持双端队列的降序规则则要删除所有小于新插元素的数据
        while(deq.size() > 0 && deq.peekLast() < value) {
            deq.removeLast();
        }
//        最后将新元素入到双端队列尾部
        deq.addLast(value);
    }
//弹出对手元素
    public int pop_front() {
//        先记录队首元素
        int tmp = que.size() > 0 ? que.poll() : -1;
//      如果要删除的队首元素是队列的最大值，则双端队列也要删除队首元素
        if(deq.size() > 0 && tmp == deq.peekFirst()) {
            deq.removeFirst();
        }
        return tmp;
    }
}

}
