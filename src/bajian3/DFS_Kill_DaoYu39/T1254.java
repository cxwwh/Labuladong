package bajian3.DFS_Kill_DaoYu39;

/**
 * @author CXWWH
 * @create 2022-08-29-11:26
 * @
 **/
public class T1254 {

    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        // 把 grid的 上边和下边 都淹没
        for(int i = 0; i < n; i++){

            // 淹没第一行
            dfs( grid, 0, i);

            // 淹没最后一行
            dfs( grid, m-1, i);
        }

        // 把 grid的 左边和右边 都淹没
        for(int i = 0; i < m; i++){

            // 淹没第一列
            dfs( grid, i, 0);

            // 淹没最后一列
            dfs( grid, i, n-1);
        }

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                // 发现陆地
                if( grid[i][j] == 0){

                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid, int i, int j){

        int m = grid.length;
        int n = grid[0].length;

        if( i < 0 || j < 0 || i >=m || j >= n){

            return;
        }

        // 已经是水了
        if( grid[i][j] == 1){

            return;
        }

        // 淹没当前网格
        grid[i][j] = 1;

        // 如果当前是陆地，那么还要淹没周围节点
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

    }
}
