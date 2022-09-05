package bajian3.DFS_Kill_DaoYu39;

/**
 * @author CXWWH
 * @create 2022-08-30-11:34
 * @
 **/
public class T1905 {

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int count = 0;
        int m = grid1.length;
        int n = grid1[0].length;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if( grid2[i][j] == 1 && grid1[i][j] == 0){

                    dfs(grid2, i, j);
                }
            }
        }

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if( grid2[i][j] == 1){

                    count++;
                    dfs(grid2, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid, int i, int j){

        int m = grid.length;
        int n = grid[0].length;

        if( i < 0 || j < 0 || i >= m || j >= n){

            return;
        }

        if( grid[i][j] == 0){

            return;
        }

        grid[i][j] = 0;

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);

    }
}
