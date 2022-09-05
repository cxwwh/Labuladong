package zhangjian2.Graph.tuopupaixu30;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CXWWH
 * @create 2022-07-18-15:00
 * @
 **/
public class T2102 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        LinkedList<Integer>[] graph = build(numCourses,prerequisites);
        int[] inDegree = new int[numCourses];
        for(int[] edge : prerequisites){

            int from = edge[1];
            int to = edge[0];
            inDegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){

            if( inDegree[i] == 0){

                q.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int count = 0;

        while( !q.isEmpty()){

            int cur = q.poll();
            res[count] = cur;
            count++;

            for(int i : graph[cur]){

                inDegree[i]--;
                if( inDegree[i] == 0){

                    q.offer(i);
                }
            }
        }

        if( count != numCourses){

            return new int[]{};
        }

        return res;
    }


    public LinkedList<Integer>[] build(int numCourses, int[][] prerequisites){

        LinkedList<Integer>[] graph = new LinkedList[numCourses];

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
}
