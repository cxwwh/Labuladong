package zhangjian2.Graph.tuopupaixu30;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-07-12-10:46
 * @
 **/
public class T210 {

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    List<Integer> list = new LinkedList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        List<Integer>[] graph = build(numCourses, prerequisites);
        for(int i = 0; i < numCourses; i++){

            traverse(graph, i);
        }

        if( hasCycle){

            return new int[]{};
        }

        Collections.reverse( list);
        int[] arr = new int[numCourses];

        for(int i = 0; i < numCourses; i++){

            arr[i] = list.get(i);
        }

        return arr;
    }

    public List<Integer>[] build(int numCourses, int[][] prerequisites){

        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i++){

            graph[i] = new LinkedList<>();
        }

        for(int[] edge : prerequisites){

            int from = edge[1];
            int to = edge[0];

            graph[from].add(to);
        }

        return graph;
    }

    public void traverse(List<Integer>[] graph, int s){

        if( onPath[s]){

            hasCycle = true;
            return;
        }

        if( visited[s]){

            return;
        }

        visited[s] = true;
        onPath[s] = true;

        for(int i : graph[s]){

            traverse(graph, i);
        }
        onPath[s] = false;
        list.add(s);
    }
}
