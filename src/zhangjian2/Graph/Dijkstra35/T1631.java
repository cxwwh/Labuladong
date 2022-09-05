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
public class T1631 {

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        // 定义从(0,0)到(i，j)的体力最小消耗为 effortTo[i][j]
        int[][] effortTo = new int[m][n];

        // 初始化为最大整数值
        for(int[] row : effortTo){

            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // 起点到起点的最小消耗就是0
        effortTo[0][0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a,b)->{

            return a.effortFromStart - b.effortFromStart;
        });
        pq.offer(new State(0, 0, 0));

        while( !pq.isEmpty()){

            State cur = pq.poll();
            int curX = cur.x;
            int curY = cur.y;
            int effortFromStart = cur.effortFromStart;

            // 到达终点提前结束
            if( curX == (m-1) && curY == (n-1)){

                return effortFromStart;
            }

            // 如果起点(0,0)到当前位置的最小体力消耗effortFromStart
            // 大于 原来记录的值
            // 那么说明已经有一条更短的 路径 到(x,y)节点了
            if(effortTo[curX][curY] < effortFromStart){

                continue;
            }

            // 获得当前节点的邻居节点
            List<int[]> adjs= adj(heights, curX, curY);
            for(int[] adj : adjs){

                int nextX = adj[0];
                int nextY = adj[1];

                // 计算从(curX,curY)到(nextX,nextY)的体力消耗值
                // 比较从(curX,curY)到(nextX,nextY)的体力消耗值 和 从起点到(curX,curY)耗费的体力值的大小
                // 取大的那个作为起点到(nextX,nextY)耗费的体力值
                int effortToNextNode =
                        Math.max( Math.abs(heights[nextX][nextY] - heights[curX][curY]),
                                effortTo[curX][curY]);

                if( effortTo[nextX][nextY] > effortToNextNode){

                    effortTo[nextX][nextY] = effortToNextNode;
                    pq.offer(new State(nextX,nextY,effortToNextNode));
                }
            }
        }

        return -1;
    }

    // 拿到一个节点的邻居节点
    public List<int[]> adj(int[][] heights, int i, int j){

        int m = heights.length;
        int n = heights[0].length;
        List<int[]> neighbours = new ArrayList<>();

        // 方向数组
        int[][] dirs = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };

        for(int k = 0; k < 4; k++){

            int x = i + dirs[k][0];
            int y = j + dirs[k][1];

            if( x >= m || x < 0 || y >= n || y < 0){

                continue;
            }
            neighbours.add(new int[]{x,y});
        }

        return neighbours;
    }

    class State{

        private int x;
        private int y;

        // 记录从起点到(x,y)节点的最小体力消耗值
        private int effortFromStart;

        public State(){};

        public State(int x, int y, int effortFromStart){

            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }
}
