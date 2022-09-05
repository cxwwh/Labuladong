package zhangjian2.Graph.tuopupaixu30.review;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-07-12-9:04
 * @
 **/
public class T207 {

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        visited = new boolean[ numCourses];
        onPath = new boolean[ numCourses];
        //创建图
        List<Integer>[] graph = bulid(numCourses, prerequisites);

        for(int i = 0; i < numCourses; i++){

            traverse( graph, i);
        }

        return !hasCycle;
    }

    public List<Integer>[] bulid(int numCourses, int[][] prerequisites){

        List<Integer>[] graph = new LinkedList[ numCourses];

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

        if(onPath[s]){

            hasCycle = true;
            return;
        }

        if( visited[s]){

            hasCycle = true;
            return;
        }

        visited[s] = true;
        onPath[s] = true;

        for(int i : graph[s]){

            traverse(graph, i);
        }

        onPath[s] = false;
    }
}
