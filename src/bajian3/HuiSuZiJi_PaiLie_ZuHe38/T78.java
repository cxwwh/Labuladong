package bajian3.HuiSuZiJi_PaiLie_ZuHe38;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-08-23-10:46
 * @
 **/
public class T78 {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {

        backTrack(nums, 0);
        return result;
    }

    public void backTrack(int[] nums, int start){

        result.add( new LinkedList<>(track));

        for(int i = start; i < nums.length; i++){

            track.addLast(nums[i]);

            backTrack(nums, i+1);
            track.removeLast();
        }
    }
}
