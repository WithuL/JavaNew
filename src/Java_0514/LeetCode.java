package Java_0514;

import java.util.*;

public class LeetCode {

    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            //先统计梅哥单词出现的次数
            Map<String,Integer> map = new HashMap<>();
            for(String x : words) {
                //把每个单子和其对应出现的次数放入到map中
                //如果先前x已经出现在map中了，那么就次数+1
                //如果在map中没有找到x，那么就是用默认值0 + 1
                map.put(x,map.getOrDefault(x,0) + 1);
            }
            //把map中所有的单词复制到一个ArrayList中，相当于去重操作
            //并按照降序排序
            List<String> res = new ArrayList<>(map.keySet());
            //使用Collection类中的sort方法时
            //可以直接在sort中传入一个待比较的序列
            //也可以在sort中传入两份内容，一份是带比较的序列，另一份是实现了Comparator接口的对象，该对象一般重写了Comparator的compare方法
            //下方使用匿名内部类的方式
            //即创建了一个类，这个类不知道叫什么名字，但是知道实现了Comparator接口
            //同时在这里从写了compare方法
            //并且同时在这里实例化了一个该类的对象
            Collections.sort(res,new Comparator<String>(){
                @Override
                //在这个匿名内部类中可以直接访问到上面的map变量
                //这个操作叫做变量捕获
                public int compare(String o1, String o2) {
                    //
                    int count1 = map.get(o1);
                    int count2 = map.get(o2);
                    //如果出现次数一样的话
                    //那么就按照String中的ComparaTo方法进行比较
                    //比较规则是按照字母顺序排序
                    if(count1 == count2) {
                        return o1.compareTo(o2);
                    }
                    //让次数多的排在前面
                    return count2 - count1;
                }
            });
            //根据k截取前k个元素
            return res.subList(0,k);
        }
    }
}
