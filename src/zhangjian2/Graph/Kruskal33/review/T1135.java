package zhangjian2.Graph.Kruskal33.review;

import java.util.Arrays;

/**
 * @author CXWWH
 * @create 2022-07-23-21:08
 * @
 **/
public class T1135 {

    public int minimumCost(int n, int[][] connections) {

        UF uf = new UF(n+1);
        Arrays.sort(connections,(a,b)->{

            return a[2] - b[2];
        });
        int weight = 0;
        for(int[] connection : connections){

            int p = connection[0];
            int q = connection[1];
            int w = connection[2];

            if( uf.isConnected(p,q)){

                continue;
            }

            uf.union(p,q);
            weight += w;
        }

        return uf.getCount() == 2? weight : -1;
    }

    class UF{

        private int count;
        private int[] parent;

        public UF(){};

        public UF(int n){

            this.count = n;
            parent = new int[n];

            for(int i = 0; i < n; i++){

                parent[i] = i;
            }
        }

        public int findInt(int x){

            if( x != parent[x]){

                parent[x] = findInt(parent[x]);
            }

            return parent[x];
        }

        public void union(int p, int q){

            int rootP = findInt(p);
            int rootQ = findInt(q);

            if( rootP == rootQ){

                return;
            }

            parent[rootP] = rootQ;
            count--;
        }

        public int getCount(){

            return this.count;
        }

        public boolean isConnected(int p, int q){

            int rootP = findInt(p);
            int rootQ = findInt(q);

            if( rootP == rootQ){

                return true;
            }

            return false;
        }
    }
}
