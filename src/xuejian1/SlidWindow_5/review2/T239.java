package xuejian1.SlidWindow_5.review2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-06-26-19:40
 * @
 **/
public class T239 {

    class MonotonicQueue{

        LinkedList<Integer> q = new LinkedList<>();

        public void push(int num){

            while( !q.isEmpty() && q.getLast()<num){

                q.pollLast();
            }
            q.addLast(num);
        }

        public int getMax(){

            return q.getFirst();
        }

        public void pop(int num){

            if( num == q.getFirst()){

                q.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();
        MonotonicQueue mq = new MonotonicQueue();

        for(int i = 0; i < nums.length; i++){

            if( i < (k-1)){

                mq.push(nums[i]);
            }else{

                mq.push(nums[i]);
                list.add( mq.getMax());
                mq.pop(nums[i-(k-1)]);

            }
        }

        int[] res = new int[ list.size()];

        for( int i = 0; i < list.size(); i++){

            res[i] = list.get(i);
        }

        return res;
    }
}
