package wujian4.dynamicCore42;

/**
 * @author CXWWH
 * @create 2022-09-02-10:44
 * @
 **/
public class T509 {

    public int fib(int n) {

        if( n == 0){

            return 0;
        }else if( n == 1){

            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    // 使用备忘录，消除子问题
    public int fib2(int n) {

        int[] memo = new int[n+1];

        return helper(memo, n);
    }

    public int helper(int[] memo, int n){

        if( n == 0 || n == 1){

            return n;
        }

        if( memo[n] != 0){

            return memo[n];
        }

        memo[n] = helper(memo,n-1) + helper(memo, n-2);

        return memo[n];
    }

    // dp数组的迭代/递推
    public int fib3(int n){

        if( n == 0 || n == 1){

            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){

            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
