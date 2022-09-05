package zhangjian2.Graph.Dijkstra35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author CXWWH
 * @create 2022-07-24-10:45
 * @
 **/
public class T743 {

    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] graph = buildGraph(n, times);
        int[] distTo = dijkstra(k, graph);

        int res = 0;

        for(int i = 0; i < n; i++){

            // 有节点不可达
            if( distTo[i] == Integer.MAX_VALUE){

                return -1;
            }

            if(res < distTo[i]){

                res = distTo[i];
            }
        }

        return res;
    }

    public int[] dijkstra(int start, List<int[]>[] graph){

        PriorityQueue<State> pq = new PriorityQueue<>((a,b)->{

            return a.distFromStart-b.distFromStart;
        });
        int n = graph.length;
        int[] distTo = new int[n];
        Arrays.fill(distTo, Integer.MAX_VALUE);

        distTo[start-1] = 0;
        pq.offer(new State(start-1,0));

        while( !pq.isEmpty()){

            State cur = pq.poll();
            int curId = cur.nodeID;
            int curDist = cur.distFromStart;

            if( curDist > distTo[curId]){

                continue;
            }

            for(int[] neighbour: graph[curId]){

                int nextId = neighbour[1];
                int time = neighbour[2];
                int distToNextNode = distTo[curId] + time;

                if( distTo[nextId] > distToNextNode){

                    distTo[nextId] = distToNextNode;
                    pq.offer(new State(nextId, distToNextNode));
                }
            }
        }

        return distTo;
    }

    public List<int[]>[] buildGraph(int n, int[][] times){

        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){

            graph[i] = new ArrayList<>();
        }

        for(int[] edge : times){

            int from = edge[0]-1;
            int to = edge[1]-1;
            int time = edge[2];

            graph[from].add(new int[]{from, to, time});
        }

        return graph;
    }

    class State{

        private int nodeID;
        private int distFromStart;

        public State(){

        };

        public State(int id, int dist){

            this.nodeID = id;
            this.distFromStart = dist;
        }
    }
}
