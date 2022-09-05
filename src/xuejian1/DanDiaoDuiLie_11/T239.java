package xuejian1.DanDiaoDuiLie_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-05-16-15:42
 * @
 **/
public class T239 {

    //自己写的，逻辑没有错
    //但是提交的时候超时了
    public int[] maxSlidingWindow(int[] nums, int k) {
        if( k == 1){

            return nums;
        }

        if( k == nums.length){

            Arrays.sort(nums);
            return new int[]{nums[nums.length-1]};
        }

        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = k-1;
        while( right < nums.length){

            int max = nums[left];
            for(int i = left+1; i <= right; i++){

                if( nums[i] > max){

                    max = nums[i];
                }
            }
            list.add(max);
            left++;
            right++;
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){

            res[i] = list.get(i);
        }

        return res;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {

        MonotonicQueue window = new MonotonicQueue();
        int len = nums.length;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < len; i++){

            if( i < (k-1) ){

                window.push(nums[i]);
            }else{

                window.push(nums[i]);
                list.add( window.getMax());
                window.pop(nums[i-k+1]);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){

            res[i] = list.get(i);
        }

        return res;
    }

    //单调队列
    //先进先出，进队列的时候从尾部进，出队列的时候从头部出
    class MonotonicQueue{

        //双链表，支持在头部和尾部增删元素
        private LinkedList<Integer> list = new LinkedList<>();

        //将数值n放入单调队列尾，同时保证队列是 单调递减 的
        //即：从list尾开始，若元素小于n，那么就把这个元素从list中删除
        //直到遇到比n大的，这时将n放到list尾即可
        public void push(int n){

            while( !list.isEmpty() && list.getLast()<n){

                list.pollLast();
            }

            list.addLast(n);
        }

        //取得最大值
        //由于list是单调递减的，所以取得头部的元素即可
        public int getMax(){

            return list.getFirst();
        }

        //在队头删除元素
        public void pop(int n){

            if( n == list.getFirst()){

                list.pollFirst();
            }
        }
    }


    @Test
    public void test(){

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] ints = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(ints));

    }
}
