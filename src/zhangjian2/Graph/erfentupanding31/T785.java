package zhangjian2.Graph.erfentupanding31;

/**
 * @author CXWWH
 * @create 2022-07-19-12:38
 * @
 **/
public class T785 {

    boolean[] visited;
    boolean[] color;
    boolean isErFen = true;
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];

        //图不是 连通 的
        for(int i = 0; i < n; i++){

            if( !visited[i]){

                traverse(graph,i);
            }
        }
        return isErFen;
    }

    public void traverse(int[][] graph, int s){

        // 如果不是二分，那么就没必要继续向下判断
        if( !isErFen){

            return;
        }

        visited[s] = true;

        for(int i : graph[s]){

            if( !visited[i]){//说明 i 未遍历

                color[i] = !color[s];
                traverse(graph, i);
            }else{// 此时 i 已经遍历过

                if( color[i] == color[s]){

                    isErFen = false;
                    return;
                }
            }
        }
    }
}
