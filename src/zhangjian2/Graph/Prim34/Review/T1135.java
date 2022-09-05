package zhangjian2.Graph.Prim34.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author CXWWH
 * @create 2022-07-24-10:27
 * @
 **/
public class T1135 {

    public int minimumCost(int n, int[][] connections){

        List<int[]>[] graph = new ArrayList[n];
        for(int[] connection : connections){

            int from = connection[0]-1;
            int to = connection[1]-1;
            int w = connection[2];

            graph[from].add(new int[]{from, to, w});
            graph[to].add(new int[]{to, from, w});
        }

        Prim prim = new Prim(graph);

        return prim.allConnected()? prim.getWeight():-1;
    }

    class Prim{

        private PriorityQueue<int[]> pq;
        private boolean[] inMST;
        private int weight;
        private List<int[]>[] graph;

        public Prim(){

        }

        public Prim(List<int[]>[] graph){

            int n = graph.length;
            this.graph = graph;
            this.weight = 0;
            this.inMST = new boolean[n];
            this.pq = new PriorityQueue<>((a,b)->{

                return a[2]-b[2];
            });

            // 从节点0开始遍历
            cut(0);
            inMST[0] = true;

            while( !pq.isEmpty()){

                int[] edge = pq.poll();

                int to = edge[1];
                int w = edge[2];

                if( inMST[to]){

                    continue;
                }

                weight += w;
                cut(to);
                inMST[to] = true;
            }
        }

        public void cut(int s){

            List<int[]> edges = graph[s];
            for(int[] edge : edges){

                int to = edge[1];

                if(inMST[to]){

                    continue;
                }

                pq.offer(edge);
            }
        }

        public int getWeight(){

            return this.weight;
        }

        public boolean allConnected(){

            int n = inMST.length;
            for(int i = 0; i < n; i++){

                if( !inMST[i]){

                    return false;
                }
            }

            return true;
        }
    }
}
