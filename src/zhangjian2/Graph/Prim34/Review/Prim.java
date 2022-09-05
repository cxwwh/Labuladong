package zhangjian2.Graph.Prim34.Review;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author CXWWH
 * @create 2022-07-24-10:13
 * @
 **/
public class Prim {

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
