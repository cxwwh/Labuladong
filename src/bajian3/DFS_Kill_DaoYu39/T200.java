package bajian3.DFS_Kill_DaoYu39;

/**
 * @author CXWWH
 * @create 2022-08-29-10:45
 * @
 **/
public class T200 {

    int[][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if( grid[i][j] == '1'){

                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int x, int y){

        int m = grid.length;
        int n = grid[0].length;

        if( x < 0 || y < 0 || x >= m || y >= n){

            return;
        }

        if( grid[x][y] == '0'){

            return;
        }

        // 淹没当前网格
        grid[x][y] = '0';

        // 淹没当前网格周围的陆地
        for(int k = 0; k < 4; k++){

            int i = x + dirs[k][0];
            int j = y + dirs[k][1];

            dfs(grid, i, j);
        }
    }
}
