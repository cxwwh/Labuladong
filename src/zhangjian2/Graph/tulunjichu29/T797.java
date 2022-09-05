package zhangjian2.Graph.tulunjichu29;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-07-09-8:29
 * @
 **/
public class T797 {

    //用来记录所有路径
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph,0,path);

        return res;
    }

    public void traverse(int[][] graph, int s, LinkedList<Integer> path){

        path.add( s);//将当前节点添加到路径中

        int n = graph.length;
        if( s == (n-1)){

            res.add(new LinkedList<>(path));
        }

        //遍历节点s的每个相邻节点
        for (int v : graph[s]) {

            traverse(graph,v,path);
        }

        //离开节点s的时候，要从路径中把s剔除
        path.removeLast();
    }
}
