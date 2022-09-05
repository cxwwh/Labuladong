package zhangjian2.Graph.Kruskal33;

import java.util.Arrays;

/**
 * @author CXWWH
 * @create 2022-07-21-12:40
 * @
 **/
public class T1135 {

    int minimumCost(int n, int[][] connections) {

        UF uf = new UF(n+1);

        Arrays.sort(connections, (a,b)-> (a[2]-b[2]));
        int cost = 0;
        for(int[] connection : connections){

            int x = connection[0];
            int y = connection[1];
            int w = connection[2];

            // 如果这条边的加入会构成环，那么不能加入最小生成树
            if( uf.isConnected(x,y)){

                continue;
            }

            cost += w;
            uf.union(x,y);
        }

        // 节点0未使用，所以应该是有两个连通分量
        return uf.getCount()==2? cost : -1;
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
