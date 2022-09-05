package zhangjian2.Graph.Kruskal33;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-07-21-12:57
 * @
 **/
public class T1584 {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        //将题目给的点的集合转为 各个点之间的边的集合
        // n 个点，两两之间相连，没有环的话，是n-1条边
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < n; i++){

            for(int j = i+1; j < n; j++){

                int distance = getDistance(points[i],points[j]);
                edges.add(new int[]{i, j, distance});
            }
        }

        Collections.sort(edges,(a,b)->{
            return a[2]-b[2];
        });

        // n 个点，两两之间相连，没有环的话，是n-1条边
        UF uf = new UF(n);

        int mst = 0;
        for(int[] edge : edges){

            int a = edge[0];
            int b =edge[1];
            int w = edge[2];

            if( uf.isConnected(a,b)){

                continue;
            }
            mst += w;
            uf.union(a,b);
        }

        return mst;
    }

    public int getDistance(int[] p1, int[] p2){

        int a = Math.abs(p1[0] - p2[0]);
        int b = Math.abs(p1[1] - p2[1]);

        return a+b;
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
