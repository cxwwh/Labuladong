package zhangjian2.Graph.UnionFind32;

/**
 * @author CXWWH
 * @create 2022-07-20-11:22
 * @
 **/
public class T130 {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        UF uf = new UF(m*n+1);
        int dummy = m*n;

        //将第一列和最后一列的 O 和 dummy连通
        for(int i = 0; i < m; i++){

            if( board[i][0] == 'O'){

                uf.union(i*n, dummy);
            }

            if( board[i][n-1] == 'O'){

                uf.union(i*n + n-1, dummy);
            }
        }

        //将第一行和最后一行的 O 和 dummy连通
        for(int i = 0; i < n; i++){

            if( board[0][i] == 'O'){

                uf.union(i,dummy);
            }

            if( board[m-1][i] == 'O'){

                uf.union((m-1)*n + i,dummy);
            }
        }

        //设置方向数组d
        int[][] d = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };

        //将二维矩阵中相邻的 O 进行联通
        for(int i = 1; i < (m-1); i++){

            for(int j = 1; j < (n-1); j++){

                if( board[i][j] == 'O'){

                    for(int k = 0; k < 4; k++){

                        int x = i + d[k][0];
                        int y = j + d[k][1];

                        if( board[x][y] == 'O'){

                            uf.union(x*n+y,i*n+j);
                        }
                    }
                }
            }
        }

        //将图中不在边界上以及不与边界上的 O 替换为 X
        //根据连通性判断
        for(int i = 1; i < (m-1); i++){

            for(int j = 1; j < (n-1); j++){

                if( board[i][j] == 'O' && !uf.isConnected(i*n+j, dummy)){

                    board[i][j] = 'X';
                }
            }
        }
    }

    class UF{

        //记录连通分量的个数
        private int count;

        //记录图中每个节点的父节点
        private int[] parent;

        public UF(){

        }

        /**
         * n为图中节点的个数
         * @param n
         */
        public UF(int n){

            this.count = n;
            parent = new int[n];
            for(int i = 0; i < n; i++){

                //初始时，每个节点的父节点是他本身
                parent[i] = i;
            }
        }

        /**
         * 将两个节点进行连通
         * @param p
         * @param q
         */
        public void union(int p, int q){

            int rootP = findRoot(p);
            int rootQ = findRoot(q);

            if( rootP==rootQ){

                //若已连通，则直接返回
                return;
            }

            //将两个节点连通，同时让图中的连通分量-1
            parent[rootP] = rootQ;
            count--;
        }

        /**
         * 寻找节点x所在树的根节点
         * @param x
         * @return
         */
        public int findRoot(int x){

            if( x != parent[x]){

                parent[x] = findRoot(parent[x]);
            }

            return parent[x];
        }

        /**
         * 判断两个节点是否连通
         * @param p
         * @param q
         * @return
         */
        public boolean isConnected(int p, int q){

            int rootP = findRoot(p);
            int rootQ = findRoot(q);

            return rootP==rootQ;
        }

        /**
         * 得到图中连通分量的个数
         * @return
         */
        public int getCount(){

            return this.count;
        }
    }
}
