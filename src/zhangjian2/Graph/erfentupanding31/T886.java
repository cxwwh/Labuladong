package zhangjian2.Graph.erfentupanding31;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-07-19-12:38
 * @
 **/
public class T886 {

    boolean[] visited;
    boolean[] color;
    boolean canPart = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {

        visited = new boolean[n+1];
        color = new boolean[n+1];
        LinkedList<Integer>[] graph = buildGraph(n, dislikes);

        for(int i = 1; i <= n; i++){

            if( !visited[i]){

                traverse(graph, i);
            }
        }

        return canPart;
    }

    public void traverse(List<Integer>[] graph, int s){

        if( !canPart){

            return;
        }

        visited[s] = true;

        for(int i : graph[s]){

            if( !visited[i]){

                color[i] = !color[s];
                traverse(graph,i);
            }else{

                if( color[i]==color[s]){

                    canPart = false;
                    return;
                }
            }
        }
    }

    public LinkedList<Integer>[] buildGraph(int n, int[][] dislikes){

        LinkedList<Integer>[] graph = new LinkedList[n+1];
        for(int i = 1; i <= n; i++){

            graph[i] = new LinkedList<>();
        }

        for(int[] edge : dislikes){

            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        return graph;
    }
}
