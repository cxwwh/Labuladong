package wujian4.dynamicCore42;

import java.util.Arrays;
import java.util.ConcurrentModificationException;

/**
 * @author CXWWH
 * @create 2022-09-02-14:59
 * @
 **/
public class T322_2 {
    // dp数组的迭代解法
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        // 每个元素的初始值设置为amount + 1，因为正常的话，每个金额使用的硬币数最多就是amount，即全部使用1元的
        // 初始值设置成amount+1 便于后面比较，取最小值
        // 为什么不设置为整型的最大值，取最小值的时候+1会造成溢出
        Arrays.fill(dp,amount+1);

        // base case
        dp[0] = 0;

        for(int i = 0; i < dp.length; i++){

            for(int coin : coins){

                if( (i - coin) < 0){

                    continue;// 说明总额比当前硬币金额还小，不合适
                }

                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return (dp[amount] == amount + 1)? -1 : dp[amount];
    }
}
