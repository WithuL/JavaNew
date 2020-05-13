package Java_0513;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card implements Comparable<Card>{
    //扑克牌
    public String rank ;
    public String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public  boolean equals(Object obj) {
        //首先需要比较身份是否相同
        if(this == obj){
            return true;
        }
        //判断obj是否为空
        if(obj == null) {
            return false;
        }
        //判断obj是否为 Card的实例
        if(!(obj instanceof Card)) {
            return false;
        }
        Card tmp = (Card) obj;
        //比较两张牌的花色和点数是否相同
        return this.rank.equals(((Card) obj).rank) && this.suit.equals(((Card) obj).suit);
    }

    //重写compareTo方法是因为使用Collections.sort方法时会调用Compareble接口的compareTo方法
    //重写后会调用实现Compareble接口的Card内中重写后的compareTo方法
    @Override
    public int compareTo(Card o) {
        //如果o指向的对象为空，则直接返回1
        if(o == null) {
            return 1;
        }
        //把牌面的大小转成数字并进行运算
        int rank1 = this.convertRank();
        int rank2 = o.convertRank();
        //如果从小到大比较就是 this - o;
        return rank1 - rank2;
    }

    //把牌面大小转成整数 3最大，4最小
    private int convertRank() {
        if("J".equals(rank)) {
            return 11;
        }
        if("Q".equals(rank)) {
            return 12;
        }
        if("K".equals(rank)) {
            return 13;
        }
        if("A".equals(rank)) {
            return 14;
        }
        if("1".equals(rank)) {
            return 15;
        }
        if("2".equals(rank)) {
            return 16;
        }
        if("3".equals(rank)) {
            return 17;
        }else{
            return Integer.valueOf(rank);
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "大小：" + rank + '\'' +
                ", 花色：" + suit + '\'' +
                '}';
    }
}

public class Compare{
    public static void main(String[] args) {
        //创建几张牌
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("K","♥"));
        cards.add(new Card("8","♣"));
        cards.add(new Card("6","♦"));
        cards.add(new Card("3","♠"));
        cards.add(new Card("A","♥"));
        Collections.sort(cards);
        //每次使用System.out.println()
        //就会调用Object的toString方法
        //如果toString遇到字符串则会直接输出位字符串
        //如果遇到数字则会转换成字符串再输出
        //如果遇到对象则会直接输出Hash码
        //因此我们需要在Card中重写toString方法
        //使执行sout时调用Card中的toString方法
        System.out.println(cards);
    }
}