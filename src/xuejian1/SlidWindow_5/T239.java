package xuejian1.SlidWindow_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-05-11-14:59
 * @
 **/
public class T239 {

    //自己的方法，超出了时间限制
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
            for(int i = left; i <= right; i++){

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

    @Test
    public void test(){

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] ints = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(ints));
    }
}
