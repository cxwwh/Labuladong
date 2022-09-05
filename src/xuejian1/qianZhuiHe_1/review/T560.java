package xuejian1.qianZhuiHe_1.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-06-10-10:25
 * @
 **/
public class T560 {

    public int subarraySum(int[] nums, int k){

        int count = 0;
        int[] perSum = new int[nums.length + 1];

        for(int i = 1; i < perSum.length; i++){

            perSum[i] = perSum[i-1] + nums[i-1];//perSum[i]为nums[0...i-1]的和
        }

        for(int i = 1; i < perSum.length; i++){

            for(int j = 0; j < i; j++){

                //nums[j...i-1]的和
                if( perSum[i] - perSum[j] == k){

                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k){

        int count = 0;
        Map<Integer, Integer> perSum = new HashMap<>();

        perSum.put(0,1);

        int sumI = 0;
        for(int i = 0; i < nums.length; i++){

            sumI += nums[i];

            int sumJ = sumI - k;

            if( perSum.containsKey(sumJ)){

                count += perSum.get(sumJ);
            }

            perSum.put(sumI, perSum.getOrDefault(sumI,0)+1);
        }

        return count;
    }
}
