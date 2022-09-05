package bajian3.DFS_Kill_DaoYu39;

/**
 * @author CXWWH
 * @create 2022-08-30-11:21
 * @
 **/
public class T695 {

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if( grid[i][j] == 1){

                    int area = dfs(grid, i, j);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j){

        int m = grid.length;
        int n = grid[0].length;

        if( i < 0 || j < 0 || i >= m || j >= n){

            return 0;
        }

        if( grid[i][j] == 0){

            return 0;
        }

        grid[i][j] = 0;

        // 计算周围的面积
        int a1 = dfs(grid, i-1, j);
        int a2 = dfs(grid, i+1, j);
        int a3 = dfs(grid, i, j-1);
        int a4 = dfs(grid, i, j+1);

        return (1 + a1 + a2 + a3 +a4);// 1 为当前网格的面积
    }
}
