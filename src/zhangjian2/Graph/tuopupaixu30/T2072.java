package zhangjian2.Graph.tuopupaixu30;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CXWWH
 * @create 2022-07-18-14:48
 * @
 **/
public class T2072 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        LinkedList<Integer>[] graph = build(numCourses,prerequisites);
        int[] inDegree = new int[numCourses];
        for(int[] edge: prerequisites){

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
        int count = 0;
        while( !q.isEmpty()){

            int s = q.poll();
            count++;

            for(int i : graph[s]){

                inDegree[i]--;
                if( inDegree[i] == 0){

                    q.offer(i);
                }
            }
        }

        return (count == numCourses);
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
