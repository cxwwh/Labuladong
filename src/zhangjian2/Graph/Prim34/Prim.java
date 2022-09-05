package zhangjian2.Graph.Prim34;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author CXWWH
 * @create 2022-07-22-11:29
 * @
 **/
public class Prim {

    // 用邻接表表示的图结构
    private List<int[]>[] graph;
    // 用于记录节点是否在生成树中
    private boolean[] inMST;
    // 存储横切边，按照横切边的权重从小到大排序
    private PriorityQueue<int[]> pq;
    // 记录生成树的权重
    private int weight;


    public Prim(){}

    public Prim(List<int[]>[] graph){

        this.graph = graph;

        int n = graph.length;
        inMST = new boolean[n];

        pq = new PriorityQueue<>((a,b)->{

            return a[2] - b[2];
        });

        // 随便选一个节点进行切分就可以，不妨从节点0开始切分
        cut(0);
        inMST[0] = true;

        // 不断进行切分
        while( !pq.isEmpty()){

            int[] poll = pq.poll();

            int to = poll[1];
            int w = poll[2];

            if( inMST[to]){

                // 如果节点 to 已经在最小生成树中，那么就跳过
                // 否则会生成环
                continue;
            }

            weight += w;
            inMST[to] = true;
            cut(to);
        }
    }

    /**
     * 获取生成树的权重
     * @return
     */
    public int getWeight(){

        return this.weight;
    }

    /**
     * 对节点s进行切分
     * @param s
     */
    public void cut(int s){

        // 遍历s的邻边
        for(int[] edge : graph[s]){

            int from = edge[0];
            int to = edge[1];
            int w = edge[2];
            if( inMST[to]){

                continue;
            }
            pq.offer(edge);
        }
    }

    /**
     * 判断最小生成树是否包含所有的节点
     * @return
     */
    public boolean allConnected(){

        for(int i = 0; i < inMST.length; i++){

            if( !inMST[i]){

                return false;
            }
        }

        return true;
    }

}
