package xuejian1.ZhongWeiShu_16;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author CXWWH
 * @create 2022-05-21-19:58
 * @
 **/
//T295
public class MedianFinder {

    Queue<Integer> small;
    Queue<Integer> large;

    public MedianFinder() {

        //大顶堆 最大的元素在堆顶  默认情况
        small = new PriorityQueue<>((a,b)->(b-a));

        //小顶堆 最小的元素在堆顶
        large = new PriorityQueue<>((a,b)->(a-b));
    }

    public void addNum(int num) {

        //应该将元素添加到元素数更少的堆中

        //此时应该将元素添加到 small 中
        if( small.size() < large.size()){

            //先添加到large中
            large.offer(num);

            //作为补偿，将large的堆顶元素交给small
            small.offer( large.poll());
        }else{

            //同理
            //此时应该将元素添加到 large 中

            //先添加到small中
            small.offer(num);

            //作为补偿，将small的堆顶元素交给large
            large.offer( small.poll());
        }
    }

    public double findMedian() {

        //如果两堆中元素大小相同，那么就需要去平均数
        if( small.size() == large.size()){

            Integer n1 = small.peek();
            Integer n2 = large.peek();
            return (n1 + n2)/2.0; //注意:返回的是Double类型，要除以2.0
        }

        //返回元素个数更多的堆顶元素
        return small.size()>large.size()? small.peek():large.peek();
    }
}

