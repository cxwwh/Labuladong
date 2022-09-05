package bajian3.BFS41;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author CXWWH
 * @create 2022-07-17-10:51
 * @
 **/
public class T773 {

    public int slidingPuzzle(int[][] board) {

        int[][] neighbours = new int[][]{
                {1,3},
                {0,4,2},
                {1,5},
                {0,4},
                {3,1,5},
                {4,2}
        };

        String s = new String();
        String target = "123450";

        for(int[] arr : board){

            for(int i : arr){

                s = s+i;
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        visited.add(s);
        int step = 0;

        while( !q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                String str = q.poll();
                if( target.equals(str)){

                    return step;
                }
                int index = str.indexOf('0');
                int[] neighbour = neighbours[index];
                for(int j : neighbour){

                    String swap = swap(str, index, j);
                    if( !visited.contains(swap)){

                        q.offer(swap);
                        visited.add(swap);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    public String swap(String s, int i, int j){

        char[] c = s.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;

        return new String(c);
    }

    @Test
    public void test(){

        int[][] board = {
                {1,2,3},
                {5,4,0}
        };

        int i = slidingPuzzle(board);
        System.out.println(i);
    }
}
