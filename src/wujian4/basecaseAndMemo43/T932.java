package wujian4.basecaseAndMemo43;

import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * @author CXWWH
 * @create 2022-09-03-14:33
 * @
 **/
public class T932 {

    // 自底向上方法
    int[][] memo;
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        memo = new int[n][n];

        for(int i = 0; i < n; i++){

            Arrays.fill(memo[i], 66666);
        }

        int res = Integer.MAX_VALUE;
        // 终点可能在最后一行的任意一列
        for(int i = 0; i < n; i++){

            res = Math.min(res, dp(matrix, n-1, i));
        }

        return res;
    }

    public int dp(int[][] matrix, int i, int j){

        int n = matrix.length;
        // 越界检查
        if( i < 0 || j < 0 || i >= n || j >= n){

            return 99999;
        }

        // 自底向上，到达第一行，直接返回
        if( i == 0){

            return matrix[0][j];
        }

        // 如果备忘录中有，那么直接从备忘录中取
        if(memo[i][j] != 66666){

            return memo[i][j];
        }

        memo[i][j] = matrix[i][j] + min(
                dp(matrix, i-1, j),
                dp(matrix, i-1, j-1),
                dp(matrix, i-1, j+1)
        );

        return memo[i][j];
    }

    public int min(int a, int b, int c){

        return Math.min(a, Math.min(b,c));
    }

    // 自顶向下方法
    public int minFallingPathSum2(int[][] matrix) {

        int n = matrix.length;
        int[][] dp = new int[n][n];
        int[] dirs = new int[]{0,-1,1};
        for(int i = 1; i < dp.length; i++){

            Arrays.fill(dp[i], 66666);
        }

        for(int i = 0; i < n; i++){

            dp[0][i] = matrix[0][i];
        }

        // 从第二层到最后一层
        for(int i = 1; i < n; i++){

            // 第i层的所有列
            for(int j = 0; j < n; j++){

                // 选择和当前列相邻的三列
                for(int k = 0; k < 3; k++){

                    int jj = j + dirs[k];
                    if( jj >= 0 && jj < n){

                        // 取当前结果 和 上一层相应位置结果加上matrix[i][j] 的最小值
                        dp[i][j] = Math.min(dp[i][j], (dp[i-1][jj] + matrix[i][j]));
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){

            res = Math.min(res,dp[n-1][i]);
        }

        return res;
    }

    
}
