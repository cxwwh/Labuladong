package wujian5.LongestIncrSubXuLie46;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author CXWWH
 * @create 2022-09-05-11:28
 * @
 **/
public class T354 {

    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[0]==o2[0]? o2[1]-o1[1]:o1[0]-o2[0];
            }
        });

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = 0;
        for(int i = 0; i < n; i++){

            for(int j = 0; j < i; j++){

                if(envelopes[i][1] > envelopes[j][1]){

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
