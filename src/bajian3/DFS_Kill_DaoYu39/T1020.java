package bajian3.DFS_Kill_DaoYu39;

/**
 * @author CXWWH
 * @create 2022-08-29-11:43
 * @
 **/
public class T1020 {

    public int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < n; i++){

            dfs(grid, 0, i);
            dfs(grid, m-1, i);
        }

        for(int i = 0; i < m; i++){

            dfs(grid, i, 0);
            dfs(grid, i, n-1);
        }

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if( grid[i][j] == 1){

                    count++;
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
