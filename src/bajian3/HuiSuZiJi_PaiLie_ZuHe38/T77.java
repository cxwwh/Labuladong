package bajian3.HuiSuZiJi_PaiLie_ZuHe38;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-08-23-11:30
 * @
 **/
public class T77 {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {

        backTrack(n,k,1);
        return result;
    }

    public void backTrack(int n, int k, int start){

        if( track.size() == k){

            result.add(new LinkedList<>(track));
            return;
        }

        for(int i = start; i <= n; i++){

            track.addLast(i);

            backTrack(n,k,i+1);

            track.removeLast();
        }
    }
}
