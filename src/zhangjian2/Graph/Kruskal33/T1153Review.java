package zhangjian2.Graph.Kruskal33;

/**
 * @author CXWWH
 * @create 2022-07-22-10:11
 * @
 **/
public class T1153Review {

    public int minimumCost(int n, int[][] connections) {

        UF uf = new UF(n+1);
        int mst = 0;

        for(int[] connection : connections){

            int a = connection[0];
            int b = connection[1];
            int w = connection[2];

            if( uf.isConnected(a,b)){

                continue;
            }

            mst += w;
            uf.union(a,b);
        }

        return uf.getCount()==2? mst:-1;
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
