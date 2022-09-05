package bajian3.HuiSuZiJi_PaiLie_ZuHe38;

import org.junit.Test;

import java.util.*;

/**
 * @author CXWWH
 * @create 2022-08-26-12:32
 * @
 **/
public class T216 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        if( k > n){

            return res;
        }
        backTrack(k, n,1);
        return res;
    }

    public void backTrack(int k, int n, int start){

        if( track.size() == k){

            int sum = 0;
            for (Integer integer : track) {

                sum += integer;
            }

            if( sum == n){

                res.add(new LinkedList(track));
                return;
            }

        }

        for(int i = start; i <= 9; i++){

            track.addLast(i);

            backTrack(k, n, i+1);

            track.removeLast();
        }
    }

    @Test
    public void test(){


        List<List<Integer>> lists = combinationSum3(3, 7);
        for (List<Integer> list : lists) {

            System.out.println(list);
        }
    }

}
