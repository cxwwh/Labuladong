package zhangjian2.Graph.tuopupaixu30;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-07-11-11:32
 * @
 **/
public class T207 {

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        List<Integer>[] graph = build(numCourses, prerequisites);

        for(int i = 0; i < numCourses; i++){

            traverse(graph, i);
        }

        return !hasCycle;
    }

    public void traverse(List<Integer>[] graph, int s) {

        if( onPath[s]){
            //出现环
            hasCycle = true;
            return;
        }

        if( visited[s]){

            //如果遍历了,那么不用再遍历一遍，直接往下运行
            return;
        }

        visited[s] = true;
        onPath[s] = true;

        for (int i : graph[s]) {

            traverse(graph, i);
        }
        onPath[s] = false;
    }

    public List<Integer>[] build(int numCourses, int[][] prerequisites){


        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[ numCourses];

        for(int i = 0; i < numCourses; i++){

            graph[i] = new LinkedList<>();
        }

        for(int[] edge : prerequisites) {

            int from = edge[1];
            int to = edge[0];

            // 修完课程from 才能修课程 to
            graph[from].add(to);
        }

        return graph;
    }
}
