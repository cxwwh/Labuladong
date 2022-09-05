package zhangjian2.Graph.Dijkstra35;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author CXWWH
 * @create 2022-07-24-10:45
 * @
 **/
public class T1514 {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<double[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){

            graph[i] = new ArrayList<>();
        }

        // 注意：图的边数不一定等于图的节点数
        for(int i = 0; i < edges.length; i++){

            int from = edges[i][0];
            int to = edges[i][1];
            double prop = succProb[i];

            graph[from].add(new double[]{to, prop});
            graph[to].add(new double[]{from, prop});
        }

        // 记录从起点到当前节点的概率
        double[] propTo = new double[n];
        for(int i = 0; i < n; i++){

            propTo[i] = -1;
        }

        PriorityQueue<State> pq = new PriorityQueue<>((a,b)->{

            return Double.compare(b.propFromStart,a.propFromStart);
        });
        pq.offer(new State(start, 1));
        propTo[start] = 1;

        while( !pq.isEmpty()){

            State cur = pq.poll();
            int curX = cur.x;
            double startToCur = cur.propFromStart;

            // 到达终点
            if( curX == end){

                return startToCur;
            }

            if( propTo[curX] < startToCur){

                propTo[curX] = startToCur;
            }

            for(double[] next : graph[curX]){

                int nextX = (int) next[0];
                double nextProp = next[1];

                double startToNext = propTo[curX] * nextProp;

                if(propTo[nextX] < startToNext){

                    propTo[nextX] = startToNext;
                    pq.offer(new State(nextX, propTo[nextX]));
                }
            }
        }

        return 0.0;

    }

    class State{

        private int x;
        private double propFromStart;

        public State(){};

        public State(int x, double propFromStart){

            this.x = x;
            this.propFromStart = propFromStart;
        };
    }
}
