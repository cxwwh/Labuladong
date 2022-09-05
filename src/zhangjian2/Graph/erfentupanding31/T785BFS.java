package zhangjian2.Graph.erfentupanding31;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CXWWH
 * @create 2022-07-19-15:45
 * @
 **/
public class T785BFS {

    boolean isErFen = true;
    boolean[] visited;
    boolean[] color;
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];

//        Class<? extends boolean[]> aClass = visited.getClass();
//        Class<? extends boolean[]> aClass1 = color.getClass();
//        System.out.println( "aclass == calsss1?" + aClass.equals(aClass1));//true

        for(int i = 0; i < n; i++){

            if( !visited[i]){

                traverseBFS(graph, i);
            }
        }

        return isErFen;
    }

    public void traverseBFS(int[][] graph, int s){

        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        while( !q.isEmpty() && isErFen){

            int cur = q.poll();
            for(int i : graph[cur]){

                if( !visited[i]){

                    color[i] = !color[cur];
                    visited[i] = true;
                    q.offer(i);
                }else{

                    if( color[i] == color[cur]){

                        isErFen = false;
                        return;
                    }
                }
            }
        }
    }

    @Test
    public void test(){

        int[][] graph = {

                {1,3},
                {0,2},
                {1,3},
                {0,2}
        };

        boolean bipartite = isBipartite(graph);
        System.out.println(bipartite);
    }
}
