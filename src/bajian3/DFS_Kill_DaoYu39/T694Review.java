package bajian3.DFS_Kill_DaoYu39;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author CXWWH
 * @create 2022-08-31-11:30
 * @
 **/
public class T694Review {

    public int numDistinctIslands(int[][] grid){

        int m = grid.length;
        int n = grid[0].length;
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                StringBuilder sb = new StringBuilder();
                dfs(grid, i, j, sb, 666);
                set.add(sb.toString());
            }
        }

        return set.size();
    }

    public void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir){

        int m = grid.length;
        int n = grid[0].length;

        if( i < 0 || j < 0 || i >= m || j >= n){

            return;
        }

        if( grid[i][j] == 0){

            return;
        }

        grid[i][j] = 0;

        sb.append(dir).append(',');

        dfs(grid,i-1,j,sb,1);
        dfs(grid,i+1,j,sb,2);
        dfs(grid,i,j-1,sb,3);
        dfs(grid,i,j+1,sb,4);

        sb.append(-dir).append(',');

    }

    @Test
    public void test(){

        char a = '9';
        a = (char) (a - 1);

        System.out.println(a);
    }
}
