package zhangjian2.Graph.Kruskal33;

/**
 * @author CXWWH
 * @create 2022-07-22-10:04
 * @
 **/
public class T261Review {

    public boolean validTree(int n, int[][] edges){

        UF uf = new UF(n);

        for(int[] edge : edges){

            int a = edge[0];
            int b = edge[1];

            if( uf.isConnected(a,b)){

                return false;
            }

            uf.union(a,b);
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

        public int findRoot(int x){

            if( x != parent[x]){

                parent[x] = findRoot(parent[x]);
            }

            return parent[x];
        }

        public void union(int p, int q){

            int rootP = findRoot(p);
            int rootQ = findRoot(q);

            if( rootP == rootQ){

                return;
            }

            parent[rootP] = rootQ;
            count--;
        }

        public boolean isConnected(int p, int q){

            int rootP = findRoot(p);
            int rootQ = findRoot(q);

            if( rootP == rootQ){

                return true;
            }

            return false;
        }

        public int getCount(){

            return count;
        }
    }
}
