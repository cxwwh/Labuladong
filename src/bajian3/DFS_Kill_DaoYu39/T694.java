package bajian3.DFS_Kill_DaoYu39;

import java.util.HashSet;

/**
 * @author CXWWH
 * @create 2022-08-30-11:45
 * @
 **/
public class T694 {

    public int numDistinctIslands(int[][] grid){

        HashSet<String> isLand = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if( grid[i][j] == 1){

                    StringBuilder sb = new StringBuilder();
                    dfs(grid,i,j,sb,666);
                    isLand.add( sb.toString());
                }
            }
        }

        return isLand.size();
    }

    public void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir){

        int m = grid.length;
        int n = grid[0].length;

        if( i < 0 || j < 0 || i >= m || j >= n || grid[i][j]==0){

            return;
        }

        grid[i][j] = 0;
        sb.append( dir).append(',');// 进入一个岛屿网格

        dfs(grid,i-1,j,sb,1);
        dfs(grid,i+1,j,sb,2);
        dfs(grid,i,j-1,sb,3);
        dfs(grid,i,j+1,sb,4);

        sb.append( -dir).append(',');// 离开一个岛屿网格

    }
}
