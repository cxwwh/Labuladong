package wujian5.LongestIncrSubXuLie46;

import java.util.Arrays;

/**
 * @author CXWWH
 * @create 2022-09-05-11:27
 * @
 **/
public class T300 {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i = 0; i < n; i++){

            for(int j = 0; j < i; j++){

                if( nums[i] > nums[j]){

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++){

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
