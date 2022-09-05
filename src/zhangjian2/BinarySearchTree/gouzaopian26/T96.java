package zhangjian2.BinarySearchTree.gouzaopian26;

/**
 * @author CXWWH
 * @create 2022-07-06-9:52
 * @
 **/
public class T96 {

    int[][] memo;
    public int numTrees(int n) {

        memo = new int[n+1][n+1];

        return count(1, n);
    }

    public int count(int lo, int hi){

        if( lo > hi){

            return 1;//对于闭区间[lo,hi]，若lo>hi，那么这个闭区间为空，但这也是一种情况，返回1
        }

        if( memo[lo][hi] > 0){

            return memo[lo][hi];
        }

        int res = 0;
        for(int i = lo; i <= hi; i++){

            int left = count(lo, i-1); //以i为根的左子树的排列数
            int right = count(i+1, hi);//以i为根的右子树的排列数

            res += left*right;
        }

        memo[lo][hi] = res;

        return res;
    }
}
