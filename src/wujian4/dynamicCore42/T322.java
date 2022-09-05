package wujian4.dynamicCore42;

import java.util.Arrays;

/**
 * @author CXWWH
 * @create 2022-09-02-11:33
 * @
 **/
public class T322 {

    public int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount + 1];
        Arrays.fill(memo,-2);
        return dp(coins, memo, amount);
    }

    public int dp(int[] coins, int[] memo, int amount){

        if( amount == 0){

            return 0;
        }

        if( amount < 0){

            return -1;
        }

        // 表示已经填充过这个结果了
        if( memo[amount] != -2){

            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for(int coin : coins){

            int subAmount = amount - coin;
            int subRes = dp(coins,memo,subAmount);
            if( subRes == -1){

                continue;
            }
            res = Math.min(res,subRes + 1);
        }

        res = (res == Integer.MAX_VALUE)? -1 : res;
        memo[ amount] = res;
        return res;
    }
}
