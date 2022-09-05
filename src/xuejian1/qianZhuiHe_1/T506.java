package xuejian1.qianZhuiHe_1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-04-28-8:54
 * @
 **/
public class T506 {

    public int subarraySum(int[] nums, int k) {

        int len = nums.length;
        int[] preSum = new int[len+1];

        //preSum[i]中存放的是nums[0]~nums[i-1]的和
        //preSum[j]中存放的是nums[0]~nums[j-1]的和
        //preSum[i] - preSum[j] 结果是nums[j]~nums[i-1]的和
        for(int i = 1; i < preSum.length; i++){

            preSum[i] = preSum[i-1] + nums[i-1];
        }

        int count = 0;
        //preSum[i]中存放的是nums[0]~nums[i-1]的和
        //preSum[j]中存放的是nums[0]~nums[j-1]的和
        //preSum[i] - preSum[j] 结果是nums[j]~nums[i-1]的和
        for(int i = 1; i < preSum.length; i++){

            for(int j = 0; j < i; j++){

                if(preSum[i] - preSum[j] == k){

                    count++;
                }
            }
        }

        return count;
    }

    public int subarraySum2(int[] nums, int k) {

        int len = nums.length;
        Map<Integer,Integer> preSum = new HashMap<>();
//        preSum.put(0,1);

        int count = 0;
        int sum0I = 0;

        for(int i = 0; i < len; i++){

            sum0I += nums[i];

            int sum0J = sum0I - k;

            if( preSum.containsKey(sum0J)){

                count += preSum.get(sum0J);
            }

            preSum.put(sum0I, preSum.getOrDefault(sum0I, 0)+1);
        }

        return count;
    }

    @Test
    public void test(){

        int[] nums = new int[]{1,1,1};
        int k = 2;
        int i = subarraySum2(nums, k);
        System.out.println(i);
    }
}
