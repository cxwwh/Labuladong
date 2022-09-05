package xuejian1.ErFenSearch_6;

import org.junit.Test;

/**
 * @author CXWWH
 * @create 2022-05-09-14:37
 * @
 **/
public class T875 {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 1000000000+1;

        while( left < right){

            int mid = left + (right - left)/2;

            int time = fx(piles,mid);

            if( time == h){

                right = mid;
            }else if(time < h){//如果消耗的时间小于提供的时间，那么可以放慢速度

                right = mid;
            }else if(time > h){

                left = mid + 1;
            }
        }

        return left;
    }

    public int fx(int []nums, int k){

        int result = 0;

        for(int i = 0; i < nums.length; i++){

            result += nums[i] / k;

            if( nums[i] % k > 0){

                result++;
            }
        }

        return result;
    }

    @Test
    public void test(){

        int[] nums = {30,11,23,4,20};
        int h = 5;

        int speed = minEatingSpeed(nums, h);

        System.out.println(speed);
    }
}
