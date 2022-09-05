package zhangjian2.Graph.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author CXWWH
 * @create 2022-07-13-8:30
 * @
 **/
public class T752 {

    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        for( String s : deadends){

            dead.add( s);
        }

        q.offer("0000");
        visited.add("0000");
        int step = 0;

        while( !q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                String cur = q.poll();

                if( dead.contains(cur)){

                    continue;
                }

                if( target.equals(cur)){

                    return step;
                }

                for(int j = 0; j < 4; j++){

                    String up = plusOne(cur,j);
                    if( !visited.contains(up)){

                        q.offer(up);
                        visited.add(up);
                    }

                    String down = minusOne(cur,j);
                    if( !visited.contains(down)){

                        q.offer(down);
                        visited.add(down);
                    }
                }

            }
            step++;
        }

        return -1;
    }

    // 给s.charAt(j)+1
    public String plusOne(String s, int j){

        char[] chars = s.toCharArray();

        if( chars[j] == '9'){

            chars[j] = '0';
        }else{

            chars[j] += 1;
        }

        return new String(chars);
    }

    // 给s.charAt(j)-1
    public String minusOne(String s, int j){

        char[] chars = s.toCharArray();

        if(chars[j] == '0'){

            chars[j] = '9';
        }else{

            chars[j] -= 1;
        }

        return new String(chars);
    }
}
