package zhangjian2.Graph.Kruskal33.review;

/**
 * @author CXWWH
 * @create 2022-07-23-20:26
 * @
 **/
public class T261 {

    public boolean validTree(int n, int[][] edges){

        UF uf = new UF(n);

        for(int[] edge : edges){

            int p = edge[0];
            int q = edge[1];
            if( uf.isConnected(p,q)){

                return false;
            }

            uf.union(p,q);
        }

        return uf.getCount() == 1;
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
